package vitorv.servcad.dominio.entidades;

import java.time.LocalDate;

public class Pagamento {
    private Long codigo;
    private Assinatura assinatura;
    private double valorPago;
    private LocalDate dataPagamento;
    private String promocao;

    public Pagamento(Long codigo, Assinatura assinatura, double valorPago, LocalDate dataPagamento, String promocao) {
        this.codigo = codigo;
        this.assinatura = assinatura;
        this.valorPago = valorPago;
        this.dataPagamento = dataPagamento;
        this.promocao = promocao;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Assinatura getAssinatura() {
        return assinatura;
    }

    public double getValorPago() {
        return valorPago;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }
}
