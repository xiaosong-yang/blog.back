package top.yyf256.blog.dao;

import top.yyf256.blog.entity.UserInfo;

public interface UserInfoMapper {
    int deleteByPrimaryKey(Integer versionId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer versionId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}