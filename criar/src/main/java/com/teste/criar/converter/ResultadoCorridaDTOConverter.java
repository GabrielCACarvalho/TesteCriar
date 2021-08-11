package com.teste.criar.converter;

import com.teste.criar.dto.ResultadoCorridaDTO;
import com.teste.criar.model.ResultadoCorrida;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ResultadoCorridaDTOConverter implements Converter<List<ResultadoCorrida>, List<ResultadoCorridaDTO>>{

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
        resultadoCorridaDTO.setTempoTotalProva(durationToString(resultadoCorrida.getTempoTotalProva()));

        return resultadoCorridaDTO;
    }

    private String durationToString(Duration tempoTotalProva){
        String tempo = tempoTotalProva.toString();

        tempo = tempo.replace("PT","");

        String minutos = "";
        String segundos = "";

        String[] tempoDividido = tempo.split("M|S");

        if(tempo.contains("M")){
            minutos = tempoDividido[0];
        }

        if (tempo.contains("S")){
            segundos = tempoDividido[1];
        }

        String tempoConvetido = minutos + ":" + segundos;

        return tempoConvetido;
    }
}
