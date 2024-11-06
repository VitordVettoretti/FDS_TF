package vitorv.servcad.interfaceAdaptadora.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.*;
import java.time.LocalDate;
import java.util.Date;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

import vitorv.servcad.aplicação.casosDeUso.RegistrarPagamentoUC;
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
    @Autowired
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
    @PostMapping("/assinaturas")
    public Assinatura criarAssinatura(@RequestBody AssinaturaRequest request) {
        return criarAssinaturaUC.execute(request.getClienteCodigo(), request.getCodigoAplicativo());
    }

    // POST /servcad/aplicativos/custo/:idAplicativo - Atualiza o custo do aplicativo
    @PostMapping("/aplicativos/custo/{idAplicativo}")
    public Aplicativo atualizarCustoAplicativo(@PathVariable Long idAplicativo, @RequestBody CustoRequest request) {
        return atualizarCustoAplicativoUC.execute(idAplicativo, request.getCusto());
    }

    // GET /servcad/assinaturas/{tipo} - Lista assinaturas por tipo
    @GetMapping("/assinaturas/{tipo}")
    public List<Assinatura> listarAssinaturasPorTipo(@PathVariable String tipo) {
        return listarAssinaturasPorTipoUC.execute(tipo);
    }

    // GET /servcad/clientes/{codcli}/assinaturas - Lista assinaturas de um cliente
    @GetMapping("/clientes/{codcli}/assinaturas")
    public List<Assinatura> listarAssinaturasPorCliente(@PathVariable Long codcli) {
        return listarAssinaturasPorClienteUC.execute(codcli);
    }

    // GET /servcad/aplicativos/{codapp}/assinaturas - Lista assinaturas de um aplicativo
    @GetMapping("/aplicativos/{codapp}/assinaturas")
    public List<Assinatura> listarAssinaturasPorAplicativo(@PathVariable Long codapp) {
        return listarAssinaturasPorAplicativoUC.execute(codapp);
    }

    /*@PostMapping("/registrarpagamento")
    public PagamentoResponse registrarPagamento(@RequestBody PagamentoRequest request) {
        return registrarPagamentoUC.execute(request.getDataPagamento(), request.getCodigoAssinatura(), request.getValorPago(), "none");
    }*/

    @GetMapping("/assinvalida/{codass}")
    public boolean verificarAssinaturaInvalida(@PathVariable Long codass) {
        return verificarAssinaturaValidaUC.execute(codass);
    }

    public class AssinaturaRequest {
        private Long codigoCliente;
        private Long codigoAplicativo;

        public Long getClienteCodigo() {
            return codigoCliente;
        }
    
        public void setCodigoCliente(Long clienteId) {
            this.codigoCliente = clienteId;
        }
    
        public Long getCodigoAplicativo() {
            return codigoAplicativo;
        }
    
        public void setCodigoAplicativo(Long aplicativoId) {
            this.codigoAplicativo = aplicativoId;
        }
    }

    public class CustoRequest {
        private double custo;

        public double getCusto() {
            return custo;
        }

        public void setCusto(double custo) {
            this.custo = custo;
        }
    }

    public class PagamentoRequest {
        private Date dataPagamento;
        private Long codigoAssinatura;
        private double valorPago;

        public Date getDataPagamento() {
            return dataPagamento;
        }

        public void setDataPagamento(Date dataPagamento) {
            this.dataPagamento = dataPagamento;
        }

        public Long getCodigoAssinatura() {
            return codigoAssinatura;
        }

        public void setCodigoAssinatura(Long codigoAssinatura) {
            this.codigoAssinatura = codigoAssinatura;
        }

        public double getValorPago() {
            return valorPago;
        }

        public void setValorPago(double valorPago) {
            this.valorPago = valorPago;
        }
    }

    public class PagamentoResponse {
        private Long codigo;
        private Assinatura assinatura;
        private double valorPago;
        private Date dataPagamento;
        private String promocao;

        public PagamentoResponse(Long codigo, Assinatura assinatura, double valorPago, Date dataPagamento, String promocao) {
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
}
    