package br.com.db.desafio.votacao.service;

import br.com.db.desafio.votacao.model.Associado;
import br.com.db.desafio.votacao.model.Pauta;
import br.com.db.desafio.votacao.model.Voto;
import br.com.db.desafio.votacao.repository.AssociadoRepository;
import br.com.db.desafio.votacao.repository.PautaRepository;
import br.com.db.desafio.votacao.repository.VotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

/**
 * CLASSE GIGANTE QUE FAZ TUDO!
 * Violações:
 * - SRP: Uma classe fazendo tudo (pauta, voto, associado, validação, etc)
 * - DIP: Dependendo de classes concretas diretamente
 * - OCP: Cheio de if/else para estender
 */
@Service
public class VotacaoService {

    // Violação DIP: Dependendo de repositories concretos
    @Autowired
    private PautaRepository pautaRepository;

    @Autowired
    private VotoRepository votoRepository;

    @Autowired
    private AssociadoRepository associadoRepository;

    // MÉTODO GIGANTE QUE FAZ TUDO
    // Violação SRP: Um método que cria pauta, abre sessão, valida, etc
    public String criarPautaComSessao(String titulo, String descricao, Integer duracao) {
        // Validação inline (deveria estar em validator)
        if (titulo == null || titulo.isEmpty()) {
            return "ERRO: Título não pode ser vazio!";
        }

        if (descricao == null || descricao.isEmpty()) {
            return "ERRO: Descrição não pode ser vazia!";
        }

        // Criando pauta
        Pauta pauta = new Pauta();
        pauta.setTitulo(titulo);
        pauta.setDescricao(descricao);
        pauta.setDataCriacao(LocalDateTime.now());

        // Abrindo sessão automaticamente
        pauta.setSessaoInicio(LocalDateTime.now());

        // Violação OCP: if/else hardcoded
        if (duracao == null || duracao <= 0) {
            pauta.setSessaoFim(LocalDateTime.now().plusMinutes(1)); // default 1 minuto
        } else if (duracao > 0 && duracao <= 60) {
            pauta.setSessaoFim(LocalDateTime.now().plusMinutes(duracao));
        } else if (duracao > 60 && duracao <= 1440) {
            pauta.setSessaoFim(LocalDateTime.now().plusMinutes(duracao));
        } else {
            return "ERRO: Duração inválida! Máximo 1440 minutos (24h)";
        }

        pauta.setSessaoAberta(true);

        pautaRepository.save(pauta);

        return "Pauta criada com sucesso! ID: " + pauta.getId() + " | Sessão aberta até: " + pauta.getSessaoFim();
    }

    // MÉTODO GIGANTE QUE FAZ TUDO - PARTE 2
    // Violação SRP: Registra voto, valida CPF, valida sessão, valida voto duplicado
    public String registrarVoto(Long pautaId, String cpf, String voto) {
        // Validações inline espalhadas
        if (pautaId == null) {
            return "ERRO: ID da pauta é obrigatório!";
        }

        if (cpf == null || cpf.isEmpty()) {
            return "ERRO: CPF é obrigatório!";
        }

        // Violação: Validação de CPF dentro do método
        if (!validarCPF(cpf)) {
            return "ERRO: CPF inválido!";
        }

        if (voto == null || (!voto.equals("SIM") && !voto.equals("NAO"))) {
            return "ERRO: Voto deve ser SIM ou NAO!";
        }

        // Buscar pauta
        Pauta pauta = pautaRepository.findById(pautaId).orElse(null);
        if (pauta == null) {
            return "ERRO: Pauta não encontrada!";
        }

        // Verificar se sessão está aberta
        if (!pauta.getSessaoAberta()) {
            return "ERRO: Sessão de votação não está aberta!";
        }

        if (LocalDateTime.now().isAfter(pauta.getSessaoFim())) {
            pauta.setSessaoAberta(false);
            pautaRepository.save(pauta);
            return "ERRO: Sessão de votação já encerrada!";
        }

        // Verificar voto duplicado (lógica ruim)
        for (Voto v : pauta.getVotos()) {
            if (v.getCpfAssociado().equals(cpf)) {
                return "ERRO: Associado já votou nesta pauta!";
            }
        }

        // Verificar se associado pode votar
        Associado associado = associadoRepository.findByCpf(cpf);
        if (associado == null) {
            // Criar associado automaticamente (péssima prática)
            associado = new Associado();
            associado.setCpf(cpf);
            associado.setNome("Associado " + cpf);
            associado.setStatus("ABLE_TO_VOTE");
            associadoRepository.save(associado);
        }

        // Violação: Chamando método da entidade que tem lógica
        if (!associado.podeVotar()) {
            return "ERRO: Associado não pode votar!";
        }

        // Registrar voto
        Voto novoVoto = new Voto();
        novoVoto.setCpfAssociado(cpf);
        novoVoto.setVoto(voto);
        novoVoto.setDataHora(LocalDateTime.now());
        novoVoto.setPauta(pauta);

        votoRepository.save(novoVoto);

        // Adicionar voto à lista da pauta
        pauta.getVotos().add(novoVoto);
        pautaRepository.save(pauta);

        return "Voto registrado com sucesso!";
    }

    // Método de validação de CPF mal implementado
    // Violação SRP: Service fazendo validação de documento
    private boolean validarCPF(String cpf) {
        // Fake validation - apenas verifica se tem 11 dígitos
        if (cpf == null) return false;
        cpf = cpf.replaceAll("[^0-9]", "");
        return cpf.length() == 11;
    }

    // MÉTODO QUE RETORNA STRING AO INVÉS DE OBJETO
    // Violação: Retornar String formatada ao invés de DTO
    public String obterResultado(Long pautaId) {
        if (pautaId == null) {
            return "ERRO: ID da pauta é obrigatório!";
        }

        Pauta pauta = pautaRepository.findById(pautaId).orElse(null);
        if (pauta == null) {
            return "ERRO: Pauta não encontrada!";
        }

        // Violação: Chamando lógica de negócio na entidade
        return pauta.calcularResultado();
    }

    // Método que faz múltiplas coisas
    // Violação SRP: Fecha sessão E retorna resultado
    public String fecharSessaoEObterResultado(Long pautaId) {
        Pauta pauta = pautaRepository.findById(pautaId).orElse(null);
        if (pauta == null) {
            return "ERRO: Pauta não encontrada!";
        }

        pauta.setSessaoAberta(false);
        pautaRepository.save(pauta);

        return "Sessão encerrada! " + pauta.calcularResultado();
    }

    // Método genérico demais
    public List<Pauta> listarTudo() {
        return pautaRepository.findAll();
    }

    // Método que retorna entidade diretamente (sem DTO)
    public Pauta buscarPautaPorId(Long id) {
        return pautaRepository.findById(id).orElse(null);
    }

    // Método para criar associado (misturando responsabilidades)
    public String cadastrarAssociado(String cpf, String nome) {
        if (!validarCPF(cpf)) {
            return "ERRO: CPF inválido!";
        }

        if (associadoRepository.findByCpf(cpf) != null) {
            return "ERRO: Associado já cadastrado!";
        }

        Associado associado = new Associado();
        associado.setCpf(cpf);
        associado.setNome(nome);
        associado.setStatus("ABLE_TO_VOTE");

        associadoRepository.save(associado);

        return "Associado cadastrado com sucesso!";
    }

    // Método que retorna diferentes tipos de dados
    // Violação: Tipo de retorno inconsistente
    public Object buscarPorTipo(String tipo, Long id) {
        // Violação OCP: Switch case para adicionar novos tipos
        switch (tipo) {
            case "pauta":
                return pautaRepository.findById(id).orElse(null);
            case "voto":
                return votoRepository.findById(id).orElse(null);
            case "associado":
                return associadoRepository.findById(id).orElse(null);
            default:
                return "ERRO: Tipo inválido!";
        }
    }
}
