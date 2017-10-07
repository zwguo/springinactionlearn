package org.springlearn03.xml;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class PerformTacker {

	private Map<String, Integer> trackCounts = new HashMap<String, Integer>();

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
