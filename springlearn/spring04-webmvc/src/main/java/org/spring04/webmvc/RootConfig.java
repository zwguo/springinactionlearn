package org.spring04.webmvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * 其他的bean初始化，排除web的
 *
 */
@Configuration
@ComponentScan(basePackages="{org.spring04.webmvc}", excludeFilters= {@Filter(type=FilterType.ANNOTATION, value=EnableWebMvc.class)})
public class RootConfig 
{
}
