package org.jdom.thinking.in.spring.ioc.overview.dependency.injection;

import org.jdom.thinking.in.spring.ioc.overview.domain.User;
import org.jdom.thinking.in.spring.ioc.overview.repository.UserRepository;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.geom.RectangularShape;

/**
 * @ClassName DependencyInjectionDemo
 * @Description 依赖注入 示例
 * @Author devJava
 * @Date 2023/6/30 12:11
 * @Version 1.0
 */
public class DependencyInjectionDemo
{
    public static void main(String[] args)
    {
        // 创建Spring应用上下文
        BeanFactory beanFactory = new ClassPathXmlApplicationContext("META-INF/dependency-injection-context.xml");

        UserRepository repository = beanFactory.getBean(UserRepository.class);
        System.out.println("repository.user: " + repository.getUser());
        System.out.println("repository.users: " + repository.getUsers());

        BeanFactory userBeanFactory = repository.getBeanFactory();
        // userBeanFactory: org.springframework.beans.factory.support.DefaultListableBeanFactory@60addb54: defining beans [user,objectFactory,superUser,userRepository]; root of factory hierarchy
        // 打印信息可知，自动依赖注入的BeanFactory为DefaultListableBeanFactory，另外还可看自定义的Bean对象都存在这个BeanFactory里
        System.out.println("userBeanFactory: " + userBeanFactory);

        System.out.println("beanFactory == userBeanFactory：" + (beanFactory == userBeanFactory));

        ObjectFactory<User> userObjectFactory = repository.getUserObjectFactory();
        System.out.println("ObjectFactory<User>：" + userObjectFactory.getObject());

        ObjectFactory<BeanFactory> beanFactoryObjectFactory = repository.getBeanFactoryObjectFactory();
        System.out.println("ObjectFactory<BeanFactory>: " + beanFactoryObjectFactory.getObject());

        ObjectFactory<ApplicationContext> applicationContextObjectFactory = repository.getApplicationContextObjectFactory();
        System.out.println("ObjectFactory<ApplicationContext>: " + applicationContextObjectFactory.getObject());

        // 依赖查找BeanFactory
//        System.out.println("BeanFactory 依赖查找：" + beanFactory.getBean(BeanFactory.class));     // 报错
//        System.out.println("ApplicationContext 依赖查找：" + beanFactory.getBean(ApplicationContext.class)); // 报错
    }
}
