package com.i2f.springboot.config;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.DefaultPropertySourceFactory;
import org.springframework.core.io.support.EncodedResource;

import java.io.IOException;
import java.util.Properties;

/**
 * @Author：jinwwenm
 * @Description:
 * @Date: Created in 16:35 2023/2/23
 */
public class YmlConfigFactory extends DefaultPropertySourceFactory {
    @Override
    public PropertySource<?> createPropertySource(String name, EncodedResource resource) throws IOException {
        //获取资源文件名称
        String sourceName = name!=null?name:resource.getResource().getFilename();
        //判断资源文件是否存在
        if(!resource.getResource().exists()){
            //不存在，则返回一个空新文件
            return new PropertiesPropertySource(name,new Properties());
        }else if(sourceName.endsWith("yml") || sourceName.endsWith("yaml")){
            //存在，则判断文件格式是否为yml
            Properties properties = loadYml(resource);
            return new PropertiesPropertySource(sourceName,properties);
        }else{
            return super.createPropertySource(name,resource);
        }
    }

    private Properties loadYml(EncodedResource resource) {
        YamlPropertiesFactoryBean factoryBean = new YamlPropertiesFactoryBean();
        factoryBean.setResources(resource.getResource());
        factoryBean.afterPropertiesSet();
        return factoryBean.getObject();
    }
}
