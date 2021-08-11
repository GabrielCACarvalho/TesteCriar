package com.teste.criar.converter;

import com.teste.criar.dto.ResultadoCorridaDTO;
import com.teste.criar.model.ResultadoCorrida;
import com.teste.criar.utils.TesteCriarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultadoCorridaDTOConverter implements Converter<List<ResultadoCorrida>, List<ResultadoCorridaDTO>>{

    @Autowired
    private MelhorVoltaDTOConverter melhorVoltaDTOConverter;

    @Override
    public List<ResultadoCorridaDTO> from(List<ResultadoCorrida> resultadoCorridas) {
        return resultadoCorridas.stream().map(this::from).collect(Collectors.toList());
    }

    private ResultadoCorridaDTO from(ResultadoCorrida resultadoCorrida) {
        ResultadoCorridaDTO resultadoCorridaDTO = new ResultadoCorridaDTO();

        resultadoCorridaDTO.setNomePiloto(resultadoCorrida.getNomePiloto());
        resultadoCorridaDTO.setCodigoPiloto(resultadoCorrida.getCodigoPiloto());
        resultadoCorridaDTO.setPosicaoChegada(resultadoCorrida.getPosicaoChegada());
        resultadoCorridaDTO.setQntVoltaCompletada(resultadoCorrida.getQntVoltaCompletada());
        resultadoCorridaDTO.setTempoTotalProva(TesteCriarUtils.durationToString(resultadoCorrida.getTempoTotalProva()));
        resultadoCorridaDTO.setMelhorVoltaDTO(melhorVoltaDTOConverter.from(resultadoCorrida.getMelhorVolta()));

        return resultadoCorridaDTO;
    }
}
