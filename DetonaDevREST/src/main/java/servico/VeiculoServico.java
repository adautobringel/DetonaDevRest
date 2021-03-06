package servico;

import java.io.Serializable;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entidade.Cliente;
import entidade.Material;
import entidade.RetornoCliente;
import entidade.RetornoMaterial;
import entidade.RetornoVeiculo;
import entidade.Veiculo;
import util.JpaUtil;

@Path("/veiculo")
public class VeiculoServico {

	VeiculoDAO veiculoDAO;
	ClienteDAO clienteDAO;
	
	public VeiculoServico() {
		this.veiculoDAO = new VeiculoDAOImpl();
		this.clienteDAO = new ClienteDAOImpl();
	}
	
	
	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Veiculo DetonaDevREST !!!";
	}

	@Path("/inserirVeiculo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoVeiculo inserirVeiculo(Veiculo veiculo) {
	
		RetornoVeiculo retorno = new RetornoVeiculo();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.veiculoDAO.inserirVeiculo(veiculo)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: VEÍCULO não inserido!!");
		}
		return retorno;
	}
	
	@Path("/buscarVeiculo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoVeiculo buscarVeiculo(Veiculo veiculo) {
		
		RetornoVeiculo retorno = new RetornoVeiculo();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(this.veiculoDAO.pesquisarVeiculo(veiculo.getPlaca())==null) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Veiculo não encontrado!!");
		}

		return retorno;
	}
	
	@Path("/excluirVeiculo")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoVeiculo excluirVeiculo(Veiculo veiculo) {
		
		RetornoVeiculo retorno = new RetornoVeiculo();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.veiculoDAO.excluirVeiculo(veiculo)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Material não removido!!");
		}

		return retorno;
	}
	}
