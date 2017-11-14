package pt.gois.dtservices.repository.tipodeservico;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import pt.gois.dtservices.model.TipoDeServico;
import pt.gois.dtservices.repository.filter.TipoDeServicoFilter;

public interface TipoDeServicoRepositoryQuery {

	public Page<TipoDeServico> filtrar(TipoDeServicoFilter lancamentoFilter, Pageable pageable);
}
