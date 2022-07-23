package com.sample.springbootimagensapialura.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException.BadRequest;

import com.sample.springbootimagensapialura.dto.ImagemDTO;
import com.sample.springbootimagensapialura.model.Imagem;
import com.sample.springbootimagensapialura.service.ImagemService;

@RestController
public class ImagemController {
    
    @Autowired
    private ImagemService imagemService;

    @GetMapping("/imagens")
    public List<Imagem> getAllImagens() {
        return imagemService.listarImagens();
    }

    @PostMapping("/imagens")
    @ResponseStatus(HttpStatus.CREATED)
    public Imagem postImagem(@RequestBody ImagemDTO imagemDTO) throws BadRequest {
        return imagemService.postImagem(imagemDTO);
    }

    @GetMapping("/imagens/{id}")
    public Imagem getByID(@PathVariable String id) throws NotFoundException {
        return imagemService.getById(id);
    }

    @PutMapping("/imagens/{id}")
    public Imagem updateById(@PathVariable String id, @RequestBody ImagemDTO imagemDTO) throws NotFoundException {
        return imagemService.updateById(id, imagemDTO);
    }

    @DeleteMapping("/imagens/{id}")
    public void deleteById(@PathVariable String id) throws NotFoundException {
        imagemService.deleteById(id);
    }

    @GetMapping
    public String rootMsg() {
        return "Whoops! Aqui é a raiz. Tente outro caminho.";
    }
}
