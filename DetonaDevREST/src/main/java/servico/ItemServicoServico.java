package servico;


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
import dao.ItemServicoDAO;
import dao.ItemServicoDAOImpl;
import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entidade.Cliente;
import entidade.ItemServico;
import entidade.Material;
import entidade.RetornoCliente;
import entidade.RetornoItemServico;
import entidade.RetornoMaterial;
import entidade.RetornoVeiculo;
import entidade.Veiculo;
import util.JpaUtil;

@Path("/item")
public class ItemServicoServico {

	ItemServicoDAO itemServicoDAO;
	
	public ItemServicoServico() {
		this.itemServicoDAO = new ItemServicoDAOImpl();
	}
	
	
	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "ITEM_SERVIÇO DetonaDevREST !!!";
	}

	@Path("/inserirItem")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoItemServico inserirItem(ItemServico itemServico) {
	
		RetornoItemServico retorno = new RetornoItemServico();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.itemServicoDAO.inserirItemServico(itemServico)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: VEÍCULO não inserido!!");
		}
		return retorno;
	}
	
	@Path("/buscarItem")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoItemServico buscarItem(ItemServico itemServico) {
		
		RetornoItemServico retorno = new RetornoItemServico();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(this.itemServicoDAO.pesquisarItemServico(itemServico.getId())==null) {
					retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: ITEM não encontrado!!");
		}

		return retorno;
	}
	
	@Path("/excluirOrdem")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoItemServico excluirItem(ItemServico itemServico) {
		
		RetornoItemServico retorno = new RetornoItemServico();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.itemServicoDAO.excluirItemServico(itemServico)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Material não removido!!");
		}

		return retorno;
	}
	}
