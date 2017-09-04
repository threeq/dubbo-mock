package com.threeq.test;

import com.alibaba.dubbo.config.annotation.Reference;
import com.threeq.test.api.Demo;
import com.threeq.test.api.IDemo1;
import com.threeq.test.dmock.MockDubboHelper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.mockito.Mockito.*;

@WebAppConfiguration
@SpringBootTest
@ContextConfiguration(classes = {TestApplication.class})
@RunWith(SpringRunner.class)
public class DmockDemoTest {

    @Reference(version= "1.1.0")
    private IDemo1 demo1;

    @Test
    public void test() {
        IDemo1 rpcMock = mockRpcBean(IDemo1.class);

        when(rpcMock.test0()).thenReturn(1234);

        Demo demo = new Demo();
        demo.demo = "mock测试数据！我只是一个测试数据，请忽略我的值！";
        when(rpcMock.testObj()).thenReturn(demo);

        int zero = demo1.test0();
        Demo resultDemo = demo1.testObj();

        rpcMock.test1("1");

        System.out.println("mock 测试数据 demo: "+ resultDemo.demo+" ==》 "+(resultDemo==demo));
        System.out.println("测试数据： "+zero);

        verify(rpcMock);

        Assert.assertEquals(1234, zero);

    }

    /**
     * 生成 rpc接口调用mock
     * @param c
     * @return
     */
    protected <T> T mockRpcBean(Class<T> c) {
        T rpcBean =  mock(c);
        MockDubboHelper.setDubboRefrence(c, rpcBean);
        return rpcBean;
    }
}
