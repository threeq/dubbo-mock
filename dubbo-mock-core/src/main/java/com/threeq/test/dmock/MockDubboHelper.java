package com.threeq.test.dmock;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Mock 使用工具
 *
 * @Date 16/5/27
 * @User three
 */
public class MockDubboHelper {
    private static Map<Class<?>, Object> mockObjects = new ConcurrentHashMap<>();

    public static void setDubboRefrence(Class<?> c, Object mock) {
        mockObjects.put(c, mock);
    }

    public static Object getDubboReference(Class<?> c) {
        return mockObjects.get(c);
    }
}
