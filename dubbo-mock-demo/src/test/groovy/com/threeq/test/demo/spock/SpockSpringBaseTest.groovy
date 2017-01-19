package com.threeq.test.demo.spock

import com.threeq.test.dmock.MockDubboHelper
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification
/**
 *
 * @Date 2017/1/19
 * @User three
 */
@WebAppConfiguration
@SpringBootTest
public abstract class SpockSpringBaseTest extends Specification {
    @Autowired
    protected ConfigurableApplicationContext context;

    /**
     * 生成 rpc接口调用mock
     * @param c
     * @return
     */
    protected <T> T mockRpcBean(Class<T> c) {
        def rpcBean =  Mock(c);
        MockDubboHelper.setDubboRefrence(c, rpcBean);
        return rpcBean;
    }

}