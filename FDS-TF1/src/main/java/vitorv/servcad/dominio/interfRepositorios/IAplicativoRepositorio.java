package vitorv.servcad.dominio.interfRepositorios;

import vitorv.servcad.dominio.entidades.Aplicativo;

public interface IAplicativoRepositorio {
    void salvar(Aplicativo aplicativo);
    Aplicativo buscarPorCodigo(Long codigo);
}
