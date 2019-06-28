package com.qiaomuer.algorithm.jdk;

import org.junit.Test;

import java.util.concurrent.ConcurrentHashMap;

/**
 * <p>
 * Java并发包测试
 * </p>
 * @author qiaomuer
 * @since 1.0
 */
public class JUCTest {

	@Test
	public void testConcurrentHashMap(){

		ConcurrentHashMap hashMap = new ConcurrentHashMap();
		hashMap.put("name","qiaomjuer");
	}
}
