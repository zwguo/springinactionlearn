package org.springbeanlearn02;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class ProfileBean {

	/**
	 * 只有在dev时才会创建，否则此bean无效
	 * @return
	 */
	@Bean("dsname")
	@Profile("dev")
	public String getDataSourceDev() {
		return "dev";
	}

	/**
	 * 只有在prod时才会创建，否则此bean无效
	 * @return
	 */
	@Bean("dsname")
	@Profile("prod")
	public String getDataSourcePrd() {
		return "prod";
	}
	
	/**
	 * 不指定时，无论哪个环境都会创建
	 * @return
	 */
	@Bean("otherthing")
	public String getOtherThing() {
		return "the sun from the rain.";
	}
}
