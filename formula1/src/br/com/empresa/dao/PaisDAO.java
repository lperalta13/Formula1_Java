package br.com.empresa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;

import br.com.empresa.exception.NegocioException;
import br.com.empresa.jpa.EntityManagerUtil;
import br.com.empresa.model.Pais;

public class PaisDAO {
	
	private EntityManager em;
	
	public PaisDAO() {
		em = EntityManagerUtil.getEntityManager();
	}
	
	public void salvar(Pais pais) {
		em.getTransaction().begin();
		em.persist(pais);
		em.getTransaction().commit();
	}
	
	public List<Pais> buscarTodos() {
		return em.createQuery("from Pais order by codigo", Pais.class).getResultList();
	}
	
	public void excluir(Long codigo)  throws NegocioException {
		try {
		//passando o codigo para comparar com o codigo no nome da classe
		Pais paisTemp = em.find(Pais.class, codigo);
		em.getTransaction().begin();
		em.remove(paisTemp);
		em.getTransaction().commit();
		}catch(PersistenceException e) {
			throw new NegocioException("Pais não pode ser excluído"); 
		}
	
	}
	
	public Pais buscarPeloCodigo(Long codigo) {
		return em.find(Pais.class, codigo);
	}
	
	public void alterar(Pais pais) {
		em.getTransaction().begin();
		em.merge(pais);
		em.getTransaction().commit();
	}

}
