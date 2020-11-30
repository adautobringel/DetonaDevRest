package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.ItemServico;
import entidade.Veiculo;
import util.JpaUtil;

public class ItemServicoDAOImpl implements ItemServicoDAO{

	@Override
	public boolean inserirItemServico(ItemServico itemServico) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		ent.persist(itemServico);
		trans.commit();
				
		ent.close();
		return retorno;
	}

	@Override
	public boolean alterarItemServico(ItemServico itemServico){
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		
		ItemServico  itemBase = ent.find(ItemServico.class, itemServico.getId());
		if(itemBase!=null) {
			ent.merge(itemServico);
			trans.commit();
		}else
			{retorno =false;
			System.out.println("Veiculo não localizado!");
			}
				
		ent.close();
		return retorno;
		}

	@Override
	public boolean excluirItemServico(ItemServico itemServico) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		
		ItemServico itemBase = ent.find(ItemServico.class, itemServico.getId());
		if(itemBase!=null) {
			ent.remove(itemBase);
			trans.commit();
		}else
			{retorno =false;
			System.out.println("Veiculo não localizado!");
			}
				
		ent.close();
		return retorno;
	}

	
	@Override
	public List<ItemServico> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ItemServico pesquisarItemServico(int id) {
		EntityManager ent = JpaUtil.getEntityManager();
		ItemServico retorno = ent.find(ItemServico.class, id);
		return retorno;
	}

	
}
