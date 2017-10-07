package org.springlearn03.withpara;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class PerformTacker {

	private Map<String, Integer> trackCounts = new HashMap<String, Integer>();

	@Pointcut("execution(* org.springlearn03.withpara.PerformancePara.perform(String)) && args(name2)")
	public void track(String name2) {
	}

	@Before("track(name2)")
	public void countTrack(String name2) {
		if (!trackCounts.containsKey(name2)) {
			trackCounts.put(name2, 1);
		} else {
			trackCounts.put(name2, trackCounts.get(name2) + 1);
		}
	}
	
	public Map<String, Integer> getCounts(){
		return Collections.unmodifiableMap(trackCounts);
	}
}
