package com.blankj.subutil.util.http;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2019/02/17
 *     desc  :
 * </pre>
 */
class UserBean {

    private String name;
    private String password;
    private String profession;
    private int    id;

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(final String password) {
        this.password = password;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(final String profession) {
        this.profession = profession;
    }

    public int getId() {
        return id;
    }

    public void setId(final int id) {
        this.id = id;
    }
}
