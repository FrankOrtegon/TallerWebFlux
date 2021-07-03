package com.example.bibliotecawebflux.repositories;

import com.example.bibliotecawebflux.model.Recurso;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface RepositorioRecurso extends ReactiveMongoRepository<Recurso,String> {

}
