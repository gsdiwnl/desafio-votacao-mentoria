package br.com.db.desafio.votacao.service.validador;

import br.com.db.desafio.votacao.model.sessao.Sessao;
import br.com.db.desafio.votacao.model.voto.SituacaoVoto;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class DadosValidacao {

    private final Long idPauta;
    private final String cpfAssociado;
    private final Sessao sessao;
    private final SituacaoVoto situacaoVoto;
}
