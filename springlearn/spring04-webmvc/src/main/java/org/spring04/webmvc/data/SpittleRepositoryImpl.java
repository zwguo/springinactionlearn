package org.spring04.webmvc.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.spring04.webmvc.Spittle;
import org.springframework.stereotype.Component;

@Component
public class SpittleRepositoryImpl implements SpittleRepository {

	@Override
	public List<Spittle> findSpittles(long max, int count) {
		List<Spittle> list = new ArrayList();
		for (int i = 0; i < count; i++) {
			Spittle s = new Spittle("message-" + i, new Date(), (double) i, (double) i - 1);
			list.add(s);
		}
		return list;
	}

	@Override
	public Spittle findOne(long spittleId) {
		return new Spittle("message-" + spittleId, new Date(), (double) spittleId, (double) spittleId - 1);
	}

}
