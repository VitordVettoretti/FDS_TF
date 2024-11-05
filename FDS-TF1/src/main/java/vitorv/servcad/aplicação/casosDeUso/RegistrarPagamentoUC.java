package vitorv.servcad.aplicação.casosDeUso;

import java.time.LocalDate;
import java.util.Date;

import vitorv.servcad.dominio.entidades.Assinatura;
import vitorv.servcad.dominio.entidades.Pagamento;
import vitorv.servcad.dominio.interfRepositorios.IAssinaturaRepositorio;
import vitorv.servcad.dominio.interfRepositorios.IPagamentoRepositorio;

public class RegistrarPagamentoUC {
    private final IAssinaturaRepositorio repositorioAssinatura;
    private final IPagamentoRepositorio repositorioPagamento;

    public RegistrarPagamentoUC(IAssinaturaRepositorio repositorioAssinatura, IPagamentoRepositorio repositorioPagamento) {
        this.repositorioAssinatura = repositorioAssinatura;
        this.repositorioPagamento = repositorioPagamento;
    }

    public Pagamento execute(Date dataPagamento, Long codigoAssinatura, double valorPago, String promocao) {
        Assinatura assinatura = repositorioAssinatura.buscarPorCodigo(codigoAssinatura);
        Pagamento pagamento = new Pagamento(1L, assinatura, valorPago, dataPagamento, promocao);

        // Lógica de estender validade
        if (assinatura.getFimVigencia().isBefore(LocalDate.now())) {
            // Assinatura cancelada, reativar e adicionar 30 dias a partir do pagamento
            assinatura.setFimVigencia(LocalDate.now().plusDays(30));
        } else {
            // Assinatura ativa, adicionar 30 dias ao fim atual
            assinatura.setFimVigencia(assinatura.getFimVigencia().plusDays(30));
        }

        // Salva o pagamento e atualiza a assinatura
        repositorioPagamento.salvar(pagamento);
        repositorioAssinatura.salvar(assinatura);

        return pagamento;
    }
}
