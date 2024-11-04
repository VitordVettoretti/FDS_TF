package vitorv.servcad.interfaceAdaptadora.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import vitorv.servcad.aplicação.casosDeUso.RegistrarPagamentoUC;
import vitorv.servcad.aplicação.casosDeUso.AtualizarPrecoAssinaturaUC;
import vitorv.servcad.aplicação.casosDeUso.ListarClientesUC;
import vitorv.servcad.aplicação.casosDeUso.ListarAplicativosUC;
import vitorv.servcad.aplicação.casosDeUso.CriarAssinaturaUC;
import vitorv.servcad.aplicação.casosDeUso.AtualizarCustoAplicativoUC;
import vitorv.servcad.aplicação.casosDeUso.ListarAssinaturasPorTipoUC;
import vitorv.servcad.aplicação.casosDeUso.ListarAssinaturasPorClienteUC;
import vitorv.servcad.aplicação.casosDeUso.ListarAssinaturasPorAplicativoUC;
import vitorv.servcad.aplicação.casosDeUso.VerificarAssinaturaValidaUC;

import vitorv.servcad.dominio.entidades.Cliente;
import vitorv.servcad.dominio.entidades.Aplicativo;
import vitorv.servcad.dominio.entidades.Assinatura;
import vitorv.servcad.dominio.entidades.Pagamento;


@RestController
@RequestMapping("/servcad")
public class Controller {

    private ListarClientesUC listarClientesUC;
    private ListarAplicativosUC listarAplicativosUC;
    private CriarAssinaturaUC criarAssinaturaUC;
    private AtualizarCustoAplicativoUC atualizarCustoAplicativoUC;
    private ListarAssinaturasPorTipoUC listarAssinaturasPorTipoUC;
    private ListarAssinaturasPorClienteUC listarAssinaturasPorClienteUC;
    private ListarAssinaturasPorAplicativoUC listarAssinaturasPorAplicativoUC;
    private RegistrarPagamentoUC registrarPagamentoUC;
    private VerificarAssinaturaValidaUC verificarAssinaturaValidaUC;

    // GET /servcad/clientes - Lista todos os clientes
    @GetMapping("/clientes")
    public List<Cliente> listarClientes() {
        return listarClientesUC.execute();
    }

    // GET /servcad/aplicativos - Lista todos os aplicativos
    @GetMapping("/aplicativos")
    public List<Aplicativo> listarAplicativos() {
        return listarAplicativosUC.execute();
    }

    // POST /servcad/assinaturas - Cria uma nova assinatura
    /*@PostMapping("/assinaturas")
    public Assinatura criarAssinatura(@RequestBody AssinaturaRequest request) {
        return criarAssinaturaUC.execute(request);
    }*/

    // POST /servcad/aplicativos/custo/:idAplicativo - Atualiza o custo do aplicativo
    /*@PostMapping("/aplicativos/custo/{idAplicativo}")
    public Aplicativo atualizarCustoAplicativo(@PathVariable Long idAplicativo, @RequestBody CustoRequest request) {
        return atualizarCustoAplicativoUC.execute(idAplicativo, request);
    }*/

    // GET /servcad/assinaturas/{tipo} - Lista assinaturas por tipo
    @GetMapping("/assinaturas/{tipo}")
    public List<Assinatura> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return listarAssinaturasPorTipoUC.execute(tipo);
    }

    // GET /servcad/clientes/{codcli}/assinaturas - Lista assinaturas de um cliente
    /*@GetMapping("/clientes/{codcli}/assinaturas")
    public List<Assinatura> listarAssinaturasPorCliente(@PathVariable Long codcli) {
        return listarAssinaturasPorClienteUC.execute(codcli);
    }*/

    // GET /servcad/aplicativos/{codapp}/assinaturas - Lista assinaturas de um aplicativo
    /*@GetMapping("/aplicativos/{codapp}/assinaturas")
    public List<Assinatura> listarAssinaturasPorAplicativo(@PathVariable Long codapp) {
        return listarAssinaturasPorAplicativoUC.execute(codapp);
    }*/

    /*@PostMapping("/registrarpagamento")
    public PagamentoResponse registrarPagamento(@RequestBody PagamentoRequest request) {
        return registrarPagamentoUC.execute(request);
    }*/

    /*@GetMapping("/assinvalida/{codass}")
    public boolean verificarAssinaturaInvalida(@PathVariable Long codass) {
        return verificarAssinaturaValidaUC.execute(codass);
    }*/
}