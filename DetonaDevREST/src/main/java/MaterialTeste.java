import dao.ClienteDAO;
import dao.ClienteDAOImpl;
import dao.MaterialDAO;
import dao.MaterialDAOImpl;
import dao.VeiculoDAO;
import dao.VeiculoDAOImpl;
import entidade.Cliente;
import entidade.Material;
import entidade.Veiculo;

public class MaterialTeste {

	public static void main(String[] args) {
		MaterialDAO materialDAO = new MaterialDAOImpl();
		
		Material m = new Material();
		m.setCodigo("A12345");
		m.setDescricao("Sensor de rotação de baixa");
		m.setClasse("Eletrica");
		m.setValorUnitario(124.7);
		
		materialDAO.inserirMaterial(m);
		

	}

}
