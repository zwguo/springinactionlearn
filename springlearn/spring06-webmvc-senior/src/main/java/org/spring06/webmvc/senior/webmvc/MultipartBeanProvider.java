package org.spring06.webmvc.senior.webmvc;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;

@Component
public class MultipartBeanProvider {
	
	@Bean
	public MultipartResolver multipartResolver() throws IOException {
//		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver();
//		multipartResolver.setUploadTempDir(new FileSystemResource("/tmp/uploadtmp"));
//		multipartResolver.setMaxUploadSize(2097152);
//		multipartResolver.setMaxInMemorySize(4194304);
//		return multipartResolver;
		return new StandardServletMultipartResolver();
	}
}
