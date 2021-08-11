package com.teste.criar.service;

import com.teste.criar.converter.model.ResultadoCorridaConverter;
import com.teste.criar.converter.model.ResultadoCorridaPilotoConverter;
import com.teste.criar.converter.dto.ResultadoCorridaDTOConverter;
import com.teste.criar.dto.ResultadoCorridaDTO;
import com.teste.criar.model.CorridaInfo;
import com.teste.criar.model.ResultadoCorrida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultadoCorridaService {

    @Autowired
    private ResultadoCorridaPilotoConverter resultadoCorridaPilotoConverter;

    @Autowired
    private ResultadoCorridaConverter resultadoCorridaConverter;

    @Autowired
    private ResultadoCorridaDTOConverter resultadoCorridaDTOConverter;

    @Autowired
    private CorridaInfoService corridaInfoService;

    public ResultadoCorridaDTO getResultadosCorrida(){
        List<CorridaInfo> corridaInfoList = corridaInfoService.getCorridaInfo();

        ResultadoCorrida resultadoCorrida = resultadoCorridaConverter.from(corridaInfoList);

        return resultadoCorridaDTOConverter.from(resultadoCorrida);
    }
}
