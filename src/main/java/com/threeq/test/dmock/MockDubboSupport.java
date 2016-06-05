package com.threeq.test.dmock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Date 16/5/27
 * @User three
 */
public class MockDubboSupport {
    private static Map<Class<?>, Object> mockObjects = new ConcurrentHashMap<>();

    public static void setDubboRefrence(Class<?> c, Object mock) {
        mockObjects.put(c, mock);
    }

    public static Object getDubboRefrence(Class<?> c) {
        return mockObjects.get(c);
    }
}
