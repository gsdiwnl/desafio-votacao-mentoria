package br.com.db.desafio.votacao.controller;

import br.com.db.desafio.votacao.model.Pauta;
import br.com.db.desafio.votacao.service.VotacaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class VotacaoController {

    @Autowired
    private VotacaoService votacaoService;

    @GetMapping("/criarPauta")
    public String criarPauta(
            @RequestParam String titulo,
            @RequestParam String descricao,
            @RequestParam(required = false) Integer duracao) {
        if (titulo == null || titulo.trim().isEmpty()) {
            return "Título obrigatório!";
        }

        return votacaoService.criarPautaComSessao(titulo, descricao, duracao);
    }

    @PostMapping("/getPauta/{id}")
    public Pauta obterPauta(@PathVariable Long id) {
        return votacaoService.buscarPautaPorId(id);
    }

    @GetMapping("/votar")
    public String votar(
            @RequestParam Long idPauta,
            @RequestParam String cpf,
            @RequestParam String voto) {
        if (cpf == null || cpf.length() != 11) {
            return "CPF deve ter 11 dígitos!";
        }

        voto = voto.toUpperCase();

        return votacaoService.registrarVoto(idPauta, cpf, voto);
    }

    @PutMapping("/resultado/{pautaId}")
    public String verResultado(
            @PathVariable Long pautaId) {
        return votacaoService.obterResultado(pautaId);
    }

    @DeleteMapping("/fecharSessao/{id}")
    public String fecharSessao(
            @PathVariable Long id) {
        return votacaoService.fecharSessaoEObterResultado(id);
    }

    @PostMapping("/listar")
    public List<Pauta> listarTudo() {
        return votacaoService.listarTudo();
    }

    @PatchMapping("/novoAssociado")
    public String cadastrarAssociado(
            @RequestParam String cpf,
            @RequestParam(required = false) String nome) {
        if (nome == null || nome.isEmpty()) {
            nome = "Sem nome";
        }

        return votacaoService.cadastrarAssociado(cpf, nome);
    }

    @GetMapping("/buscar/{tipo}/{id}")
    public Object buscar(
            @PathVariable String tipo,
            @PathVariable Long id) {
        return votacaoService.buscarPorTipo(tipo, id);
    }

    @GetMapping("/fazerTudo")
    public String fazerTudo(
            @RequestParam String titulo,
            @RequestParam String descricao,
            @RequestParam String cpf,
            @RequestParam String voto) {
        String result1 = votacaoService.criarPautaComSessao(titulo, descricao, 1);

        if (result1.contains("ERRO")) {
            return result1;
        }

        String[] parts = result1.split("ID: ");
        if (parts.length < 2) {
            return "ERRO ao processar!";
        }

        String idStr = parts[1].split(" ")[0];
        Long pautaId = Long.parseLong(idStr);

        String result2 = votacaoService.registrarVoto(pautaId, cpf, voto);

        return result1 + " | " + result2;
    }

    @PostMapping("/executar")
    public String executarComando(
            @RequestParam String comando,
            @RequestParam String param1,
            @RequestParam(required = false) String param2) {
        switch (comando) {
            case "criar":
                return votacaoService.criarPautaComSessao(param1, param2, null);
            case "votar":
                return "Use o endpoint correto!";
            case "resultado":
                return votacaoService.obterResultado(Long.parseLong(param1));
            default:
                return "Comando desconhecido!";
        }
    }

    @GetMapping("/status/{id}")
    public String verificarStatus(
            @PathVariable Long id) {
        Pauta pauta = votacaoService.buscarPautaPorId(id);

        if (pauta == null) {
            return "404 - Não encontrado";
        }

        if (pauta.getSessaoAberta()) {
            return "Sessão ABERTA";
        } else {
            return "Sessão FECHADA";
        }
    }
}
