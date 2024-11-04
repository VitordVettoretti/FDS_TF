package vitorv.servcad.dominio.interfRepositorios;

import java.util.List;

import vitorv.servcad.dominio.entidades.Assinatura;

public interface IAssinaturaRepositorio {
    List<Assinatura> todos();
    void salvar(Assinatura assinatura);
    Assinatura buscarPorCodigo(Long codigo);
}
