package pt.gois.dtservices.resource;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt.gois.dtservices.event.RecursoCriadoEvent;
import pt.gois.dtservices.model.TipoDeServico;
import pt.gois.dtservices.repository.TipoDeServicoRepository;
import pt.gois.dtservices.repository.filter.TipoDeServicoFilter;

@RestController
@RequestMapping("/tiposdeservico")
public class TipoDeServicoResource {

	@Autowired
	private TipoDeServicoRepository tipoDeServicoRepository;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	public Page<TipoDeServico> pesquisar(TipoDeServicoFilter tipoDeServicoFilter, Pageable pageable) {
		return tipoDeServicoRepository.filtrar(tipoDeServicoFilter, pageable);
	}
	
	@GetMapping("/{codigo}")
	public ResponseEntity<TipoDeServico> buscarPeloCodigo(@PathVariable Long codigo) {
		TipoDeServico tipoDeServico = tipoDeServicoRepository.findOne(codigo);
		return tipoDeServico != null ? ResponseEntity.ok(tipoDeServico) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<TipoDeServico> criar(@Valid @RequestBody TipoDeServico tipoDeServico, HttpServletResponse response) {
		TipoDeServico tipoDeServicoSalvo = tipoDeServicoRepository.save(tipoDeServico);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoDeServicoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoDeServicoSalvo);
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		tipoDeServicoRepository.delete(codigo);;
	}

	
}