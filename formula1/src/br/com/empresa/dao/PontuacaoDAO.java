package br.com.empresa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.empresa.exception.NegocioException;
import br.com.empresa.jpa.EntityManagerUtil;
import br.com.empresa.model.Pontuacao;

public class PontuacaoDAO {
	private EntityManager em;
	
	public PontuacaoDAO() {
		em = EntityManagerUtil.getEntityManager();
	}
	
	public void salvar(Pontuacao pontuacao) {
		em.getTransaction().begin();
		em.persist(pontuacao);
		em.getTransaction().commit();
	}
	
	public List<Pontuacao> buscarTodos() {
		return em.createQuery("from Pontuacao order by codigo", Pontuacao.class).getResultList();
	}
	
	public void excluir(Long codigo)  throws NegocioException {
		try {
		//passando o codigo para comparar com o codigo no nome da classe
		Pontuacao pontuacaoTemp = em.find(Pontuacao.class, codigo);
		em.getTransaction().begin();
		em.remove(pontuacaoTemp);
		em.getTransaction().commit();
		}catch(PersistenceException e) {
			throw new NegocioException("Pontuação não pode ser excluído"); 
		}
	
	}	
	public Pontuacao buscarPeloCodigo(Long codigo) {
		return em.find(Pontuacao.class, codigo);
	}
	
	public List<Pontuacao> buscaTodosSomandoPontos(){
		return em.createQuery("select codigo_piloto, sum(pontos) as total from Pontuacao group by codigo_piloto", Pontuacao.class).getResultList();
	}
	

	public void alterar(Pontuacao pontuacao) {
		em.getTransaction().begin();
		em.merge(pontuacao);
		em.getTransaction().commit();
	}

}
