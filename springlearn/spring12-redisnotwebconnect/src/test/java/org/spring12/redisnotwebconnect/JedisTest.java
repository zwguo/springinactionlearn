package org.spring12.redisnotwebconnect;

import junit.framework.TestCase;
import redis.clients.jedis.Jedis;

/**
 * Unit test for test redis
 */
public class JedisTest extends TestCase {
	/**
	 * 测试连接redis
	 */
	public void testRedis() {
		final String key = "javakey1";
		Jedis jedis = new Jedis("127.0.0.1", 6379);
		String code = jedis.set(key, System.currentTimeMillis() + "");
		System.out.println("set javakey1 return code：" + code);
		String value = jedis.get(key);
		assertTrue("OK".equals(code));
		assertFalse(value == null);
		jedis.del(key);
		value = jedis.get(key);
		assertTrue(value == null);
	}
}
