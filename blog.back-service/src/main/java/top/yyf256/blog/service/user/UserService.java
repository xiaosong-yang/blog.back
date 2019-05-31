package top.yyf256.blog.service.user;

import top.yyf256.blog.service.user.domain.User;

public interface UserService {

    User selUser(String userKey);

    String selUserPwd(String userKey);
}
