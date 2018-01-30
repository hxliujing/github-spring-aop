package com.javens.aop.util;

import com.javens.aop.entity.AopEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AopPrintUtil {
    protected static final Logger logger = LoggerFactory.getLogger(AopPrintUtil.class);

    public static void  print(AopEnum aopEnum,Object o){
        String result = "";
        if(o==null){
            result = " NULL OBJECT";
        }else{
            result = (Integer)o+"";
        }
        if(aopEnum==AopEnum.SAVE){
            logger.info(String.format("type:SAVE,result:%s",result));
        }else if(aopEnum==AopEnum.FIND){
            logger.info(String.format("type:FIND,result:%s",result));
        }else if(aopEnum==AopEnum.DELETE){
            logger.info(String.format("type:DELETE,result:%s",result));
        }
    }
}
