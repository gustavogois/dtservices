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
	
	public TipoDeServico atualizar(Long id, TipoDeServico tipoDeServico) {
		TipoDeServico tipoDeServicoSalvo = findTipoDeServicoByCodigo(id);
		BeanUtils.copyProperties(tipoDeServico, tipoDeServicoSalvo, "id");
		return tipoDeServicoRepository.save(tipoDeServicoSalvo);
	}

	private TipoDeServico findTipoDeServicoByCodigo(Long id) {
		TipoDeServico tipoDeServicoSalvo = tipoDeServicoRepository.findOne(id);
		if(tipoDeServicoSalvo == null) {
			throw new EmptyResultDataAccessException(1);
		}
		return tipoDeServicoSalvo;
	}
}
