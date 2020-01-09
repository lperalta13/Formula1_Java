package br.com.empresa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.empresa.exception.NegocioException;
import br.com.empresa.jpa.EntityManagerUtil;
import br.com.empresa.model.Piloto;

public class PilotoDAO {
	private EntityManager em;
	
	public PilotoDAO() {
		em = EntityManagerUtil.getEntityManager();
	}
	
	public void salvar(Piloto piloto) {
		em.getTransaction().begin();
		em.persist(piloto);
		em.getTransaction().commit();
	}
	
	public List<Piloto> buscarTodos() {
		return em.createQuery("from Piloto order by codigo", Piloto.class).getResultList();
	}
	
	public void excluir(Long codigo)  throws NegocioException {
		try {
		//passando o codigo para comparar com o codigo no nome da classe
		Piloto pilotoTemp = em.find(Piloto.class, codigo);
		em.getTransaction().begin();
		em.remove(pilotoTemp);
		em.getTransaction().commit();
		}catch(PersistenceException e) {
			throw new NegocioException("Piloto não pode ser excluído"); 
		}
	
	}	
	public Piloto buscarPeloCodigo(Long codigo) {
		return em.find(Piloto.class, codigo);
	}

	public void alterar(Piloto piloto) {
		em.getTransaction().begin();
		em.merge(piloto);
		em.getTransaction().commit();
	}

}
