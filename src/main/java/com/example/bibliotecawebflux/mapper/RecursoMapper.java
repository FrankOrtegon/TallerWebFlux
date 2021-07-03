package com.example.bibliotecawebflux.mapper;

import com.example.bibliotecawebflux.dto.RecursoDTO;
import com.example.bibliotecawebflux.model.Recurso;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class RecursoMapper {

    public Function<RecursoDTO, Recurso> dtoToRecurso(String id) {
        return updateDato -> {
            var recurso = new Recurso();
            recurso.setId(id);
            recurso.setNombreRecurso(updateDato.getNombreRecurso());
            recurso.setDisponible(updateDato.getDisponible());
            recurso.setTipoRecursoId(updateDato.getTipoRecursoId());
            recurso.setCategoriaId(updateDato.getCategoriaId());
            recurso.setFecha(updateDato.getFecha());
            return recurso;
        };
    }

    public Function<Recurso, RecursoDTO> RecursoToDTO() {
        return entity -> new RecursoDTO(entity.getId(),entity.getFecha(),entity.getDisponible(), entity.getNombreRecurso(),  entity.getTipoRecursoId(), entity.getCategoriaId());
    }
}
