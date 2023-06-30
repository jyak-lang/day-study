package org.jdom.thinking.in.spring.ioc.overview.domain;

/**
 * @ClassName SuperUser
 * @Description TODO
 * @Author devJava
 * @Date 2023/6/30 11:37
 * @Version 1.0
 */
public class SuperUser extends User
{
    private String address;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SuperUser{" +
                "address='" + address + '\'' +
                "} " + super.toString();
    }
}
