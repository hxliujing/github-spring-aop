package com.javens.aop;

import com.javens.aop.common.BaseSpringTestCase;
import com.javens.aop.service.AopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestAspectBaseBean extends BaseSpringTestCase {
    @Autowired
    private AopService aopService;

    @Test
    public void demoLoggingSave(){
        aopService.save(null);
    }

    @Test
    public void demoLoggingDelete(){
        aopService.delete(0);
    }

    @Test
    public void demoLoggingFindById(){
        aopService.findById(1);
    }

    @Test
    public void demoLoggingExcp(){
        aopService.excp();
    }
}
