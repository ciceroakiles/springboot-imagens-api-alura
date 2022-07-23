package com.sample.springbootimagensapialura.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.sample.springbootimagensapialura.model.Imagem;

public interface ImagemRepository extends MongoRepository<Imagem, String> {
    
}
