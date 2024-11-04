package vitorv.servcad.interfaceAdaptadora.repositorios.implemRepositorios;

import vitorv.servcad.dominio.interfRepositorios.IAssinaturaRepositorio;
import vitorv.servcad.dominio.entidades.Assinatura;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class AssinaturaRepMem implements IAssinaturaRepositorio {
    private List<Assinatura> assinaturas;

    public AssinaturaRepMem(){
        assinaturas = new LinkedList<>();
    }
    
    @Override
    public List<Assinatura> todos() {
        return assinaturas;
    }

    @Override
    public void salvar(Assinatura assinatura) {
        Optional<Assinatura> existente = assinaturas.stream()
            .filter(a -> a.getCodigo().equals(assinatura.getCodigo()))
            .findFirst();
        if (existente.isPresent()) {
            assinaturas.remove(existente.get());
        }
        assinaturas.add(assinatura);
    }

    @Override
    public Assinatura buscarPorCodigo(Long codigo) {
        return assinaturas.stream()
            .filter(a -> a.getCodigo().equals(codigo))
            .findFirst()
            .orElse(null);
    }
}
