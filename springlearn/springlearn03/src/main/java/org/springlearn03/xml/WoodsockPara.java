package org.springlearn03.xml;

import org.springlearn03.around.Woodstock;

public class WoodsockPara implements PerformancePara {

	public void perform(String name) {
		System.out.println("I get " + name + ". ok, this is a show of " + Woodstock.class.getName() + ".");
	}

}
