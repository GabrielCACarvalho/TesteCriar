package com.teste.criar.service;

import com.teste.criar.converter.ResultadoCorridaConverter;
import com.teste.criar.converter.ResultadoCorridaDTOConverter;
import com.teste.criar.dto.ResultadoCorridaDTO;
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
    private ResultadoCorridaDTOConverter resultadoCorridaDTOConverter;

    @Autowired
    private CorridaInfoService corridaInfoService;

    public List<ResultadoCorridaDTO> getResultadosCorrida(){
        List<CorridaInfo> corridaInfoList = corridaInfoService.getCorridaInfo();

        return resultadoCorridaDTOConverter.from(resultadoCorridaConverter.from(corridaInfoList));
    }
}
