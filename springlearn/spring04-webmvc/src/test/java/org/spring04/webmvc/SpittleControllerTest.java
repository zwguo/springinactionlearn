package org.spring04.webmvc;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;
import org.spring04.webmvc.data.SpittleRepository;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceView;

public class SpittleControllerTest {

	/**
	 * 对应的是无参数的spittles()方法，如测试要解开，并注释掉有参数的spittles(long, int)方法。
	 * @throws Exception
	 */
	@Test
	public void shouldShowRecentSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(20);
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findSpittles(Long.MAX_VALUE, 20)).thenReturn(expectedSpittles);

		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller)
				.setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles"))
		.andExpect(MockMvcResultMatchers.view().name("spittles"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
		.andExpect(MockMvcResultMatchers.model().attribute("spittleList", org.hamcrest.Matchers.hasItems(expectedSpittles.toArray())));
	}
	
	@Test
	public void shouldShowPagedSpittles() throws Exception {
		List<Spittle> expectedSpittles = createSpittleList(50);
		SpittleRepository mockRespository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRespository.findSpittles(238900, 50)).thenReturn(expectedSpittles);
		
		SpittleController controller = new SpittleController(mockRespository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp")).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles?max=238900&count=50"))
		.andExpect(MockMvcResultMatchers.view().name("spittles"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("spittleList"))
		.andExpect(MockMvcResultMatchers.model().attribute("spittleList", org.hamcrest.Matchers.hasItems(expectedSpittles.toArray())));
		
	}
	
	@Test
	public void testSpittle() throws Exception{
		Spittle expectedSpittle = new Spittle("Hello", new Date());
		SpittleRepository mockRepository = Mockito.mock(SpittleRepository.class);
		Mockito.when(mockRepository.findOne(12345)).thenReturn(expectedSpittle);
		
		SpittleController controller = new SpittleController(mockRepository);
		MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
		
		mockMvc.perform(MockMvcRequestBuilders.get("/spittles/12345"))
		.andExpect(MockMvcResultMatchers.view().name("spittle"))
		.andExpect(MockMvcResultMatchers.model().attributeExists("spittle"))
		.andExpect(MockMvcResultMatchers.model().attribute("spittle", expectedSpittle));
	}

	private List<Spittle> createSpittleList(int count) {
		List<Spittle> spittles = new ArrayList();
		for (int i = 0; i < count; i++) {
			spittles.add(new Spittle("spittle " + i, new Date()));
		}
		return spittles;
	}
}
