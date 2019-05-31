package top.yyf256.blog.repository;

import top.yyf256.blog.entity.UserInfo;

public interface UserInfoRepository {
    int deleteByPrimaryKey(Integer versionId);

    int insert(UserInfo record);

    int insertSelective(UserInfo record);

    UserInfo selectByPrimaryKey(Integer versionId);

    int updateByPrimaryKeySelective(UserInfo record);

    int updateByPrimaryKey(UserInfo record);
}