package org.jdom.thinking.in.spring.ioc.overview.container;

import org.jdom.thinking.in.spring.ioc.overview.domain.SuperUser;
import org.jdom.thinking.in.spring.ioc.overview.domain.User;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Map;

/**
 * @ClassName AnnotationApplicationContextAsIocContainerDemo
 * @Description ApplicationContext 作为 IOC容器 示例
 * @Author devJava
 * @Date 2023/6/30 14:18
 * @Version 1.0
 */
public class AnnotationApplicationContextAsIocContainerDemo
{
    public static void main(String[] args)
    {
        // 创建Spring应用上下文对象
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();

        // 注册 Configuration Class
        applicationContext.register(AnnotationApplicationContextAsIocContainerDemo.class);

        // 启动
        applicationContext.refresh();

        // do something
        lookupCollectionByType(applicationContext);

        // 关闭
        applicationContext.close();
    }

    @Bean
    public User user()
    {
        User user = new User();
        user.setId(123L);
        user.setName("何马");
        return user;
    }

    @Bean
    public SuperUser superUser()
    {
        SuperUser superUser = new SuperUser();
        superUser.setId(321L);
        superUser.setName("李马");
        superUser.setAddress("bei jing");
        return superUser;
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
