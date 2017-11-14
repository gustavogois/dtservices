package pt.gois.dtservices;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import pt.gois.dtservices.repository.TipoDeServicoRepository;
import pt.gois.dtservices.resource.TipoDeServicoResource;

@RunWith(SpringRunner.class)
@WebMvcTest(TipoDeServicoResource.class)
public class DtServicesApplicationTests {

	@Autowired
    private MockMvc mvc;
	
	@MockBean
    private TipoDeServicoRepository repository;
	
	@Test
	public void contextLoads() throws Exception {
		
		mvc.perform(get("/tiposdeservico")
			      .contentType(MediaType.APPLICATION_JSON))
			      .andExpect(status().isOk());
	}

}
