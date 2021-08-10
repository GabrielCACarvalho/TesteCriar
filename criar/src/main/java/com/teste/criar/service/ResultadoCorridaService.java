package com.teste.criar.service;

import com.teste.criar.converter.ResultadoCorridaConverter;
import com.teste.criar.model.CorridaInfo;
import com.teste.criar.model.ResultadoCorrida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoCorridaService {

    @Autowired
    private ResultadoCorridaConverter resultadoCorridaConverter;

    @Autowired
    private CorridaInfoService corridaInfoService;

    public List<ResultadoCorrida> getResultadosCorrida(){
        List<CorridaInfo> corridaInfoList = corridaInfoService.getCorridaInfo();

        return resultadoCorridaConverter.from(corridaInfoList);
    }
}
