package vitorv.servcad.interfaceAdaptadora.repositorios.implemRepositorios;

import vitorv.servcad.dominio.interfRepositorios.IClienteRepositorio;
import vitorv.servcad.dominio.entidades.Cliente;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class ClienteRepMem implements IClienteRepositorio {
    private List<Cliente> clientes;

    public ClienteRepMem(){
        clientes = new LinkedList<>();
        clientes.add( new Cliente(1L, "João", "joao@gmail.com"));
    }

    @Override
    public List<Cliente> todos() {
        return clientes;
    }

    @Override
    public void salvar(Cliente cliente) {
        Optional<Cliente> existente = clientes.stream()
            .filter(c -> c.getCodigo().equals(cliente.getCodigo()))
            .findFirst();
        if (existente.isPresent()) {
            clientes.remove(existente.get());
        }
        clientes.add(cliente);
    }

    @Override
    public Cliente buscarPorCodigo(Long codigo) {
        return clientes.stream()
            .filter(c -> c.getCodigo().equals(codigo))
            .findFirst()
            .orElse(null);
    }
}
