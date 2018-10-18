package nl.rechtspraak.springboot.filmapi;

import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class FilmApiApplicationTests {
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void getFilmList() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/films"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.length()", Matchers.is(2)));
	}

	@Test
	public void getFilmDetail() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/films/123"))
				.andExpect(MockMvcResultMatchers.status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.titel", Matchers.equalTo("The Ususal Suspects")));
	}

	@Test
	public void getFilmDetailBestaatNiet() throws Exception {
		this.mockMvc.perform(MockMvcRequestBuilders.get("/films/1234567890"))
				.andExpect(MockMvcResultMatchers.status().isNotFound());
	}
}
