package com.auctus.jokenpo.controllers;

import com.auctus.jokenpo.models.Rodada;
import com.auctus.jokenpo.services.RodadaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rodada")
@Api(tags = "Rodada" )

public class RodadaController {

    @Autowired
    RodadaService rodadaService;

    @GetMapping("/{id}")
    @ApiOperation(value = "Retorna rodada pelo id")
    public ResponseEntity<?> findById(@PathVariable Long id) {

        return new ResponseEntity<>(rodadaService.findById(id), HttpStatus.OK);
    }


    @GetMapping("/")
    @ApiOperation(value = "Retorna lista com todos os rodadas")
    public ResponseEntity<?> listarRodadaes(){

        return new ResponseEntity<>(rodadaService.findAll(), HttpStatus.OK);
    }

    @PostMapping("/")
    @ApiOperation(value = "Salva um rodada")
    public ResponseEntity<?> adicionarRodada(Rodada rodada){

        return new ResponseEntity<>(rodadaService.save(rodada), HttpStatus.CREATED);
    }



}
