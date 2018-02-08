## SPRING AOP TEST FRAME
| JUNIT-CLASS | 说明 |
| :-----:   | :-----:   |
| TestSpringBaseBean | 基础类 |
| TestAspectBaseBean | aspect测试 |
| TestAspectThirdJarBean | 第三方jarAOP |


## Java反射机制压测
    说明： 并发线程100，总次数500000。ConcurrentTestUtil类进行压测
| 类别 | 耗时 | avgTime  |TPS | 备注  |
| :-----:   | :-----:   | :-----:   |:-----:   |:-----:   |
| Invoke反射 | 16169ms | 0.032338| 30923| 性能89.39% |
| Java对象 | 14455ms | 0.02891| 34590| 性能100% |
  