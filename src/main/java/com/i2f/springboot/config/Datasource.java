package com.i2f.springboot.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 20:57 2023/2/22
 */
@Component
@ConfigurationProperties(prefix = "datasource")
@PropertySource(value = {"classpath:dataSource.yml"},factory = YmlConfigFactory.class)
@Data
public class Datasource {
    private String name;
    private String age;
}
