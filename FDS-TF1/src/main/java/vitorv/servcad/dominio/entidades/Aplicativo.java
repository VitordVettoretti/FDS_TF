package vitorv.servcad.dominio.entidades;

public class Aplicativo {
    private Long codigo;
    private String nome;
    private double custo;

    public Aplicativo(Long codigo, String nome, double custo) {
        this.codigo = codigo;
        this.nome = nome;
        this.custo = custo;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getCusto() {
        return custo;
    }

    public void setCusto(double custo) {
        this.custo = custo;
    }
}
