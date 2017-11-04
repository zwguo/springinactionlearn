package org.spring15.rmi.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.spring15.rmi.interfaces.SpitterService;
import org.spring15.rmi.model.Spitter;

public class SpitterServiceRawImpl implements SpitterService {

	private static final ConcurrentHashMap<Integer, Spitter> idMap = new ConcurrentHashMap<Integer, Spitter>();
	private static final Object obj = new Object();

	public String getName() {
		System.out.println("SpitterServiceRawImpl-getName");
		return SpitterServiceRawImpl.class.getName();
	}

	public Spitter getSpitter(int id) {
		return idMap.get(Integer.valueOf(id));
	}

	public String saveSpitter(Spitter spitter) {
		idMap.put(Integer.valueOf(spitter.getId()), spitter);
		return "OK";
	}

	public List<Spitter> getSpitter(String name) {
		List<Spitter> spitters = new ArrayList();
		if (name == null) {
			return spitters;
		}
		synchronized (obj) {
			for (Spitter spitter : idMap.values()) {
				if (name.equals(spitter.getName())) {
					spitters.add(spitter);
				}
			}
		}
		return spitters;
	}

	public String[] getSpitterRepalys(int id, String repaly) {
		Spitter spitter = idMap.get(Integer.valueOf(id));
		if (spitter != null && spitter.getRepalys() != null) {
			String[] newArray = Arrays.copyOf(spitter.getRepalys(), spitter.getRepalys().length + 1);
			newArray[newArray.length - 1] = repaly;
			return newArray;
		}
		return new String[] { repaly };
	}

}
