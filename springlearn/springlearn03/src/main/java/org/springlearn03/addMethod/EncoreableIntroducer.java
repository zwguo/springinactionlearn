package org.springlearn03.addMethod;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;

@Aspect
public class EncoreableIntroducer {

	@DeclareParents(value = "org.springlearn03.addMethod.Performance+", defaultImpl = DefaultEncoreable.class)
	public static Encoreable encoreable;
}
