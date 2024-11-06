package vitorv.servcad.aplicação.casosDeUso;

import java.util.List;

import org.springframework.stereotype.Component;

import vitorv.servcad.dominio.entidades.Cliente;
import vitorv.servcad.dominio.interfRepositorios.IClienteRepositorio;

@Component
public class ListarClientesUC {
    private final IClienteRepositorio repositorioCliente;

    public ListarClientesUC(IClienteRepositorio repositorioCliente) {
        this.repositorioCliente = repositorioCliente;
    }

    public List<Cliente> execute() {
        return repositorioCliente.todos();
    }
}
