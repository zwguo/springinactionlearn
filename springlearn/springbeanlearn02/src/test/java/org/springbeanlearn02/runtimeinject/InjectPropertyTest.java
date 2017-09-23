package org.springbeanlearn02.runtimeinject;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = InjectProperty.class)
public class InjectPropertyTest {

	@Autowired
	public InjectPerson person;

	@Test
	public void test() {
		assertTrue(person.toString().equals("123-中华人民共和国"));
	}

}
