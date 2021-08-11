package com.teste.criar.converter.dto;

import com.teste.criar.converter.Converter;
import com.teste.criar.dto.ResultadoCorridaPilotoDTO;
import com.teste.criar.model.ResultadoCorridaPiloto;
import com.teste.criar.utils.TesteCriarUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultadoCorridaPilotoDTOConverter implements Converter<List<ResultadoCorridaPiloto>, List<ResultadoCorridaPilotoDTO>> {

    @Autowired
    private MelhorVoltaPilotoDTOConverter melhorVoltaPilotoDTOConverter;

    @Override
    public List<ResultadoCorridaPilotoDTO> from(List<ResultadoCorridaPiloto> resultadoCorridaPilotos) {
        return resultadoCorridaPilotos.stream().map(this::from).collect(Collectors.toList());
    }

    private ResultadoCorridaPilotoDTO from(ResultadoCorridaPiloto resultadoCorridaPiloto) {
        ResultadoCorridaPilotoDTO resultadoCorridaPilotoDTO = new ResultadoCorridaPilotoDTO();

        resultadoCorridaPilotoDTO.setNomePiloto(resultadoCorridaPiloto.getNomePiloto());
        resultadoCorridaPilotoDTO.setCodigoPiloto(resultadoCorridaPiloto.getCodigoPiloto());
        resultadoCorridaPilotoDTO.setPosicaoChegada(resultadoCorridaPiloto.getPosicaoChegada());
        resultadoCorridaPilotoDTO.setQntVoltaCompletada(resultadoCorridaPiloto.getQntVoltaCompletada());
        resultadoCorridaPilotoDTO.setTempoTotalProva(TesteCriarUtils.durationToString(resultadoCorridaPiloto.getTempoTotalProva()));
        resultadoCorridaPilotoDTO.setMelhorVoltaPilotoDTO(melhorVoltaPilotoDTOConverter.from(resultadoCorridaPiloto.getMelhorVolta()));

        return resultadoCorridaPilotoDTO;
    }
}
