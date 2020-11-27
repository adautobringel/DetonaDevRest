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
import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entidade.Cliente;
import entidade.RetornoCliente;
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
	public RetornoVeiculo inserirVeiculo(Veiculo veiculo, Cliente cliente) {
	
		RetornoCliente retornoCli = new RetornoCliente();
		retornoCli.setCodigoRetorno(0);
		retornoCli.setMsgRetorno("SUCESSO!!!");
	
		
		
		RetornoVeiculo retorno = new RetornoVeiculo();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
	/*	
		Cliente cliBase = clienteDAO.pesquisarCliente(cliente.getCpf());
		System.out.println(cliBase);
		
		if(this.clienteDAO.pesquisarCliente(cliente.getCpf()) != null) {
			Veiculo v = new Veiculo();
			v.setCliente(cliBase);
			v.setPlaca(veiculo.getPlaca());
			v.setFabricante(veiculo.getFabricante());
			v.setModelo(veiculo.getModelo());
			v.setCor(veiculo.getCor());
			v.setTipo(veiculo.getTipo());
			v.setAno(veiculo.getAno());
		
			if(!this.veiculoDAO.inserirVeiculo(v)) {
				retorno.setCodigoRetorno(1);
				retorno.setMsgRetorno("FALHA: Veiculo não inserido!!");
			}
*/
		
			
		
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
	}
