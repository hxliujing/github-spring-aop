package com.javens.aop.service.impl;

import com.javens.aop.entity.AopEntity;
import com.javens.aop.entity.AopEnum;
import com.javens.aop.service.AopService;
import com.javens.aop.util.AopPrintUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class AopServiceImpl implements AopService {
    protected static final Logger logger = LoggerFactory.getLogger(AopServiceImpl.class);


    @Override
    public void save(AopEntity entity) {
        AopPrintUtil.print(AopEnum.SAVE,entity);
    }

    @Override
    public void delete(int id) {
        AopPrintUtil.print(AopEnum.DELETE,id);
    }

    @Override
    public AopEntity findById(int id) {
        AopPrintUtil.print(AopEnum.FIND,id);
        return null;
    }

    @Override
    public void excp() {
        throw new NullPointerException("测试异常");
    }
}
