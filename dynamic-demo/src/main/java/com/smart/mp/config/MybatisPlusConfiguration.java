package com.smart.mp.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: Emilia
 * @Since: 2020.11.25 11:22
 */
@Configuration
public class MybatisPlusConfiguration {
    /**
     * 配置分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        paginationInterceptor.setLimit(100L);
        //默认为false，如果超过最大页数是否处理
        paginationInterceptor.setOverflow(true);
        return paginationInterceptor;
    }
}
