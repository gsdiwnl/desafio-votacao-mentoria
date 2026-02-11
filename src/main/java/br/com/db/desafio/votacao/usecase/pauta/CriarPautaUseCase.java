package br.com.db.desafio.votacao.usecase.pauta;

import br.com.db.desafio.votacao.controller.pauta.dto.AssembleiaResponseDto;
import br.com.db.desafio.votacao.controller.pauta.dto.PautaRequestDto;
import br.com.db.desafio.votacao.controller.sessao.dto.SessaoDto;

public interface CriarPautaUseCase {

    AssembleiaResponseDto criar(PautaRequestDto request, SessaoDto sessaoDto);
}
