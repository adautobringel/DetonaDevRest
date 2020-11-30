package dao;

import java.util.List;

import entidade.Material;

public interface MaterialDAO {
	public boolean inserirMaterial(Material material);
	public boolean alterarMaterial(Material material);
	public boolean excluirMaterial(Material material);
	public Material pesquisarMaterial(int id);
	public List<Material> listarTodos();
	
}
