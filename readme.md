# dubbo-mock

一个dubbo消费端单元测试mock工具. 

** 注意: dubbo-mock 不是一个单元测试mock框架, 自身不提供mock功能. 它只提供一个桥接工具, 将其他mock框架的mock对象连接到dubbo远程调用过程中, 从而实现mock rpc调用.

## 使用方式

在你的dubbo配置文件中加入消费端mock代理配置,具体如下:

```
<dubbo:consumer proxy="MockProxy" check="false"/>
```

如果还需要接触zk依赖,可以将所有的 `check` 选项设置成 `check="false"` 

## 工程说明

1. `dubbo-mock-core` dubbo-mock 核心实现
2. `dubbo-mock-demo` dubbo-mock 使用实例。demo 中提供了 `spock`、`mockito` 2 个例子
3. `docker-compose.yml` 开发时所依赖的组件服务: `zookeeper`
