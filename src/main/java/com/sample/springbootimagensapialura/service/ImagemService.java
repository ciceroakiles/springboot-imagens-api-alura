package com.sample.springbootimagensapialura.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.sample.springbootimagensapialura.dto.ImagemDTO;
import com.sample.springbootimagensapialura.mapper.ImagemMapper;
import com.sample.springbootimagensapialura.model.Imagem;
import com.sample.springbootimagensapialura.repository.ImagemRepository;

@Service
public class ImagemService {

    private ImagemMapper imagemMapper = ImagemMapper.INSTANCE;

    private ImagemRepository imagemRepository;

    @Autowired
    public ImagemService(ImagemRepository imagemRepository) {
        this.imagemRepository = imagemRepository;
    }

    public List<Imagem> listarImagens() {
        return imagemRepository.findAll();
    }

    public Imagem postImagem(ImagemDTO imagemDTO) {
        Imagem imagem = imagemMapper.toModel(imagemDTO);
        imagemRepository.save(imagem);
        return imagem;
    }

    public Imagem getById(String id) throws ResponseStatusException {
        return buscarImagem(id);
    }

    public Imagem updateById(String id, ImagemDTO imagemDTO) throws ResponseStatusException {
        Imagem imagemSalva = buscarImagem(id);
        Imagem imagem = imagemMapper.toModel(imagemDTO);
        imagemSalva.setTitle(imagem.getTitle());
        imagemSalva.setImage(imagem.getImage());
        imagemRepository.save(imagemSalva);
        return imagemSalva;
    }

    public void deleteById(String id) throws ResponseStatusException {
        Imagem imagemBusca = buscarImagem(id);
        imagemRepository.delete(imagemBusca);
    }

    private Imagem buscarImagem(String id) throws ResponseStatusException {
        Optional<Imagem> imagemBusca = imagemRepository.findById(id);
        if (!imagemBusca.isEmpty()) {
            return imagemBusca.get();
        } else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Imagem nao encontrada (id=" + id + ")");
    }
}
