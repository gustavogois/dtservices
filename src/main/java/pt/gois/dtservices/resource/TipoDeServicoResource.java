package pt.gois.dtservices.resource;

import java.net.URI;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

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
	
	// TODO: Utilizar código e não ID para identificar unicamente as entidades
	
	@PostMapping
	public ResponseEntity<TipoDeServico> criar(@RequestBody TipoDeServico tipoDeServico, HttpServletResponse response) {
		TipoDeServico tipoDeServicoSalvo = tipoDeServicoRepository.save(tipoDeServico);
		
		URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}").buildAndExpand(tipoDeServicoSalvo.getId()).toUri();
		
		return ResponseEntity.created(uri).body(tipoDeServicoSalvo);
	}
	
	@GetMapping("/{codigo}")
	public TipoDeServico buscaPeloCodigo(@PathVariable Long codigo) {
		return tipoDeServicoRepository.findOne(codigo);
	}

}
