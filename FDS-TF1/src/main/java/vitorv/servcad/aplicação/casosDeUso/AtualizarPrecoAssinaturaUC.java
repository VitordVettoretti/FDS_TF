package vitorv.servcad.aplicação.casosDeUso;

import vitorv.servcad.dominio.entidades.Aplicativo;
import vitorv.servcad.dominio.interfRepositorios.IAplicativoRepositorio;

public class AtualizarPrecoAssinaturaUC {
    private final IAplicativoRepositorio repositorioAplicativo;

    public AtualizarPrecoAssinaturaUC(IAplicativoRepositorio repositorioAplicativo) {
        this.repositorioAplicativo = repositorioAplicativo;
    }

    public Aplicativo atualizarCusto(Long codigoAplicativo, double novoCusto) {
        Aplicativo aplicativo = repositorioAplicativo.buscarPorCodigo(codigoAplicativo);
        if (aplicativo != null) {
            aplicativo.setCusto(novoCusto);
            repositorioAplicativo.salvar(aplicativo);
        }
        return aplicativo;
    }
}
