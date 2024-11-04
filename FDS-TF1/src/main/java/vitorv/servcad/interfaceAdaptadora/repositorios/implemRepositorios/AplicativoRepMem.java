package vitorv.servcad.interfaceAdaptadora.repositorios.implemRepositorios;

import vitorv.servcad.dominio.interfRepositorios.IAplicativoRepositorio;
import vitorv.servcad.dominio.entidades.Aplicativo;

import java.util.Optional;
import java.util.List;
import java.util.LinkedList;

public class AplicativoRepMem implements IAplicativoRepositorio {
    private List<Aplicativo> aplicativos;

    public AplicativoRepMem(){
        aplicativos = new LinkedList<>();
    }

    public List<Aplicativo> todos() {
        return aplicativos;
    }
    @Override
    public void salvar(Aplicativo aplicativo) {
        Optional<Aplicativo> existente = aplicativos.stream()
            .filter(a -> a.getCodigo().equals(aplicativo.getCodigo()))
            .findFirst();
        if (existente.isPresent()) {
            aplicativos.remove(existente.get());
        }
        aplicativos.add(aplicativo);
    }

    @Override
    public Aplicativo buscarPorCodigo(Long codigo) {
        return aplicativos.stream()
        .filter(p->p.getCodigo() == codigo)
        .findFirst()
        .orElse(null);
    }

}
