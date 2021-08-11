package com.teste.criar.converter.model;

import com.teste.criar.converter.Converter;
import com.teste.criar.model.CorridaInfo;
import com.teste.criar.model.MelhorVoltaPiloto;
import com.teste.criar.model.ResultadoCorridaPiloto;
import com.teste.criar.utils.TesteCriarUtils;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ResultadoCorridaPilotoConverter implements Converter<List<CorridaInfo>, List<ResultadoCorridaPiloto>> {

    @Override
    public List<ResultadoCorridaPiloto> from(List<CorridaInfo> corridaInfos) {
        List<ResultadoCorridaPiloto> resultadosCorrida = getResultadosCorridaSemPosicao(corridaInfos);

        Collections.sort(resultadosCorrida);
        int cont = 0;
        for (ResultadoCorridaPiloto resultadoCorridaPiloto : resultadosCorrida){
            cont++;
            resultadoCorridaPiloto.setPosicaoChegada(cont + "º Lugar");
        }

        return resultadosCorrida;
    }

    private List<ResultadoCorridaPiloto> getResultadosCorridaSemPosicao(List<CorridaInfo> corridaInfos){
        List<ResultadoCorridaPiloto> resultadosCorridas = new ArrayList<>();

        List<String> todosCodigos = corridaInfos.stream()
                .map(CorridaInfo::getCodigoPiloto)
                .collect(Collectors.toList());

        for (String codigo: TesteCriarUtils.removeDuplicatas(todosCodigos)) {

            List<CorridaInfo> corridaInfoPilotoAtual = corridaInfos.stream()
                    .filter(corridaInfo -> codigo.equals(corridaInfo.getCodigoPiloto()))
                    .collect(Collectors.toList());

            ResultadoCorridaPiloto resultadoCorridaPiloto = new ResultadoCorridaPiloto();

            resultadoCorridaPiloto.setTempoTotalProva(getTempoTotalProva(corridaInfoPilotoAtual));
            resultadoCorridaPiloto.setCodigoPiloto(codigo);
            resultadoCorridaPiloto.setNomePiloto(corridaInfoPilotoAtual.get(0).getPiloto());
            resultadoCorridaPiloto.setQntVoltaCompletada(corridaInfoPilotoAtual.size());
            resultadoCorridaPiloto.setMelhorVolta(getMelhorVolta(corridaInfoPilotoAtual));

            resultadosCorridas.add(resultadoCorridaPiloto);
        }
        return resultadosCorridas;
    }

    private Duration getTempoTotalProva(List<CorridaInfo> corridaInfoPilotoAtual){
        ResultadoCorridaPiloto resultadoCorridaPiloto = new ResultadoCorridaPiloto();
        Duration tempoTotalAtual = Duration.ofMinutes(0);
        for (CorridaInfo corridaInfoAtual : corridaInfoPilotoAtual) {
            if(resultadoCorridaPiloto.getTempoTotalProva() != null)
                tempoTotalAtual = tempoTotalAtual.plus(resultadoCorridaPiloto.getTempoTotalProva().plus(corridaInfoAtual.getTempoVolta()));
            else
                tempoTotalAtual = tempoTotalAtual.plus(corridaInfoAtual.getTempoVolta());
        }
        return tempoTotalAtual;
    }

    private MelhorVoltaPiloto getMelhorVolta(List<CorridaInfo> corridaInfoPilotoAtual){
        MelhorVoltaPiloto melhorVoltaPiloto = new MelhorVoltaPiloto();

        melhorVoltaPiloto.setTempoVolta(Duration.ofMinutes(0));
            for (CorridaInfo corridaInfoComparada: corridaInfoPilotoAtual) {
                Duration tempoComparado = melhorVoltaPiloto.getTempoVolta().minus(corridaInfoComparada.getTempoVolta());

                if (melhorVoltaPiloto.getTempoVolta().isZero()) {
                    melhorVoltaPiloto.setTempoVolta(corridaInfoComparada.getTempoVolta());
                    melhorVoltaPiloto.setNumeroVolta(corridaInfoComparada.getNumeroVolta());
                } else if(!(tempoComparado.isNegative())){
                    melhorVoltaPiloto.setTempoVolta(corridaInfoComparada.getTempoVolta());
                    melhorVoltaPiloto.setNumeroVolta(corridaInfoComparada.getNumeroVolta());
                }
        }

        return melhorVoltaPiloto;
    }
}
