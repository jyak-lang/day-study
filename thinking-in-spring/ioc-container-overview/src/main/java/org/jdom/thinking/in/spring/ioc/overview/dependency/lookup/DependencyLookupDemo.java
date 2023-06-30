package org.jdom.thinking.in.spring.ioc.overview.dependency.lookup;

import org.jdom.thinking.in.spring.ioc.overview.annotation.Super;
import org.jdom.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Map;

/**
 * @ClassName DependencyLookupDemo
 * @Description 依赖查找示例
 * @Author devJava
 * @Date 2023/6/29 23:14
 * @Version 1.0
 */
public class DependencyLookupDemo
{
    public static void main(String[] args)
    {
        // 配置XML文件
        // 启动Spring 应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-lookup-context.xml");
        lookupInRealTimeByBeanName(beanFactory);
        lookupInLazyByBeanName(beanFactory);

        lookupByType(beanFactory);
        lookupCollectionByType(beanFactory);
    }

    private static void lookupByAnnotationType(BeanFactory beanFactory)
    {
        if (beanFactory instanceof ListableBeanFactory)
        {
            ListableBeanFactory listableBeanFactory = ListableBeanFactory.class.cast(beanFactory);
            Map<String, User> users = (Map) listableBeanFactory.getBeansWithAnnotation(Super.class);
        }
    }

    private static void lookupCollectionByType(BeanFactory beanFactory)
    {
        if (beanFactory instanceof ListableBeanFactory)
        {
            ListableBeanFactory listableBeanFactory = ListableBeanFactory.class.cast(beanFactory);
            Map<String, User> users = listableBeanFactory.getBeansOfType(User.class);   // 排序为哪个先定义则在前面
            System.out.println("按类型依赖查找集合对象：" + users);
        }
    }

    private static void lookupByType(BeanFactory beanFactory)
    {
        User user = beanFactory.getBean(User.class);
        System.out.println("按类型，实时查找：" + user);
    }

    private static void lookupInRealTimeByBeanName(BeanFactory beanFactory)
    {
        // 实时查找
        User user = (User) beanFactory.getBean("user");
        System.out.println("实时依赖查找：" + user);
    }

    private static void lookupInLazyByBeanName(BeanFactory beanFactory)
    {
        ObjectFactory<User> objectFactory = (ObjectFactory) beanFactory.getBean("objectFactory");
        System.out.println("非实时依赖查找：" + objectFactory.getObject());
    }
}
