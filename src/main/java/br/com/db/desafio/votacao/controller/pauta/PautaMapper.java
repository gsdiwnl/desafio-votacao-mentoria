package br.com.db.desafio.votacao.controller.pauta;

import br.com.db.desafio.votacao.controller.sessao.SessaoDto;
import br.com.db.desafio.votacao.model.pauta.Pauta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PautaMapper {

    Pauta mapToPauta(PautaRequestDto pautaRequestDto, SessaoDto sessaoDto);

    @Mapping(target = "fimSessao", source = "pauta.sessao.fim")
    PautaResponseDto mapToPautaResponseDto(Pauta pauta);

    ResultadoPautaResponseDto mapToPautaResponseDto(Long totalFavor, Long totalContra, String resultado);
}
