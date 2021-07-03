package com.example.bibliotecawebflux.router;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.usecase.CasoUsoEliminarRecurso;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.DELETE;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;

@Configuration
public class EliminarRecursoRouter {

    @Bean
    public RouterFunction<ServerResponse> eliminarRecurso(CasoUsoEliminarRecurso casoUsoEliminarRecurso) {
        return RouterFunctions.route(DELETE("/eliminar/{id}").and(accept(MediaType.APPLICATION_JSON)),
                request ->
                        ServerResponse.ok()
                        .contentType(MediaType.APPLICATION_JSON)
                        .body(casoUsoEliminarRecurso.deleteById(request.pathVariable("id")), RecursoDTO.class));
    }


}
