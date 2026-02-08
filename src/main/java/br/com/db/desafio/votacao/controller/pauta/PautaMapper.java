package br.com.db.desafio.votacao.controller.pauta;

import br.com.db.desafio.votacao.model.pauta.Pauta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface PautaMapper {

    @Mapping(target = "sessao.fim", source = "fimSessao")
    Pauta mapToPauta(PautaRequestDto pautaRequestDto, LocalDateTime fimSessao);

    @Mapping(target = "fimSessao", source = "pauta.sessao.fim")
    PautaResponseDto mapToPautaResponseDto(Pauta pauta);

    ResultadoPautaResponseDto mapToPautaResponseDto(Long totalFavor, Long totalContra, String resultado);
}
