package com.sample.springbootimagensapialura.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.sample.springbootimagensapialura.dto.ImagemDTO;
import com.sample.springbootimagensapialura.model.Imagem;

@Mapper
public interface ImagemMapper {
    
    ImagemMapper INSTANCE = Mappers.getMapper(ImagemMapper.class);

    Imagem toModel(ImagemDTO imagemDTO);

    ImagemDTO toDto(Imagem imagem);
}
