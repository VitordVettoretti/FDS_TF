package vitorv.servcad.interfaceAdaptadora.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/biblioteca")
public class Controller{
    private List<Livro> livros;

    public Controller(){
        livros = new ArrayList<>();
        livros.add(new Livro(1, "O Senhor dos Anéis", "J.R.R. Tolkien", 1954));
        livros.add(new Livro(2, "Dom Quixote", "Miguel de Cervantes", 1605));
        livros.add(new Livro(3, "O Pequeno Príncipe", "Antoine de Saint-Exupéry", 1943));
    }

    @GetMapping
    public String hello(){
        return "Hello World!";
    }

    @GetMapping("/livros")
    public List<Livro> livros(){
        return livros;
    }
    
    @GetMapping("/titulos")
    public List<String> titulos(){
        return livros
                .stream()
                .map(Livro -> Livro.getTitulo())
                .toList();
    }

    @GetMapping("/autores")
    public List<String> autores(){
        return livros
                .stream()
                .map(Livro -> Livro.getAutor())
                .distinct() // Remove duplicados
                .toList();
    }

    @GetMapping("/livrosautor")
    public List<Livro> getLivrosDoAutor(@RequestParam String autor){
        return livros
                .stream()
                .filter(Livro -> Livro.getAutor().equals(autor))
                .toList();
    }
}
 