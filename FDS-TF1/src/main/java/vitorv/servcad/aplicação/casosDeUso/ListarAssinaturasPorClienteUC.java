package vitorv.servcad.aplicação.casosDeUso;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import vitorv.servcad.dominio.entidades.Assinatura;
import vitorv.servcad.dominio.interfRepositorios.IAssinaturaRepositorio;

public class ListarAssinaturasPorClienteUC {
    private final IAssinaturaRepositorio repositorioAssinatura;

    public ListarAssinaturasPorClienteUC(IAssinaturaRepositorio repositorioAssinatura) {
        this.repositorioAssinatura = repositorioAssinatura;
    }

    public List<Assinatura> execute(Long codigoCliente) {
        List<Assinatura> assinaturas = repositorioAssinatura.todos();
        //LocalDate hoje = LocalDate.now();

        return assinaturas.stream()
            .filter(assinatura -> assinatura.getCliente().equals(codigoCliente))
            .map(assinatura -> new Assinatura(
                assinatura.getCodigo(),
                assinatura.getCliente(),
                assinatura.getAplicativo(),
                assinatura.getInicioVigencia(),
                assinatura.getFimVigencia()
            ))
            .collect(Collectors.toList());
    }
}
