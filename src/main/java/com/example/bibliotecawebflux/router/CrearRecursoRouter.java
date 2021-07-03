package com.example.bibliotecawebflux.router;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.usecase.CasoUsoCrearRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.POST;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class CrearRecursoRouter {

        @Bean
        public RouterFunction<ServerResponse> createRecurso(CasoUsoCrearRecurso casoUsoCrearRecurso) {
            return route(POST("/crear").and(accept(MediaType.APPLICATION_JSON)),
                    request -> request.bodyToMono(RecursoDTO.class)
                            .flatMap(questionDTO -> casoUsoCrearRecurso.apply(questionDTO)
                                    .flatMap(result -> ServerResponse.ok()
                                            .contentType(MediaType.TEXT_PLAIN)
                                            .bodyValue(result))
                            )
            );
        }
    }

