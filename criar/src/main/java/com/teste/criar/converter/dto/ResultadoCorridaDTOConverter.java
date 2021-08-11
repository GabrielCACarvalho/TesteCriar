package com.teste.criar.converter.dto;

import com.teste.criar.converter.Converter;
import com.teste.criar.dto.ResultadoCorridaDTO;
import com.teste.criar.model.ResultadoCorrida;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResultadoCorridaDTOConverter implements Converter<ResultadoCorrida, ResultadoCorridaDTO> {

    @Autowired
    private ResultadoCorridaPilotoDTOConverter resultadoCorridaPilotoDTOConverter;

    @Autowired
    private MelhorVoltaDTOConverter melhorVoltaDTOConverter;

    @Override
    public ResultadoCorridaDTO from(ResultadoCorrida resultadoCorrida) {
        ResultadoCorridaDTO resultadoCorridaDTO = new ResultadoCorridaDTO();

        resultadoCorridaDTO.setResultadoCorridaPilotosDTO(resultadoCorridaPilotoDTOConverter.from(resultadoCorrida.getResultadoCorridaPilotos()));
        resultadoCorridaDTO.setMelhorVoltaCorridaDTO(melhorVoltaDTOConverter.from(resultadoCorrida.getMelhorVoltaCorrida()));

        return resultadoCorridaDTO;
    }
}
