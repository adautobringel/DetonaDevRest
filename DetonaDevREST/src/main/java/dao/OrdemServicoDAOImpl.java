package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.OrdemServico;
import entidade.Veiculo;
import util.JpaUtil;

public class OrdemServicoDAOImpl implements OrdemServicoDAO{

	@Override
	public boolean inserirOrdemServico(OrdemServico ordemServico) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		ent.persist(ordemServico);
		trans.commit();
				
		ent.close();
		return retorno;
		
		//Fazer tratamento de erro para não abrir uma ordem de serviço quando á existir outra do mesmo veículo com "Status" Aberta
	}

	@Override
	public boolean alterarOrdemServico(OrdemServico ordemServico) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		
		OrdemServico  osBase = ent.find(OrdemServico.class, ordemServico.getId());
		if(osBase!=null) {
			ent.merge(ordemServico);
			trans.commit();
		}else
			{retorno =false;
			System.out.println("Ordem não localizada!");
			}
				
		ent.close();
		return retorno;
		}

	@Override
	public boolean excluirOrdemServico(OrdemServico ordemServico) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		
		OrdemServico  osBase = ent.find(OrdemServico.class, ordemServico.getId());
			if(osBase!=null) {
			ent.remove(osBase);
			trans.commit();
		}else
			{retorno =false;
			System.out.println("Veiculo não localizado!");
			}
				
		ent.close();
		return retorno;
	}

	
	@Override
	public List<OrdemServico> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrdemServico pesquisarOrdemServico(int id) {
		EntityManager ent = JpaUtil.getEntityManager();
		OrdemServico retorno = ent.find(OrdemServico.class, id);
		return retorno;
	}

	
}
