package br.com.db.desafio.votacao.service.validador;


import br.com.db.desafio.votacao.controller.voto.VotoRequestDto;
import br.com.db.desafio.votacao.model.pauta.Pauta;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ValidadorMapper {

    @Mapping(target = "idPauta", source = "pauta.id")
    @Mapping(target = "cpfAssociado", source = "request.cpfAssociado")
    @Mapping(target = "sessao", source = "pauta.sessao")
    @Mapping(target = "situacaoVoto", source = "request.voto")
    DadosValidacao toValidacao(VotoRequestDto request, Pauta pauta);
}
