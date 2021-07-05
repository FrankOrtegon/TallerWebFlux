package com.example.bibliotecawebflux.mapper;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.dto.RespuestaDTO;
import com.example.bibliotecawebflux.model.Recurso;
import org.springframework.stereotype.Component;
import java.util.function.Function;

@Component
public class RespuestaMapper {
    public Function<RecursoDTO,RespuestaDTO> respuestaToRecurso(String id) {
     return null;
    }
}
