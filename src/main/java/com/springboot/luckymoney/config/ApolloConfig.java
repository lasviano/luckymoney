package com.springboot.luckymoney.config;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableApolloConfig({"application", "lmApollo.properties"})
public class ApolloConfig {

}
