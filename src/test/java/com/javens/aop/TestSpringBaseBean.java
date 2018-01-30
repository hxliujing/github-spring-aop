package com.javens.aop;

import com.javens.aop.common.BaseSpringTestCase;
import com.javens.aop.service.AopService;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestSpringBaseBean extends BaseSpringTestCase {
    @Autowired
    private AopService aopService;

    @Test
    public void demo(){
        aopService.save(null);
        aopService.delete(0);
        aopService.findById(1);
    }

}
