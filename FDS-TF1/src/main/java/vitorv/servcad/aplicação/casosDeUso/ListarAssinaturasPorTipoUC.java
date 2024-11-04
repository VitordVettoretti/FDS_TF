package vitorv.servcad.aplicação.casosDeUso;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import vitorv.servcad.dominio.entidades.Assinatura;
import vitorv.servcad.dominio.interfRepositorios.IAssinaturaRepositorio;


public class ListarAssinaturasPorTipoUC {
    private final IAssinaturaRepositorio repositorioAssinatura;

    public ListarAssinaturasPorTipoUC(IAssinaturaRepositorio repositorioAssinatura) {
        this.repositorioAssinatura = repositorioAssinatura;
    }

    public List<Assinatura> execute(String tipo) {
        List<Assinatura> assinaturas = repositorioAssinatura.todos();
        LocalDate hoje = LocalDate.now();

        return assinaturas.stream()
            .filter(assinatura -> {
                if ("ATIVAS".equals(tipo)) {
                    return assinatura.getFimVigencia().isAfter(hoje);
                } else if ("CANCELADAS".equals(tipo)) {
                    return !assinatura.getFimVigencia().isAfter(hoje);
                }
                return true; // TODAS
            })
            .map(assinatura -> new Assinatura(
                assinatura.getCodigo(),
                assinatura.getCliente(),
                assinatura.getAplicativo(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia()
                //assinatura.getStatus()
            ))
            .collect(Collectors.toList());
    }
}
