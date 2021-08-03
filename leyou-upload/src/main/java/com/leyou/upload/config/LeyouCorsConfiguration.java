package com.leyou.upload.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
@Configuration
public class LeyouCorsConfiguration {

    @Bean
    public CorsFilter corsFilter() {

//        //初始化cors配置对象
//        CorsConfiguration configuration = new CorsConfiguration();
//        configuration.addAllowedOrigin("http://manage.leyou.com");
//        configuration.setAllowCredentials(true); //是否允许携带cookie
//        configuration.addAllowedMethod("*"); //代表所有的请求方法
//        configuration.addAllowedHeader("*"); //允许携带任何头信息
//
//        //初始化cors配置源对象
//        UrlBasedCorsConfigurationSource corsConfigurationSource = new UrlBasedCorsConfigurationSource();
//        corsConfigurationSource.registerCorsConfiguration("/**", configuration);
//
//        //返回corsFilter实例，参数：cors配置源对象
//        return new CorsFilter(corsConfigurationSource);
        //1.添加CORS配置信息
        CorsConfiguration config = new CorsConfiguration();
        //1) 允许的域,不要写*，否则cookie就无法使用了
        config.addAllowedOrigin("http://manage.leyou.com");
        //2) 是否发送Cookie信息
        config.setAllowCredentials(true);
        //3) 允许的请求方式
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("HEAD");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("DELETE");
        config.addAllowedMethod("PATCH");
        // 4）允许的头信息
        config.addAllowedHeader("*");

        //2.添加映射路径，我们拦截一切请求
        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        //3.返回新的CorsFilter.
        return new CorsFilter(configSource);
    }
}