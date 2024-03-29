package com.luo.j2cache.sb.cache.support;

import net.oschina.j2cache.CacheChannel;
import net.oschina.j2cache.CacheObject;
import net.oschina.j2cache.NullObject;
import org.springframework.cache.CacheManager;
import org.springframework.cache.support.AbstractValueAdaptingCache;
import org.springframework.cache.support.NullValue;

import java.util.concurrent.Callable;

/**
 * {@link CacheManager} implementation for J2Cache.
 *
 * @author luohq
 * @date 2022-04-07
 */
public class J2CacheCache extends AbstractValueAdaptingCache {

	private CacheChannel cacheChannel;

	private String j2CacheName = "j2cache";

	public J2CacheCache(String cacheName, CacheChannel cacheChannel) {
		this(cacheName,cacheChannel, true);
	}

	public J2CacheCache(String cacheName, CacheChannel cacheChannel, boolean allowNullValues) {
		super(allowNullValues);
		j2CacheName = cacheName;
		this.cacheChannel = cacheChannel;
	}

	@Override
	public String getName() {
		return this.j2CacheName;
	}

	public void setJ2CacheName(String name) {
		this.j2CacheName = name;
	}

	@Override
	public Object getNativeCache() {
		return this.cacheChannel;
	}

	@Override
	public synchronized <T> T get(Object key, Callable<T> valueLoader) {
		ValueWrapper valueWrapper = this.get(key);
		if (valueWrapper != null) {
			return (T) valueWrapper.get();
		}

		T value;
		try {
			value = valueLoader.call();
		} catch (Exception ex) {
			throw new ValueRetrievalException(key, valueLoader, ex);
		}
		put(key, value);
		return value;
	}

	@Override
	public void put(Object key, Object value) {
		cacheChannel.set(j2CacheName, String.valueOf(key), value, super.isAllowNullValues());
	}

	@Override
	public ValueWrapper putIfAbsent(Object key, Object value) {
		if (!cacheChannel.exists(j2CacheName, String.valueOf(key))) {
			cacheChannel.set(j2CacheName, String.valueOf(key), value);
		}
		return get(key);
	}

	@Override
	public void evict(Object key) {
		cacheChannel.evict(j2CacheName, String.valueOf(key));
	}

	@Override
	public void clear() {
		cacheChannel.clear(j2CacheName);
	}

	@Override
	protected Object lookup(Object key) {
		CacheObject cacheObject = cacheChannel.get(j2CacheName, String.valueOf(key), false);
		if(cacheObject.rawValue() != null && cacheObject.rawValue().getClass().equals(NullObject.class) && super.isAllowNullValues()) {
			return NullValue.INSTANCE;
		}
		return cacheObject.getValue();
	}

}
