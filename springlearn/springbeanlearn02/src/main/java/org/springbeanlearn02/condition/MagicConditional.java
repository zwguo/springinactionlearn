package org.springbeanlearn02.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class MagicConditional implements Condition{

	public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
		//profiles指定
		if(context.getEnvironment().acceptsProfiles(new String[] {"testcondition"})) {
			return true;
		}
		return false;
	}

}
