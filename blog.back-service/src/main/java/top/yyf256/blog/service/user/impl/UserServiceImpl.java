package top.yyf256.blog.service.user.impl;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.constant.ConfigConstant;
import top.yyf256.blog.constant.SystemConstant;
import top.yyf256.blog.dao.ConfigMapper;
import top.yyf256.blog.entity.Config;
import top.yyf256.blog.service.user.UserService;
import top.yyf256.blog.service.user.domain.User;
import top.yyf256.security.constants.SecurityCommonConstant;
import top.yyf256.util.code.DesCodeUtil;
import top.yyf256.util.string.StringUtil;

@Service
public class UserServiceImpl implements UserService {

    private Logger logger = LogManager.getLogger(UserServiceImpl.class);

    @Autowired
    ConfigMapper configMapper;

    @Override
    public User selUser(String userKey) {
        Config username = configMapper.selectByPrimaryKey(ConfigConstant.ADMIN_ACCOUNT);
        if(!StringUtil.stringIsBlank(userKey) && userKey.equals(username)){
            Config roles = configMapper.selectByPrimaryKey(ConfigConstant.AUTH_LIST);
            User user = new User();
            user.setUserKey(userKey);
            user.setUserRoles(roles.getValue().split(SystemConstant.COMMA));
            return user;
        }
        return null;
    }

    @Override
    public String selUserPwd(String userKey) {
        try {
            Config username = configMapper.selectByPrimaryKey(ConfigConstant.ADMIN_ACCOUNT);
            if(!StringUtil.stringIsBlank(userKey) && userKey.equals(username)){
                Config pwd = configMapper.selectByPrimaryKey(ConfigConstant.ADMIN_PWD);
                byte[] key = StringUtil.hexStringToBytes(SecurityCommonConstant.DES_KEY);
                byte[] pwdByte = StringUtil.hexStringToBytes(pwd.getValue());
                String realPwd = StringUtil.bytesToHexString(DesCodeUtil.decrypt(pwdByte,key));
                return realPwd;
            }
        } catch (Exception e) {
            logger.error("解密密码失败");
        }
        return null;
    }


}

