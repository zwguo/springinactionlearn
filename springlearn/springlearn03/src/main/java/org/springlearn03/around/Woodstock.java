package org.springlearn03.around;

import org.springframework.stereotype.Component;

/**
 * 具体的bean
 * @author kwz
 *
 */
@Component
public class Woodstock implements Performance {

	public void perform() {
		System.out.println("ok, this is a show of " + Woodstock.class.getName() + ".");
	}

}
