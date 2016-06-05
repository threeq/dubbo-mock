package com.threeq.test.dmock;

import com.alibaba.dubbo.rpc.Invoker;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @Date 16/5/26
 * @User three
 */
public class MockInvokerInvocationHandler implements InvocationHandler {

    private final Invoker<?> invoker;

    public MockInvokerInvocationHandler(Invoker<?> handler){
        this.invoker = handler;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        String methodName = method.getName();
        Class<?>[] parameterTypes = method.getParameterTypes();
        Class<?> c = method.getDeclaringClass();
        if (method.getDeclaringClass() == Object.class) {
            return method.invoke(invoker, args);
        }
        if ("toString".equals(methodName) && parameterTypes.length == 0) {
            return invoker.toString();
        }
        if ("hashCode".equals(methodName) && parameterTypes.length == 0) {
            return invoker.hashCode();
        }
        if ("equals".equals(methodName) && parameterTypes.length == 1) {
            return invoker.equals(args[0]);
        }
        Object mock = MockDubboSupport.getDubboRefrence(c);
        if(null == mock) {
            throw new MockException("没有mock对象: "+c.getCanonicalName());
        }
        return method.invoke(mock, args);
    }

}