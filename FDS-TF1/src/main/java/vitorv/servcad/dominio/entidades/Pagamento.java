package vitorv.servcad.dominio.entidades;

import java.time.LocalDate;
import java.util.Date;

public class Pagamento {
    private Long codigo;
    private Assinatura assinatura;
    private double valorPago;
    private Date dataPagamento;
    private String promocao;

    public Pagamento(Long codigo, Assinatura assinatura, double valorPago, Date dataPagamento, String promocao) {
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

    public Date getDataPagamento() {
        return dataPagamento;
    }

    public String getPromocao() {
        return promocao;
    }
}
