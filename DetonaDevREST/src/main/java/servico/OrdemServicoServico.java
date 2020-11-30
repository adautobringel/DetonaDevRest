package servico;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.OrdemServicoDAO;
import dao.OrdemServicoDAOImpl;
import entidade.OrdemServico;
import entidade.RetornoOrdemServico;

@Path("/ordem")
public class OrdemServicoServico {

	OrdemServicoDAO ordemServicoDAO;
	
	public OrdemServicoServico() {
		this.ordemServicoDAO = new OrdemServicoDAOImpl();
	}
	
	
	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Ordens de serviço DetonaDevREST !!!";
	}

	@Path("/inserirOrdem")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoOrdemServico inserirOrdem(OrdemServico ordemServico) throws ParseException {
	Date d = new Date();
//		DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
//		ordemServico.setDataEntrada(df.parse(ordemServico.getDataEntrada().toString()));
//		ordemServico.setDataInicio(df.parse(ordemServico.getDataInicio().toString()));
//		ordemServico.setDataFim(df.parse(ordemServico.getDataFim().toString()));
//		
		ordemServico.setDataEntrada(d);
		
		RetornoOrdemServico retorno = new RetornoOrdemServico();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.ordemServicoDAO.inserirOrdemServico(ordemServico)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: VEÍCULO não inserido!!");
		}
		return retorno;
	}
	
	@Path("/buscarOrdem")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoOrdemServico buscarOrdemSServico(OrdemServico ordemServico) {
		
		RetornoOrdemServico retorno = new RetornoOrdemServico();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(this.ordemServicoDAO.pesquisarOrdemServico(ordemServico.getId())==null) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: ORDEM não encontrada!!");
		}

		return retorno;
	}
	
	@Path("/excluirOrdem")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoOrdemServico buscarOrdemServico(OrdemServico ordemServico) {
		
		RetornoOrdemServico retorno = new RetornoOrdemServico();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(this.ordemServicoDAO.pesquisarOrdemServico(ordemServico.getId())==null) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: ORDEM não encontrada!!");
		}

		return retorno;
	}
	}
