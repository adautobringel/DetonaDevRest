package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import entidade.Cliente;
import entidade.RetornoCliente;

@Path("/cliente")
public class ClienteServico {

	ClienteDAO clienteDAO;
	
	public ClienteServico() {
		this.clienteDAO = new ClienteDAOImpl();
	}
	
	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Cliente DetonaDevREST !!!";
	}

	@Path("/inserirCliente")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente inserirCliente(Cliente cliente) {
		
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.clienteDAO.inserirCliente(cliente)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Cliente não inserido!!");
		}

		return retorno;
	}
	
	@Path("/alterarCliente")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente alterarCliente(Cliente cliente) {
		
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.clienteDAO.alterarCliente(cliente)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Cliente não atualizado!!");
		}

		return retorno;
	}
	
	@Path("/excluirCliente")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente excluirCliente(Cliente cliente) {
		
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.clienteDAO.excluirCliente(cliente)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Cliente não removido!!");
		}

		return retorno;
	}

	
	@Path("/buscarCliente")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoCliente buscarCliente(Cliente cliente) {
		
		RetornoCliente retorno = new RetornoCliente();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!!!!!!!!");
		if(this.clienteDAO.pesquisarCliente(cliente.getCpf()) == null) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Cliente não encontrado!!!!");
		}

		return retorno;
	}
	
}
