package org.springlearn03.addMethod;

import org.springframework.stereotype.Component;

@Component
public class DefaultEncoreable implements Encoreable{

	public void performEncore() {
		System.out.println("this is in " + DefaultEncoreable.class.getName() + " 's performEncore.");
	}

}
