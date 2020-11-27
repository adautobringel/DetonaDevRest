import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entidade.Cliente;
import entidade.Veiculo;

public class TesteGeral {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
		
		Cliente c = new Cliente();
		c.setCpf("4564");
		
		Veiculo v = new Veiculo();
		v.setPlaca("JCX9890");
	/*	v.setFabricante("FORD");
		v.setModelo("ECOSPORT");
		v.setCor("PRATA");
		v.setTipo("UTILITARIO");
		v.setAno(2020);
	*/	
//	v.setCliente(c);
	
//	veiculoDAO.excluirVeiculo(v);
		
//		clienteDAO.excluirCliente(c);

	}

}
