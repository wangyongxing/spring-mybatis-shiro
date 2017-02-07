package com.wyx.service.redis;

import com.wyx.cached.ICached;
import org.apache.shiro.cache.AbstractCacheManager;
import org.apache.shiro.cache.Cache;
import org.apache.shiro.cache.CacheException;

/**
 * redis的缓存管理器
 * @author caomei
 *
 */
public class ShiroRedisCacheManager extends AbstractCacheManager {
	private ICached cached;
	@Override
	protected Cache createCache(String cacheName) throws CacheException {
		return new ShiroRedisCache<String, Object>(cacheName,cached);
	}
	public ICached getCached() {
		return cached;
	}
	public void setCached(ICached cached) {
		this.cached = cached;
	}

}
