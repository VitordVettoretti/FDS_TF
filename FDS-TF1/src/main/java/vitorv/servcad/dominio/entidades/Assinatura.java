package vitorv.servcad.dominio.entidades;

import java.time.LocalDate;

public class Assinatura {
    private Long codigo;
    private Long aplicativoCodigo;
    private Long clienteCodigo;
    private LocalDate inicioVigencia;
    private LocalDate fimVigencia;
    private String status;

    public Assinatura(Long codigo, Long aplicativoCodigo, Long clienteCodigo, LocalDate inicioVigencia, LocalDate fimVigencia) {
        this.codigo = codigo;
        this.aplicativoCodigo = aplicativoCodigo;
        this.clienteCodigo = clienteCodigo;
        this.inicioVigencia = inicioVigencia;
        this.fimVigencia = fimVigencia;
    }

    public Long getCodigo() {
        return codigo;
    }

    public Long getAplicativo() {
        return aplicativoCodigo;
    }

    public Long getCliente() {
        return clienteCodigo;
    }

    public LocalDate getInicioVigencia() {
        return inicioVigencia;
    }

    public LocalDate getFimVigencia() {
        return fimVigencia;
    }

    public void setFimVigencia(LocalDate fimVigencia) {
        this.fimVigencia = fimVigencia;
    }

    public String getStatus() {
        return status;
    }
}
