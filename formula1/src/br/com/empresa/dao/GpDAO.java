package br.com.empresa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.empresa.exception.NegocioException;
import br.com.empresa.jpa.EntityManagerUtil;
import br.com.empresa.model.Gp;

public class GpDAO {
	private EntityManager em;
	
	public GpDAO() {
		em = EntityManagerUtil.getEntityManager();
	}
	
	public void salvar(Gp gp) {
		em.getTransaction().begin();
		em.persist(gp);
		em.getTransaction().commit();
	}
	
	public List<Gp> buscarTodos() {
		return em.createQuery("from Gp order by codigo", Gp.class).getResultList();
	}
	
	public void excluir(Long codigo)  throws NegocioException {
		try {
		//passando o codigo para comparar com o codigo no nome da classe
		Gp gpTemp = em.find(Gp.class, codigo);
		em.getTransaction().begin();
		em.remove(gpTemp);
		em.getTransaction().commit();
		}catch(PersistenceException e) {
			throw new NegocioException("Gp não pode ser excluído"); 
		}
	
	}	
	public Gp buscarPeloCodigo(Long codigo) {
		return em.find(Gp.class, codigo);
	}

	public void alterar(Gp gp) {
		em.getTransaction().begin();
		em.merge(gp);
		em.getTransaction().commit();
	}

}
