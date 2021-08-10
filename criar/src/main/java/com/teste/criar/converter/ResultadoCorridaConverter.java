package com.teste.criar.converter;

import com.teste.criar.model.CorridaInfo;
import com.teste.criar.model.ResultadoCorrida;
import com.teste.criar.utils.TesteCriarUtils;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.*;
import java.util.stream.Collectors;

@Component
public class ResultadoCorridaConverter implements Converter<List<CorridaInfo>, List<ResultadoCorrida>> {

    @Override
    public List<ResultadoCorrida> from(List<CorridaInfo> corridaInfos) {
        List<ResultadoCorrida> resultadosCorrida = getResultadosCorridaSemPosicao(corridaInfos);

        Collections.sort(resultadosCorrida);
        int cont = 0;
        for (ResultadoCorrida resultadoCorrida : resultadosCorrida){
            cont++;
            resultadoCorrida.setPosicaoChegada(cont + "º Lugar");
        }

        return resultadosCorrida;
    }

    private List<ResultadoCorrida> getResultadosCorridaSemPosicao(List<CorridaInfo> corridaInfos){
        List<ResultadoCorrida> resultadosCorridas = new ArrayList<>();

        List<String> todosCodigos = corridaInfos.stream()
                .map(CorridaInfo::getCodigoPiloto)
                .collect(Collectors.toList());

        for (String codigo: TesteCriarUtils.removeDuplicatas(todosCodigos)) {

            List<CorridaInfo> corridaInfoPilotoAtual = corridaInfos.stream()
                    .filter(corridaInfo -> codigo.equals(corridaInfo.getCodigoPiloto()))
                    .collect(Collectors.toList());

            ResultadoCorrida resultadoCorrida = new ResultadoCorrida();
            for (CorridaInfo corridaInfoAtual : corridaInfoPilotoAtual) {
                Duration tempoTotalAtual = Duration.ofMinutes(0);

                if(resultadoCorrida.getTempoTotalProva() != null)
                    tempoTotalAtual = tempoTotalAtual.plus(resultadoCorrida.getTempoTotalProva().plus(corridaInfoAtual.getTempoVolta()));
                else
                    tempoTotalAtual = tempoTotalAtual.plus(corridaInfoAtual.getTempoVolta());

                resultadoCorrida.setTempoTotalProva(tempoTotalAtual);
            }
            resultadoCorrida.setCodigoPiloto(codigo);
            resultadoCorrida.setNomePiloto(corridaInfoPilotoAtual.get(0).getPiloto());
            resultadoCorrida.setQntVoltaCompletada(corridaInfoPilotoAtual.size());

            resultadosCorridas.add(resultadoCorrida);
        }
        return resultadosCorridas;
    }
}
