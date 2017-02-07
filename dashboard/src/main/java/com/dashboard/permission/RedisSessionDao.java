package com.dashboard.permission;

import com.wyx.service.redis.RedisClientService;
import com.wyx.domain.permission.PmsOperator;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/9/5
 * Time: 上午9:59
 * To change this template use File | Settings | File Templates.
 */
public class RedisSessionDao extends AbstractSessionDAO {

    private static Logger logger = LoggerFactory.getLogger(RedisSessionDao.class);
    /**
     * shiro-redis的session对象前缀
     */
    private final String SHIRO_REDIS_SESSION_PRE = "shiro_redis_session:";

    /**
     * 存放uid的对象前缀
     */
    private final String SHIRO_SHESSIONID_PRE = "shiro_sessionid:";

    /**
     * 存放uid 当前状态的前缀
     */
    private final String UID_PRE = "uid:";

    /**
     * 存放用户权限的前缀
     */
    private final String PERMISSION_PRE = "permission:";
    @Autowired
    private RedisClientService redisClientService;

    private long expire = 3600 * 24;

    @Override
    public void update(Session session) throws UnknownSessionException {
        this.saveSession(session);
    }

    /**
     * save session
     *
     * @param session
     * @throws UnknownSessionException
     */
    private void saveSession(Session session) throws UnknownSessionException {
        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }
        session.setTimeout(expire);
        Long redisExpire = expire;
        int timeout = redisExpire.intValue();

        //保存用户会话
        redisClientService.setx(this.getKey(this.SHIRO_REDIS_SESSION_PRE, session.getId()), session, timeout);
        String uid = this.getUserId(session);
        if (null != uid && !"".equals(uid)) {
            //保存用户会话对应的UID
            redisClientService.setx(this.getKey(this.SHIRO_SHESSIONID_PRE, session.getId()), uid, timeout);
            //保存在线UID
            redisClientService.setx(this.getKey(this.UID_PRE, uid), "online", timeout);
        }


    }

    @Override
    public void delete(Session session) {
        if (session == null || session.getId() == null) {
            logger.error("session or session id is null");
            return;
        }

        //删除用户会话
        redisClientService.del(this.getKey(this.SHIRO_REDIS_SESSION_PRE, session.getId()));
        //获取缓存的用户会话对应的UID
        String uid = (String) redisClientService.get(this.getKey(this.SHIRO_SHESSIONID_PRE, session.getId()));

        //删除用户会话对应的UID
        redisClientService.del(this.getKey(this.SHIRO_SHESSIONID_PRE, session.getId()));

        //删除在线UID
        redisClientService.del(this.getKey(this.UID_PRE, uid));

        //删除用户缓存的权限
        redisClientService.del(this.getKey(this.PERMISSION_PRE, uid));


    }


    @Override
    public Collection<Session> getActiveSessions() {
        Set<Session> sessions = new HashSet<Session>();

        Set<String> keys = redisClientService.keys(this.SHIRO_REDIS_SESSION_PRE + "*");
        if (keys != null && keys.size() > 0) {
            for (String key : keys) {
                Session s = (Session) redisClientService.get(key);
                sessions.add(s);
            }
        }

        return sessions;
    }

    public boolean isOnLine(String uid) {

        Set<String> keys = redisClientService.keys(this.UID_PRE + uid);
        if (keys != null && keys.size() > 0) {
            return true;
        }
        return false;
    }

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = this.generateSessionId(session);
        this.assignSessionId(session, sessionId);
        this.saveSession(session);
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        if (sessionId == null) {
            logger.error("session id is null");
            return null;
        }

        logger.debug("#####Redis.SessionId=" + new String(getKey(this.SHIRO_REDIS_SESSION_PRE, sessionId)));

        Session s = (Session) redisClientService.get(this.getKey(this.SHIRO_REDIS_SESSION_PRE, sessionId));
        return s;
    }

    /**
     * 获得byte[]型的key
     *
     * @param preKey
     * @return
     */
    private String getKey(String preKey, Serializable sessionId) {
        String key = preKey + sessionId;
        return key;

    }

    /**
     * 获取用户唯一标识
     *
     * @param session
     * @return
     */
    private String getUserId(Session session) {
        PmsOperator operator = (PmsOperator) session.getAttribute("PmsOperator");
        if (null != operator) {
            return operator.getId() + "";
        }
//        SimplePrincipalCollection pricipal = (SimplePrincipalCollection) session.getAttribute("org.apache.shiro.subject.support.DefaultSubjectContext_PRINCIPALS_SESSION_KEY");
//        if (null != pricipal) {
//            Account account = ((Account) pricipal.getPrimaryPrincipal());
//            return "";
//        }
        return "";
    }


}


