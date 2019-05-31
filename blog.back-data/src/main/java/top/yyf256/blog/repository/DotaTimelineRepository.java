package top.yyf256.blog.repository;

import top.yyf256.blog.entity.DotaTimeline;

public interface DotaTimelineRepository {
    int deleteByPrimaryKey(Integer id);

    int insert(DotaTimeline record);

    int insertSelective(DotaTimeline record);

    DotaTimeline selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(DotaTimeline record);

    int updateByPrimaryKeyWithBLOBs(DotaTimeline record);

    int updateByPrimaryKey(DotaTimeline record);
}