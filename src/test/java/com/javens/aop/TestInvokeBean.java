package com.javens.aop;

import com.javens.aop.common.BaseSpringTestCase;
import com.javens.aop.entity.AopEntity;
import com.javens.aop.service.AopService;
import com.javens.aop.util.AopPrintUtil;
import com.javens.concurrent.test.ConcurrentTestUtil;
import com.javens.concurrent.test.ResultHandler;
import com.javens.util.RandomUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.Callable;

public class TestInvokeBean extends BaseSpringTestCase {


    public Object getProperty(Object owner, String fieldName) throws Exception {
        Class ownerClass = owner.getClass();
        Field field = ownerClass.getField(fieldName);
        Object property = field.get(owner);
        return property;
    }


    public void printMethod(Object owner){
        Class ownerClass = (Class) owner;
        //Method ms[] = ownerClass.getMethods();//获取类自身及父类所有public 方法
        Method ms[] = ownerClass.getDeclaredMethods();//获取自身所有方法
        for (Method m : ms) {
            System.out.println("***"+m);
        }
        System.out.println("---------------------------");
    }
    public Object invokeMethod(Object owner, String methodName, Object[] args) throws Exception {
        Class[] argsClass = null;
        if(args!=null){
            argsClass = new Class[args.length];
            for (int i = 0, j = args.length; i < j; i++) {
                argsClass[i] = args[i].getClass();
            }
        }
        Method method = owner.getClass().getDeclaredMethod(methodName,argsClass);
        return method.invoke(owner, args);
    }

    @Test
    public void testGetProperty() throws Exception {
        Object o = getProperty(AopEntity.class,"name");
        System.out.println(o);
    }
    @Test
    public void testInvokeMethod() throws Exception {
        AopEntity entity = AopEntity.class.newInstance();
        Object o = invokeMethod(entity,"setName",new String[]{"123"});
        System.out.println(String.format("object is null:%s",o==null));
        Object o2 = invokeMethod(entity,"getName",null);
        System.out.println(String.format("object is null:%s",o2==null?"true":o2));
    }
    @Test
    public void testPrintMethod() throws Exception {
        printMethod(AopEntity.class);
    }

    /**
     * 并发 反射 压力测试
     * @throws Exception
     */
    @Test
    public void testInvokeConcurrentTest() throws Exception{
        ConcurrentTestUtil.concurrentTest(100, 500000,
                new Callable<String>() {
                    public String call() throws Exception {
                        AopEntity entity = AopEntity.class.newInstance();
                        Object o = invokeMethod(entity,"setName",new String[]{"123"});
                        Object o2 = invokeMethod(entity,"getName",null);
                        System.out.println(String.format("object is null:%s",o2==null?"true":o2));
                        return (String) o2;
                    }
                },
                new ResultHandler<String>(){
                    public void handle(String result) {
                        System.out.println(result);
                    }
                },
                1000 * 10000);
        Thread.sleep(1000 * 1);
    }

    /**
     * 并发 调用 压力测试
     * @throws Exception
     */
    @Test
    public void testTransferConcurrentTest() throws Exception{
        ConcurrentTestUtil.concurrentTest(100, 500000,
                new Callable<String>() {
                    public String call() throws Exception {
                        AopEntity entity = new AopEntity();
                        entity.setName("123");
                        Object o2 = entity.getName();
                        System.out.println(String.format("object is null:%s",o2==null?"true":o2));
                        return (String) o2;
                    }
                },
                new ResultHandler<String>(){
                    public void handle(String result) {
                        System.out.println(result);
                    }
                },
                1000 * 10000);
        Thread.sleep(1000 * 1);
    }
}
