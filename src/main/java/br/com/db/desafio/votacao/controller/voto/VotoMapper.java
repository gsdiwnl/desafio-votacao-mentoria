package br.com.db.desafio.votacao.controller.voto;

import br.com.db.desafio.votacao.model.pauta.Pauta;
import br.com.db.desafio.votacao.model.voto.Voto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.time.LocalDateTime;

@Mapper(componentModel = "spring")
public interface VotoMapper {

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "pautaId", source = "pauta.id")
    @Mapping(target = "cpfAssociado", source = "request.cpfAssociado")
    @Mapping(target = "situacao", source = "request.voto")
    Voto toVoto(VotoRequestDto request, Pauta pauta, LocalDateTime dataHora);

    VotoResponseDto toVotoResponseDto(Voto voto);
}
