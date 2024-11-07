package com.sher.atmg.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "file")
public class CommonConfig {

    /**
     * 视频路径
     */
    private String videoDirectory;
    /**
     * 图片路径
     */
    private String imageDirectory;

}
