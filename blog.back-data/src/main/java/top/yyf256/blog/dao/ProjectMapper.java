package top.yyf256.blog.dao;

import top.yyf256.blog.entity.Project;
import top.yyf256.blog.entity.ProjectWithBLOBs;

public interface ProjectMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ProjectWithBLOBs record);

    int insertSelective(ProjectWithBLOBs record);

    ProjectWithBLOBs selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ProjectWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(ProjectWithBLOBs record);

    int updateByPrimaryKey(Project record);
}