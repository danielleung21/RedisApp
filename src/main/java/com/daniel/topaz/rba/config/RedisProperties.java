package com.daniel.topaz.rba.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisProperties {
    private String host;
    private int port;

    public RedisProperties(
            @Value("${redis.port}") int port,
            @Value("${redis.host}") String host) {
        this.port = port;
        this.host = host;
    }

    public String getHost() {
        return host;
    }

    public int getPort() {
        return port;
    }
}
