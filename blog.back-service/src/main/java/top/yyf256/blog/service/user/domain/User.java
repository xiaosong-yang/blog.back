package top.yyf256.blog.service.user.domain;

import top.yyf256.security.domain.UserInfo;

public class User implements UserInfo {

    private String userKey;
    private String[] userRoles;

    @Override
    public String getUserKey() {
        return userKey;
    }

    @Override
    public String[] getUserRoles() {
        return userRoles;
    }

    public void setUserKey(String userKey) {
        this.userKey = userKey;
    }

    public void setUserRoles(String[] userRoles) {
        this.userRoles = userRoles;
    }
}
