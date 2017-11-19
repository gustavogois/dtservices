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
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import pt.gois.dtservices.event.RecursoCriadoEvent;
import pt.gois.dtservices.model.TipoDeServico;
import pt.gois.dtservices.repository.TipoDeServicoRepository;
import pt.gois.dtservices.repository.filter.TipoDeServicoFilter;
import pt.gois.dtservices.service.TipoDeServicoService;

@RestController
@RequestMapping("/tiposdeservico")
public class TipoDeServicoResource {

	@Autowired
	private TipoDeServicoRepository tipoDeServicoRepository;
	
	@Autowired
	private TipoDeServicoService tipoDeServicoService;
	
	@Autowired
	private ApplicationEventPublisher publisher;
	
	@Autowired
	private MessageSource messageSource;
	
	@GetMapping
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TIPO_DE_SERVICO')")
	public Page<TipoDeServico> pesquisar(TipoDeServicoFilter tipoDeServicoFilter, Pageable pageable) {
		return tipoDeServicoRepository.filtrar(tipoDeServicoFilter, pageable);
	}
	
	@GetMapping("/{codigo}")
	@PreAuthorize("hasAuthority('ROLE_PESQUISAR_TIPO_DE_SERVICO')")
	public ResponseEntity<TipoDeServico> buscarPeloCodigo(@PathVariable Long codigo) {
		TipoDeServico tipoDeServico = tipoDeServicoRepository.findOne(codigo);
		return tipoDeServico != null ? ResponseEntity.ok(tipoDeServico) : ResponseEntity.notFound().build();
	}
	
	@PostMapping
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TIPO_DE_SERVICO')")
	public ResponseEntity<TipoDeServico> criar(@Valid @RequestBody TipoDeServico tipoDeServico, HttpServletResponse response) {
		TipoDeServico tipoDeServicoSalvo = tipoDeServicoRepository.save(tipoDeServico);
		publisher.publishEvent(new RecursoCriadoEvent(this, response, tipoDeServicoSalvo.getId()));
		return ResponseEntity.status(HttpStatus.CREATED).body(tipoDeServicoSalvo);
	}
	
	@PutMapping("/{id}")
	@PreAuthorize("hasAuthority('ROLE_CADASTRAR_TIPO_DE_SERVICO')")
	public ResponseEntity<TipoDeServico> atualizar(@PathVariable Long id, @Valid @RequestBody TipoDeServico tipoDeServico) {
		return ResponseEntity.ok(tipoDeServicoService.atualizar(id, tipoDeServico));
	}

	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@PreAuthorize("hasAuthority('ROLE_EXCLUIR_TIPO_DE_SERVICO')")
	public void remover(@PathVariable Long id) {
		tipoDeServicoRepository.delete(id);;
	}
}