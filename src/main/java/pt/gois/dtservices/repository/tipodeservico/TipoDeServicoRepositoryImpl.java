package pt.gois.dtservices.repository.tipodeservico;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.util.StringUtils;

import pt.gois.dtservices.model.TipoDeServico;
import pt.gois.dtservices.repository.filter.TipoDeServicoFilter;

public class TipoDeServicoRepositoryImpl implements TipoDeServicoRepositoryQuery {

	@PersistenceContext
	private EntityManager manager;
	
	@Override
	public Page<TipoDeServico> filtrar(TipoDeServicoFilter TipoDeServicoFilter, Pageable pageable) {
		
		// TODO: Utilizar JPQL para fazer o filtro
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<TipoDeServico> criteria = builder.createQuery(TipoDeServico.class);
		Root<TipoDeServico> root = criteria.from(TipoDeServico.class);
		
		Predicate[] predicates = criarRestricoes(TipoDeServicoFilter, builder, root);
		criteria.where(predicates);
		
		TypedQuery<TipoDeServico> query = manager.createQuery(criteria);
		adicionarRestricoesDePaginacao(query, pageable);
		
		return new PageImpl<>(query.getResultList(), pageable, total(TipoDeServicoFilter));
	}

	private Predicate[] criarRestricoes(TipoDeServicoFilter tipoDeServicoFilter, CriteriaBuilder builder,
			Root<TipoDeServico> root) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if (!StringUtils.isEmpty(tipoDeServicoFilter.getId())) {
			predicates.add(builder.like(
					builder.lower(root.get("id")), "%" + tipoDeServicoFilter.getId().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(tipoDeServicoFilter.getNome())) {
			predicates.add(builder.like(
					builder.lower(root.get("nome")), "%" + tipoDeServicoFilter.getNome().toLowerCase() + "%"));
		}
		
		if (!StringUtils.isEmpty(tipoDeServicoFilter.getDescricao())) {
			predicates.add(builder.like(
					builder.lower(root.get("descricao")), "%" + tipoDeServicoFilter.getDescricao().toLowerCase() + "%"));
		}
		
		return predicates.toArray(new Predicate[predicates.size()]);
	}

	// TODO: Verificar possibilidade de reutilizar esse método por outras classes 
	private void adicionarRestricoesDePaginacao(TypedQuery<TipoDeServico> query, Pageable pageable) {
		int paginaAtual = pageable.getPageNumber();
		int totalRegistrosPorPagina = pageable.getPageSize();
		int primeiroRegistroDaPagina = paginaAtual * totalRegistrosPorPagina;
		
		query.setFirstResult(primeiroRegistroDaPagina);
		query.setMaxResults(totalRegistrosPorPagina);
	}
	
	// TODO: Implementar com JPQL
	private Long total(TipoDeServicoFilter TipoDeServicoFilter) {
		CriteriaBuilder builder = manager.getCriteriaBuilder();
		CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
		Root<TipoDeServico> root = criteria.from(TipoDeServico.class);
		
		Predicate[] predicates = criarRestricoes(TipoDeServicoFilter, builder, root);
		criteria.where(predicates);
		
		criteria.select(builder.count(root));
		return manager.createQuery(criteria).getSingleResult();
	}

	
}
