package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import entidade.Cliente;
import entidade.Material;
import util.JpaUtil;

public class MaterialDAOImpl implements MaterialDAO{

	@Override
	public boolean inserirMaterial(Material material) {
		
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		
		Material matBase = ent.find(Material.class, material.getID());
		if(matBase==null) {
			ent.persist(material);
			trans.commit();
		}else
			{retorno = false;}
				
		ent.close();
		return retorno;
	}

	@Override
	public boolean alterarMaterial(Material material) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		
		Material matBase = ent.find(Material.class, material.getID());
		if(matBase!=null) {
			ent.merge(material);
			trans.commit();
		}else
			{retorno =false;
			System.out.println("Material não localizado!");
			}
				
		ent.close();
		return retorno;
		
	}

	@Override
	public boolean excluirMaterial(Material material) {
		
		boolean retorno = true;
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();

		Material matBase = ent.find(Material.class, material.getID());
		if(matBase!=null) {
			ent.remove(matBase);
			trans.commit();
		}else
			{retorno =false;
			System.out.println("Material não localizado!");
			}
				
				
		ent.close();
		return retorno;
		
	}

	

	@Override
	public List<Material> listarTodos() {
		EntityManager ent = JpaUtil.getEntityManager();

		Query query = ent.createQuery("from Material m");

		List<Material> materiais = query.getResultList();

		return materiais;
	}


	@Override
	public Material pesquisarMaterial(int id) {
		EntityManager ent = JpaUtil.getEntityManager();
		Material retorno = ent.find(Material.class, id);
		
		return retorno;
	}

	
	
}
