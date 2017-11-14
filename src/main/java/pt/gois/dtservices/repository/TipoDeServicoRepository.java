package pt.gois.dtservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pt.gois.dtservices.model.TipoDeServico;
import pt.gois.dtservices.repository.tipodeservico.TipoDeServicoRepositoryQuery;

public interface TipoDeServicoRepository extends JpaRepository<TipoDeServico, Long>, TipoDeServicoRepositoryQuery {

}
