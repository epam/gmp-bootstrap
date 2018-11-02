/*
 *  /***************************************************************************
 *  Copyright (c) 2018, EPAM SYSTEMS INC
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *     http://www.apache.org/licenses/LICENSE-2.0
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  ***************************************************************************
 */

package com.epam.gmp.config.custom;

import com.epam.gmp.GmpResourceUtils;
import com.epam.gmp.ScriptContextException;
import com.epam.gmp.ScriptInitializationException;
import com.epam.gmp.config.GMPConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/**
 * This is an optional class to demonstrate how to create custom Spring Beans.
 */

@Configuration
@EnableAspectJAutoProxy
public class CustomGmpConfig {
    @javax.annotation.Resource(name = "gmpHomeResource")
    Resource gmpHomeResource;
    public static final String GMP_GLOBAL_PROPERTIES = "gmp-global.properties";

    private static final Logger logger = LoggerFactory.getLogger(GMPConfig.class);

    @Bean(name = "GMPGlobalProperties")
    public static PropertySourcesPlaceholderConfigurer properties() {
        PropertySourcesPlaceholderConfigurer pspc = new PropertySourcesPlaceholderConfigurer();
        Resource[] resources;
        resources = new Resource[]{new ClassPathResource(GMP_GLOBAL_PROPERTIES)};
        pspc.setLocations(resources);
        pspc.setIgnoreUnresolvablePlaceholders(true);
        pspc.setIgnoreResourceNotFound(true);
        return pspc;
    }

    @Value("${jira.url}")
    private String jiraUrl;

    @Value("${jira.user}")
    private String jiraUser;

    @Value("${jira.password}")
    private String jiraPasswd;

    /*@Bean(name = "JiraHelperService")
    public JiraHelperService jiraHelperService() {
        JiraContext jiraContext = new JiraContext();
        jiraContext.setUrl(jiraUrl);
        jiraContext.setUser(jiraUser);
        jiraContext.setPassword(jiraPasswd);
        return new JiraHelperService(jiraContext);
    }*/
}
