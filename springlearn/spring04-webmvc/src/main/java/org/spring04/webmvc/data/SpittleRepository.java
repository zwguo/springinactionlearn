package org.spring04.webmvc.data;

import java.util.List;

import org.spring04.webmvc.Spittle;

public interface SpittleRepository {
	List<Spittle> findSpittles(long max, int count);
}
