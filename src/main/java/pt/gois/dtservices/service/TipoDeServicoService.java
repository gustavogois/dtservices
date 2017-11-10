package pt.gois.dtservices.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import pt.gois.dtservices.model.TipoDeServico;
import pt.gois.dtservices.repository.TipoDeServicoRepository;

@Service
public class TipoDeServicoService {

	@Autowired
	TipoDeServicoRepository tipoDeServicoRepository;
	
	public TipoDeServico atualizar(Long codigo, TipoDeServico tipoDeServico) {
		TipoDeServico tipoDeServicoSalvo = tipoDeServicoRepository.findOne(codigo);
		if(tipoDeServicoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(tipoDeServico, tipoDeServicoSalvo, "id");
		return tipoDeServicoRepository.save(tipoDeServicoSalvo);
	}
	
}
