package org.springlearn03.xml;

/**
 * 具体的bean
 * @author kwz
 *
 */
public class Woodstock implements Performance {

	public void perform() {
		System.out.println("ok, this is a show of " + Woodstock.class.getName() + ".");
	}

}
