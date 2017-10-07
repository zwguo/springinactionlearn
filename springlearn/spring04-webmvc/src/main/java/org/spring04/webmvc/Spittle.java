package org.spring04.webmvc;

import java.util.Date;
import java.util.Random;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Spittle {
	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;

	public Spittle(String message, Date time) {
		this(message, time, null, null);
	}

	public Spittle(String message, Date time, Double longitude, Double latitude) {
		this.id = null;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "name");
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, "id", "name");
	}
	
	public static void main(String[] args) {
		Random r = new Random();
		Date date = new Date();
		Spittle t = new Spittle("id677", date, 0.01d, 0.02d); 
		long start = System.currentTimeMillis();
		for(int i=0; i<100000; i++) {
			Spittle t1 = new Spittle("id" + r.nextInt(1000), date, 0.01d, 0.02d);
			if(t.equals(t1)) {
				System.out.println(i + "-" + t1.getMessage());
			}
			t1.setLatitude(Double.valueOf(t.hashCode()));
		}
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	
}
