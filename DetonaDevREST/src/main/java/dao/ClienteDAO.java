package dao;

import java.util.List;

import entidade.Cliente;

public interface ClienteDAO {
	public boolean inserirCliente(Cliente cliente);
	public boolean alterarCliente(Cliente cliente);
	public boolean excluirCliente(Cliente cliente);
	public Cliente pesquisarCliente(String cpf);
	public List<Cliente> listarTodos();
	
}
