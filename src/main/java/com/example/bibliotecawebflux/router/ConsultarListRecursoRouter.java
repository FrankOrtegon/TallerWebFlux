package com.example.bibliotecawebflux.router;


import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.usecase.CasoUsoConsultarListRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class ConsultarListRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> consultarListRecurso(CasoUsoConsultarListRecurso casoUsoConsultarListRecurso) {
        return route(GET("/consultar").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromPublisher(casoUsoConsultarListRecurso.get(), RecursoDTO.class))
        );
    }
}
