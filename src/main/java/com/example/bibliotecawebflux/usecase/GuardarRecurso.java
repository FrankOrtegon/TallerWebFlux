package com.example.bibliotecawebflux.usecase;
import com.example.bibliotecawebflux.dto.RecursoDTO;
import reactor.core.publisher.Mono;

@FunctionalInterface
public interface GuardarRecurso {
    public Mono<String> apply(RecursoDTO recursoDTO);
}
