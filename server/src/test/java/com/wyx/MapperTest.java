package com.wyx;

import com.wyx.dao.permission.PmsOperatorDao;
import com.wyx.domain.permission.PmsMenu;
import com.wyx.domain.permission.PmsMenuConditions;
import com.wyx.domain.permission.PmsOperator;
import com.wyx.domain.permission.PmsOperatorConditions;
import com.wyx.mapper.permission.PmsMenuMapper;
import com.wyx.mapper.permission.PmsOperatorMapper;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: wangyongxing
 * Date: 16/8/31
 * Time: 上午10:35
 * To change this template use File | Settings | File Templates.
 */
public class MapperTest extends BaseJunitTest {

    @Resource
    PmsMenuMapper pmsMenuMapper;
    @Resource
    PmsOperatorDao pmsOperatorDao;
    @Resource
    PmsOperatorMapper pmsOperatorMapper;

    @Test
    public void test() {
        long id = 2;
        PmsMenuConditions conditions = new PmsMenuConditions();
        conditions.createCriteria().andIdEqualTo(id);
        PmsMenu pmsMenu=new PmsMenu();
        pmsMenu.id(id);
        pmsMenuMapper.selectByExample(conditions);
        System.out.println(11);
    }

    @Test
    public void save() {
        pmsOperatorDao.findOperatorByLoginName("admin");


    }
}
