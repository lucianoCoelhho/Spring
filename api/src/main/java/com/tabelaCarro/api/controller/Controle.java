package com.tabelaCarro.api.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tabelaCarro.api.models.Cliente;
import com.tabelaCarro.api.repository.Repositorio;

@RestController
@CrossOrigin(origins = "*")
public class Controle {

    @Autowired
    private Repositorio clienteRepository;

    @Autowired
    private Repositorio acao;

    @PostMapping("/")
    public Cliente cadastrar(@RequestBody Cliente c){
        return acao.save(c);
    }

    @GetMapping("/")
    public Iterable<Cliente> selecionar(){
        return acao.findAll();
    }
/*
  @PutMapping("/carros/{id}")
    public ResponseEntity<Cliente> editar(@PathVariable(value="id") Long id, @RequestBody @Valid Cliente clienteModels){
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);

        if (!clienteOptional.isPresent()) {
            // Retorne uma resposta de sucesso com o cliente editado
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            // Cliente não encontrado, retorne uma resposta de não encontrado
            clienteModels.setId(clienteOptional.get().getId());
            return new ResponseEntity<Cliente>(clienteRepository.save(clienteModels),HttpStatus.OK);
        }
    }
    */
    @PutMapping("/")
    public Cliente editar(@RequestBody Cliente c){
        return acao.save(c);
    }
    

    @DeleteMapping("/{id}")
    public void remover (@PathVariable long id){
        acao.deleteById(id);
    }
}