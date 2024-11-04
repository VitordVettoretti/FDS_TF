package vitorv.servcad.dominio.interfRepositorios;

import java.util.List;

import vitorv.servcad.dominio.entidades.Aplicativo;

public interface IAplicativoRepositorio {
    List<Aplicativo> todos();
    void salvar(Aplicativo aplicativo);
    Aplicativo buscarPorCodigo(Long codigo);
}
