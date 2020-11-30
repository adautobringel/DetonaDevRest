package dao;

import java.util.List;

import entidade.OrdemServico;

public interface OrdemServicoDAO {
	public boolean inserirOrdemServico(OrdemServico ordemServico);
	public boolean alterarOrdemServico(OrdemServico ordemServico);
	public boolean excluirOrdemServico(OrdemServico ordemServico);
	public OrdemServico pesquisarOrdemServico(int id);
	public List<OrdemServico> listarTodos();
}
