package top.yyf256.blog.repository;

import top.yyf256.blog.entity.Config;

import java.util.List;

public interface ConfigRepository {
    List<Config> getAllConfigs();
}