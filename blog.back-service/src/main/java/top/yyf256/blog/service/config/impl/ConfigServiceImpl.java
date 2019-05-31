package top.yyf256.blog.service.config.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import top.yyf256.blog.entity.Config;
import top.yyf256.blog.repository.ConfigRepository;
import top.yyf256.blog.service.config.ConfigService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    ConfigRepository configRepository;

    private Map<String,String> allConfigs;

    @Override
    public String selConfig(String key) {
        if(allConfigs==null){
            synchronized (ConfigServiceImpl.class) {
                if(allConfigs == null){
                    List<Config> configs = configRepository.getAllConfigs();
                    allConfigs = new HashMap<>();
                    if(configs!=null && configs.size()>0){
                        for(Config cfg: configs){
                            allConfigs.put(cfg.getKey(),cfg.getValue());
                        }
                    }
                }
            }
        }
        return allConfigs.get(key);
    }
}
