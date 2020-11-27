package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import entidade.Veiculo;
import util.JpaUtil;

public class VeiculoDAOImpl implements VeiculoDAO{

	@Override
	public boolean inserirVeiculo(Veiculo veiculo) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		Veiculo veiculoBase = ent.find(Veiculo.class, veiculo.getPlaca());
		if(veiculoBase==null) {
			ent.persist(veiculo);
			trans.commit();
		}else
			{retorno = false;
			System.out.println("VEICULO JÁ CADASTRADO");}
				
		ent.close();
		return retorno;
	}

	@Override
	public boolean alterarVeiculo(Veiculo veiculo) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		
		Veiculo  veiculoBase = ent.find(Veiculo.class, veiculo.getPlaca());
		if(veiculoBase!=null) {
			ent.merge(veiculo);
			trans.commit();
		}else
			{retorno =false;
			System.out.println("Veiculo não localizado!");
			}
				
		ent.close();
		return retorno;
		}

	@Override
	public boolean excluirVeiculo(Veiculo veiculo) {
		boolean retorno =true;
		
		EntityManager ent = JpaUtil.getEntityManager();
		EntityTransaction trans = ent.getTransaction();
		trans.begin();
		
		Veiculo  veiculoBase = ent.find(Veiculo.class, veiculo.getPlaca());
		if(veiculoBase!=null) {
			ent.remove(veiculoBase);
			trans.commit();
		}else
			{retorno =false;
			System.out.println("Veiculo não localizado!");
			}
				
		ent.close();
		return retorno;
	}

	
	@Override
	public List<Veiculo> listarTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Veiculo pesquisarVeiculo(String placa) {
		EntityManager ent = JpaUtil.getEntityManager();
		Veiculo retorno = ent.find(Veiculo.class, placa);
		return retorno;
	}

	
}
