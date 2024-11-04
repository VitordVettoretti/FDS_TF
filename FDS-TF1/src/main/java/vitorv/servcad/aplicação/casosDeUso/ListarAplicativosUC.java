package vitorv.servcad.aplicação.casosDeUso;

import java.util.List;

import vitorv.servcad.dominio.entidades.Aplicativo;
import vitorv.servcad.dominio.interfRepositorios.IAplicativoRepositorio;

public class ListarAplicativosUC {
    private final IAplicativoRepositorio repositorioAplicativo;

    public ListarAplicativosUC(IAplicativoRepositorio repositorioAplicativo) {
        this.repositorioAplicativo = repositorioAplicativo;
    }

    public List<Aplicativo> execute() {
        return repositorioAplicativo.todos();
    }
}
