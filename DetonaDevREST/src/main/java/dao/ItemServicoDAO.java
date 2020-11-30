package dao;

import java.util.List;

import entidade.ItemServico;

public interface ItemServicoDAO {
	public boolean inserirItemServico(ItemServico itemServico);
	public boolean alterarItemServico(ItemServico itemServico);
	public boolean excluirItemServico(ItemServico itemServico);
	public ItemServico pesquisarItemServico(int id);
	public List<ItemServico> listarTodos();
}
