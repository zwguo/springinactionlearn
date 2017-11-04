package org.spring15.rmi.interfaces;

import java.util.List;

import org.spring15.rmi.model.Spitter;

public interface SpitterService {
	String getName();
	Spitter getSpitter(int id);
	String saveSpitter(Spitter spitter);
	List<Spitter> getSpitter(String name);
	String[] getSpitterRepalys(int id, String repaly);
}
