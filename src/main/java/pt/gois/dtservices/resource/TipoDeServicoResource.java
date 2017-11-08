package pt.gois.dtservices.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pt.gois.dtservices.model.TipoDeServico;
import pt.gois.dtservices.repository.TipoDeServicoRepository;

@RestController
@RequestMapping("/tiposdeservico")
public class TipoDeServicoResource {
	
	@Autowired
	private TipoDeServicoRepository tipoDeServicoRepository;
	
	@GetMapping
	public List<TipoDeServico> listar() {
		return tipoDeServicoRepository.findAll();
	}

}
