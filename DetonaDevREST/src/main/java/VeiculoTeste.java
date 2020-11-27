import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entidade.Cliente;
import entidade.Veiculo;

public class VeiculoTeste {

	public static void main(String[] args) {
		ClienteDAO clienteDAO = new ClienteDAOImpl();
		VeiculoDAO veiculoDAO = new VeiculoDAOImpl();
		
		Cliente c = new Cliente();
		c.setCpf("4321");
		c.setNome("Anibal dos Santos");
		c.setEmail("qwe@asd.com");
		c.setTelefone("9823453");

		
		Veiculo v = new Veiculo();
		v.setPlaca("JWE4506");
		v.setFabricante("WOLKS");
		v.setModelo("FUSCA");
		v.setCor("BRANCO");
		v.setTipo("PASSEIO");
		v.setAno(2020);
		
	v.setCliente(c);

	if(clienteDAO.pesquisarCliente(c.getCpf())==null) {
		clienteDAO.inserirCliente(c);		
	}
	if(veiculoDAO.pesquisarVeiculo(v.getPlaca())==null)
	{
	veiculoDAO.inserirVeiculo(v);}
		
//		clienteDAO.excluirCliente(c);

	}

}
