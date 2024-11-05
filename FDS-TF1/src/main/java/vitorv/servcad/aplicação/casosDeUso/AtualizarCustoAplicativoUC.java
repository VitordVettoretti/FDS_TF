package vitorv.servcad.aplicação.casosDeUso;

import vitorv.servcad.dominio.entidades.Aplicativo;
import vitorv.servcad.dominio.interfRepositorios.IAplicativoRepositorio;

public class AtualizarCustoAplicativoUC {
    private final IAplicativoRepositorio repositorioAplicativo;

    public AtualizarCustoAplicativoUC(IAplicativoRepositorio repositorioAplicativo) {
        this.repositorioAplicativo = repositorioAplicativo;
    }

    public Aplicativo execute(Long codigoAplicativo, double novoCusto) {
        Aplicativo aplicativo = repositorioAplicativo.buscarPorCodigo(codigoAplicativo);
        if (aplicativo != null) {
            aplicativo.setCusto(novoCusto);
            repositorioAplicativo.salvar(aplicativo);
        }
        return aplicativo;
    }
}
