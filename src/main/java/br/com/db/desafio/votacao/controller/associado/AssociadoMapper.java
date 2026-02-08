package br.com.db.desafio.votacao.controller.associado;

import br.com.db.desafio.votacao.model.associado.Associado;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface AssociadoMapper {

    @Mapping(target = "nome", source = "nome", qualifiedByName = "getNome")
    @Mapping(target = "status", constant = "ABLE_TO_VOTE")
    Associado mapToAssociado(AssociadoRequestDto associadoRequestDto);

    AssociadoResponseDto mapToAssociadoResponseDto(Associado associado);

    @Named("getNome")
    default String getNome(String nome) {

        if (nome != null && !nome.isEmpty()) {
            return nome;
        }

        return "Sem nome";
    }
}
