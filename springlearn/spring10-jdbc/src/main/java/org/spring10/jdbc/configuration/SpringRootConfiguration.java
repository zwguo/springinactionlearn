package org.spring10.jdbc.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan(value="org.spring10.jdbc", excludeFilters= {@Filter(type=FilterType.ANNOTATION, classes=EnableWebMvc.class)})
public class SpringRootConfiguration {

}
