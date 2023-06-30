package org.jdom.thinking.in.spring.ioc.overview.container;

import org.jdom.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;

import java.util.Map;

/**
 * @ClassName IocContainerDemo
 * @Description IOC容器示例
 * @Author devJava
 * @Date 2023/6/30 13:11
 * @Version 1.0
 */
public class BeanFactoryAsIocContainerDemo
{
    public static void main(String[] args)
    {
        // 创建 BeanFactory容器
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 加载配置文件
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        int i = reader.loadBeanDefinitions("META-INF/dependency-lookup-context.xml");

        System.out.println("加载的Bean定义个数：" + i);

        User user = (User) beanFactory.getBean("user");
        System.out.println(user);

        lookupCollectionByType(beanFactory);
    }

    private static void lookupCollectionByType(BeanFactory beanFactory)
    {
        if (beanFactory instanceof ListableBeanFactory)
        {
            ListableBeanFactory listableBeanFactory = ListableBeanFactory.class.cast(beanFactory);
            Map<String, User> beans = listableBeanFactory.getBeansOfType(User.class);
            System.out.println("依赖查找集合对象：" + beans);
        }
    }
}
