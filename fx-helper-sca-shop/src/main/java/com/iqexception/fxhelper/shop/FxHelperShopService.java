package com.iqexception.fxhelper.shop;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.servers.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.net.InetAddress;
import java.net.UnknownHostException;
@OpenAPIDefinition(servers = {@Server(url = "http://fx-helper-shop")},
        info=@Info(title = "OpenAPI definition", version = "v0") )
@SpringBootApplication(scanBasePackages = {
        "com.iqexception.fxhelper.shop",
        "com.iqexception.fxhelper.common.advice",
        "com.iqexception.fxhelper.common.filter",
        "com.iqexception.fxhelper.client"
})
@EnableDiscoveryClient
public class FxHelperShopService {

    public static void main(String[] args) throws UnknownHostException {
        //FIXME
        System.setProperty("nacos.logging.default.config.enabled", "false");
        System.setProperty("HOST_NAME", InetAddress.getLocalHost().getHostName());
        System.setProperty("HOST_IP", InetAddress.getLocalHost().getHostAddress());

        SpringApplication.run(FxHelperShopService.class, args);
    }
}
