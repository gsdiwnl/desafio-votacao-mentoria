package br.com.db.desafio.votacao.controller.sessao;

import br.com.db.desafio.votacao.model.sessao.Sessao;
import br.com.db.desafio.votacao.model.sessao.Status;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SessaoMapper {

    SessaoResponseDto mapToSessaoResponseDto(Sessao sessao);

    StatusSessaoResponseDto mapToStatusSessaoResponseDto(Status status);

    Sessao toSessao(Sessao sessao, Status status);
}
