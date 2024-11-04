package vitorv.servcad.dominio.entidades;

public class Cliente {
    private Long codigo;
    private String nome;
    private String email;

    public Cliente(Long codigo, String nome, String email) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
    }

    public Long getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }
}
