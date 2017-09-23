package org.springbeanlearn02.soundsystem;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
// @ComponentScan(basePackages = { "org.springbeanlearn01.soundsystem" })
@ComponentScan(basePackageClasses = { CompactDisc.class })
public interface CDPlayerConfig {
}
