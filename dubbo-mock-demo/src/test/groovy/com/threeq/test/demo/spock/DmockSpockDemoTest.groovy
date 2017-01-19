/**
 *
 * @Date 2017/1/19
 * @User three
 */
package com.threeq.test.demo.spock

import com.alibaba.dubbo.config.annotation.Reference
import com.threeq.test.TestApplication
import com.threeq.test.api.Demo
import com.threeq.test.api.IDemo1
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration

@ContextConfiguration(classes = [TestApplication.class])
class DmockSpockDemoTest extends SpockSpringBaseTest {

    @Reference(version= "1.1.0")
    private IDemo1 demo1;

    def "spock 框架支持测试"() {
        setup:
        def rpcMock = mockRpcBean(IDemo1.class);

        rpcMock.test0() >> 1234;

        def demo = new Demo();
        demo.demo = "mock测试数据！我只是一个测试数据，请忽略我的值！"
        rpcMock.testObj() >> demo;

        when:
        def zero = demo1.test0();
        def resultDemo = demo1.testObj();

        rpcMock.test1("1");

        println("mock 测试数据 demo: "+ resultDemo.demo+" ==》 "+(resultDemo==demo))
        println("测试数据： "+zero);

        then:
            zero == 1234
            1 * rpcMock.test1("1")
    }
}