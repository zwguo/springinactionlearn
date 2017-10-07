package org.springlearn03.xml;

public class DefaultEncoreable implements Encoreable{

	public void performEncore() {
		System.out.println("this is in " + DefaultEncoreable.class.getName() + " 's performEncore.");
	}

}
