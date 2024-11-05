package vitorv.servcad.aplicação.casosDeUso;

import java.time.LocalDate;

import vitorv.servcad.dominio.entidades.Assinatura;
import vitorv.servcad.dominio.interfRepositorios.IAssinaturaRepositorio;

public class VerificarAssinaturaValidaUC {
    private final IAssinaturaRepositorio repositorioAssinatura;

    public VerificarAssinaturaValidaUC(IAssinaturaRepositorio repositorioAssinatura) {
        this.repositorioAssinatura = repositorioAssinatura;
    }

    public boolean execute(Long codigoAssinatura) {
        Assinatura assinatura = repositorioAssinatura.buscarPorCodigo(codigoAssinatura);
        if (assinatura == null) {
            return false;
        }
        LocalDate hoje = LocalDate.now();
        return assinatura.getFimVigencia().isAfter(hoje);
    }
}
