package com.javens.aop;

import com.javens.aop.common.BaseSpringTestCase;
import com.javens.aop.service.AopService;
import org.junit.Test;
import org.springframework.aop.MethodMatcher;
import org.springframework.aop.support.NameMatchMethodPointcut;
import org.springframework.beans.factory.annotation.Autowired;

public class TestAspectThirdJarBean extends BaseSpringTestCase {


    @Test
    public void demo(){
        MethodMatcher matcher = new NameMatchMethodPointcut();
        LOGGER.info("run:" + matcher.isRuntime());
    }


}
