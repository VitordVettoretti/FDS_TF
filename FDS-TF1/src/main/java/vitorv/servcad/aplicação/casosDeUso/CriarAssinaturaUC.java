package vitorv.servcad.aplicação.casosDeUso;

import java.time.LocalDate;

import vitorv.servcad.dominio.entidades.Aplicativo;
import vitorv.servcad.dominio.entidades.Assinatura;
import vitorv.servcad.dominio.entidades.Cliente;
import vitorv.servcad.dominio.interfRepositorios.IAssinaturaRepositorio;

public class CriarAssinaturaUC {
    private final IAssinaturaRepositorio repositorioAssinatura;

    public CriarAssinaturaUC(IAssinaturaRepositorio repositorioAssinatura) {
        this.repositorioAssinatura = repositorioAssinatura;
    }

    public Assinatura execute(Long codigoCliente, Long codigoAplicativo) {
        // Cria uma nova assinatura com 7 dias de validade inicial
        Cliente cliente = new Cliente(codigoCliente, "NomeCliente", "email@cliente.com");
        Assinatura novaAssinatura = new Assinatura(1L, codigoAplicativo, cliente.getCodigo(), LocalDate.now(), LocalDate.now().plusDays(7));
        repositorioAssinatura.salvar(novaAssinatura);
        return novaAssinatura;
    }
}
