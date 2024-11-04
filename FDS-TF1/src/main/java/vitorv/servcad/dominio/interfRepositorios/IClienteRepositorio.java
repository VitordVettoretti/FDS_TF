package vitorv.servcad.dominio.interfRepositorios;

import java.util.List;
import vitorv.servcad.dominio.entidades.Cliente;

public interface IClienteRepositorio {
    List<Cliente> todos();
    void salvar(Cliente cliente);
    Cliente buscarPorCodigo(Long codigo);
}
