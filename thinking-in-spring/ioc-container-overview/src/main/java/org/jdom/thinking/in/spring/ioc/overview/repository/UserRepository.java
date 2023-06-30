package org.jdom.thinking.in.spring.ioc.overview.dependency.repository;

import org.jdom.thinking.in.spring.ioc.overview.dependency.domain.User;

import java.util.Collection;

/**
 * @ClassName UserRepository
 * @Description 用户信息仓库
 * @Author devJava
 * @Date 2023/6/30 12:07
 * @Version 1.0
 */
public class UserRepository
{
    private User user;

    private Collection<User> users;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Collection<User> getUsers() {
        return users;
    }

    public void setUsers(Collection<User> users) {
        this.users = users;
    }
}
