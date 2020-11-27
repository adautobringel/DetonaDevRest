package dao;

import java.util.List;

import entidade.Veiculo;

public interface VeiculoDAO {
	public boolean inserirVeiculo(Veiculo veiculo);
	public boolean alterarVeiculo(Veiculo veiculo);
	public boolean excluirVeiculo(Veiculo veiculo);
	public Veiculo pesquisarVeiculo(String placa);
	public List<Veiculo> listarTodos();
}
