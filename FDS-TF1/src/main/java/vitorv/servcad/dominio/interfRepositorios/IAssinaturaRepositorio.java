package vitorv.servcad.dominio.interfRepositorios;

import vitorv.servcad.dominio.entidades.Assinatura;

public interface IAssinaturaRepositorio {
    void salvar(Assinatura assinatura);
    Assinatura buscarPorCodigo(Long codigo);
}
