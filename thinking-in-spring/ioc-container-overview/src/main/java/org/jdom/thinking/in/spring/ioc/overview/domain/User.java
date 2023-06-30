package org.jdom.thinking.in.spring.ioc.overview.domain;

/**
 * @ClassName User
 * @Description TODO
 * @Author devJava
 * @Date 2023/6/29 23:25
 * @Version 1.0
 */
public class User
{
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
