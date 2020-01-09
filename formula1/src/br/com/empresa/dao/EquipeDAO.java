package br.com.empresa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.empresa.exception.NegocioException;
import br.com.empresa.jpa.EntityManagerUtil;
import br.com.empresa.model.Equipe;

public class EquipeDAO {
	private EntityManager em;
	
	public EquipeDAO() {
		em = EntityManagerUtil.getEntityManager();
	}
	
	public void salvar(Equipe equipe) {
		em.getTransaction().begin();
		em.persist(equipe);
		em.getTransaction().commit();
	}
	
	public List<Equipe> buscarTodos() {
		return em.createQuery("from Equipe order by codigo", Equipe.class).getResultList();
	}
	
	public void excluir(Long codigo)  throws NegocioException {
		try {
		//passando o codigo para comparar com o codigo no nome da classe
		Equipe equipeTemp = em.find(Equipe.class, codigo);
		em.getTransaction().begin();
		em.remove(equipeTemp);
		em.getTransaction().commit();
		}catch(PersistenceException e) {
			throw new NegocioException("Equipe não pode ser excluído"); 
		}
	
	}	
	public Equipe buscarPeloCodigo(Long codigo) {
		return em.find(Equipe.class, codigo);
	}

	public void alterar(Equipe equipe) {
		em.getTransaction().begin();
		em.merge(equipe);
		em.getTransaction().commit();
	}

}
