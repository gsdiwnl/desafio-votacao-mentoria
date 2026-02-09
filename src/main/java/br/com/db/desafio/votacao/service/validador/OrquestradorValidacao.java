package br.com.db.desafio.votacao.service.validador;

import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@RequiredArgsConstructor
public class OrquestradorValidacao {

    private final ApplicationContext context;

    public void executarValidacoes(DadosValidacao contexto, Collection<Class<? extends Validador>> validadores) {

        validadores.forEach(validadorClass -> {

            var validador = context.getBean(validadorClass);
            validador.validar(contexto);
        });
    }
}
