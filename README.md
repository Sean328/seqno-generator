# seqno-generator
提供分布式环境下唯一id生成
## 生成方式
生成方式分为两种，一种是类似与snawflake雪花算法的方式，第二种则是采用redis缓存配置，保证id强递增


# TODO
- [ ] 引入redis-ops包，实现从redis读递增sequence
