package com.teste.criar.controller;

import com.teste.criar.model.CorridaInfo;
import com.teste.criar.model.ResultadoCorrida;
import com.teste.criar.service.CorridaInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/")
public class CorridaInfoController {

    @Autowired
    private CorridaInfoService corridaInfoService;

    @GetMapping("corridainfo")
    public List<CorridaInfo> getCorridaInfo(){
        return corridaInfoService.getCorridaInfo();
    }

    @GetMapping("resultadoCorrida")
    public List<ResultadoCorrida> getResultadosCorrida(){
        return corridaInfoService.getResultadoCorrida();
    }
}
