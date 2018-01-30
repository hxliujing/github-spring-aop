package com.javens.aop.service;

import com.javens.aop.entity.AopEntity;

public interface AopService {
    public void save(AopEntity entity);
    public void delete(int id);
    public AopEntity findById(int id);
    public void excp();
}
