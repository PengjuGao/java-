package com.platform.client.factory.FrameworkFactory;

import com.platform.client.enums.FrameworkEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/10/28.
 */
@Component
public class FrameworkFactory {
    @Autowired
    Framework none;
    @Autowired
    Framework spring;
    @Autowired
    Framework hibernate;
    @Autowired
    Framework springMybatis;
    @Autowired
    Framework springHibernate;
    @Autowired
    Framework structs2Mybatis;
    @Autowired
    Framework structs2Hibernate;
    @Autowired
    Framework structs2;
    @Autowired
    Framework mybatis;

    /**
     * 获取对应的framework
     * @param value
     * @return
     */
    public Framework getFramework(int value){
        FrameworkEnum enums = FrameworkEnum.getEnum(value);
        switch (enums) {
            case NONE:
                return this.none;
            case SPINRG:
                return this.spring;
            case STRUCTS2:
                return this.structs2;
            case MYBATIS:
                return this.mybatis;
            case HIBERNATE:
                return this.hibernate;
            case SPRING_MYBATIS:
                return this.springMybatis;
            case SPRING_HIBERNATE:
                return this.springHibernate;
            case STRUCTS2_MYBATIS:
                return this.structs2Mybatis;
            case STRUCTS2_HIBERNATE:
                return this.structs2Hibernate;

        }
        return null;
    }

}
