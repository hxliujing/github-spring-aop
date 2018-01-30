package com.javens.aop;

import com.javens.aop.common.BaseSpringTestCase;
import com.javens.aop.service.AopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestExceptionBean extends BaseSpringTestCase {


    public void demo(){
       try{
           System.out.println(1/0);
       }catch (Exception e){
            throw new  RuntimeException("1/0",e);
       }
        System.out.println("========end===========");
    }
    @Test
    public void  invokeDemo(){
        demo();
    }
}
