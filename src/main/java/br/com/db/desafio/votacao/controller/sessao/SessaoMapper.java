package br.com.db.desafio.votacao.controller.sessao;

import br.com.db.desafio.votacao.model.sessao.Sessao;
import br.com.db.desafio.votacao.model.sessao.Status;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface SessaoMapper {

    SessaoResponseDto mapToSessaoResponseDto(Sessao sessao);

    StatusSessaoResponseDto mapToStatusSessaoResponseDto(Status status);

    @Mapping(target = "inicio", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "status", constant = "ABERTA")
    SessaoDto mapToSessaoDto(LocalDateTime fim);
}
