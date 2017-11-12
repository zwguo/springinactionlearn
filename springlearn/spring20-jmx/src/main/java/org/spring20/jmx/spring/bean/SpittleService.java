package org.spring20.jmx.spring.bean;

import org.springframework.stereotype.Component;

@Component
public class SpittleService {
	private int page;

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}
	
}
