package servico;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import dao.MaterialDAO;
import dao.MaterialDAOImpl;
import entidade.Material;
import entidade.RetornoMaterial;


@Path("/material")
public class MaterialServico {

	MaterialDAO materialDAO;
	
	public MaterialServico() {
		this.materialDAO = new MaterialDAOImpl();
	}
	
	@Path("/")
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String ola() {
		return "Material DetonaDevREST !!!";
	}

	@Path("/inserirMaterial")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoMaterial inserirMaterial(Material material) {
		
		RetornoMaterial retorno = new RetornoMaterial();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.materialDAO.inserirMaterial(material)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Material não inserido!!");
		}

		return retorno;
	}
	
	@Path("/alterarMaterial")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoMaterial alterarMaterial(Material material) {
		
		RetornoMaterial retorno = new RetornoMaterial();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.materialDAO.alterarMaterial(material)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Material não atualizado!!");
		}

		return retorno;
	}
	
	@Path("/excluirMaterial")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoMaterial excluirMaterial(Material material) {
		
		RetornoMaterial retorno = new RetornoMaterial();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(!this.materialDAO.excluirMaterial(material)) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Material não removido!!");
		}

		return retorno;
	}

	
	@Path("/buscarMaterial")
	@POST
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public RetornoMaterial buscarMaterial(Material material) {
		
		RetornoMaterial retorno = new RetornoMaterial();
		retorno.setCodigoRetorno(0);
		retorno.setMsgRetorno("SUCESSO!!!");
		
		if(this.materialDAO.pesquisarMaterial(material.getID()) == null) {
			retorno.setCodigoRetorno(1);
			retorno.setMsgRetorno("FALHA: Material não encontrado!!!!");
		}

		return retorno;
	}
	
}
