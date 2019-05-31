package top.yyf256.blog.web.security;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import top.yyf256.blog.constant.ConfigConstant;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.service.config.ConfigService;
import top.yyf256.blog.service.user.domain.User;
import top.yyf256.security.core.AuthInterceptor;
import top.yyf256.security.domain.UserInfo;
import top.yyf256.util.code.DesCodeUtil;
import top.yyf256.util.string.StringUtil;


@Component
public class SecurityInterceptor extends AuthInterceptor {

    private Logger logger = LogManager.getLogger(SecurityInterceptor.class);

    @Autowired
    ConfigService configService;


    @Override
    protected Logger getLogger() {
        return logger;
    }

    @Override
    public String getPasswordByUsername(String username) {
        try {
            String realUsername = configService.selConfig(ConfigConstant.ADMIN_ACCOUNT);
            if (!StringUtil.stringIsBlank(realUsername) && realUsername.equals(username)) {
                String pwd = configService.selConfig(ConfigConstant.ADMIN_PWD);
                byte[] key = StringUtil.hexStringToBytes(SystemConstant.DES_CODE_KEY);
                byte[] pwdByte = StringUtil.hexStringToBytes(pwd);
                String realPwd = new String(DesCodeUtil.decrypt(pwdByte, key));
                return realPwd;
            }
        } catch (Exception e) {
            logger.error("解密密码失败", e);
        }
        return null;
    }

    @Override
    public UserInfo getUserInfo(String userKey) {
        String realUsername = configService.selConfig(ConfigConstant.ADMIN_ACCOUNT);
        if (!StringUtil.stringIsBlank(realUsername) && realUsername.equals(userKey)) {
            String roles = configService.selConfig(ConfigConstant.AUTH_LIST);
            User user = new User();
            user.setUserKey(userKey);
            user.setUserRoles(roles.split(SystemConstant.COMMA));
            return user;
        }
        return null;
    }


    @Override
    public String getAuthFailUrl() {
        return "/login";
    }

}
