package com.teste.criar.converter.model;

import com.teste.criar.converter.Converter;
import com.teste.criar.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.List;

@Component
public class ResultadoCorridaConverter implements Converter<List<CorridaInfo>, ResultadoCorrida> {

    @Autowired
    private ResultadoCorridaPilotoConverter resultadoCorridaPilotoConverter;

    @Override
    public ResultadoCorrida from(List<CorridaInfo> corridaInfoList) {
        ResultadoCorrida resultadoCorrida = new ResultadoCorrida();

        List<ResultadoCorridaPiloto> resultadoCorridaPilotos = resultadoCorridaPilotoConverter.from(corridaInfoList);

        resultadoCorrida.setResultadoCorridaPilotos(resultadoCorridaPilotos);
        resultadoCorrida.setMelhorVoltaCorrida(getMelhorVoltaCorridaFromResultadoCorridaPilotos(resultadoCorridaPilotos));//TODO: Resolver

        return resultadoCorrida;
    }

    private MelhorVoltaCorrida getMelhorVoltaCorridaFromResultadoCorridaPilotos(List<ResultadoCorridaPiloto> resultadoCorridaPilotos){
        MelhorVoltaCorrida melhorVoltaCorrida = new MelhorVoltaCorrida();

        melhorVoltaCorrida.setTempoMelhorVoltaCorrida(Duration.ofMinutes(0));
        for (ResultadoCorridaPiloto resultadoCorridaPiloto : resultadoCorridaPilotos) {
            Duration tempoComparado = melhorVoltaCorrida.getTempoMelhorVoltaCorrida()
                    .minus(resultadoCorridaPiloto.getMelhorVolta()
                            .getTempoVolta());

            if (melhorVoltaCorrida.getTempoMelhorVoltaCorrida().isZero()){
                melhorVoltaCorrida.setTempoMelhorVoltaCorrida(resultadoCorridaPiloto.getMelhorVolta().getTempoVolta());
                melhorVoltaCorrida.setCodigoPiloto(resultadoCorridaPiloto.getCodigoPiloto());
                melhorVoltaCorrida.setNomePiloto(resultadoCorridaPiloto.getNomePiloto());
                melhorVoltaCorrida.setNumeroVolta(resultadoCorridaPiloto.getMelhorVolta().getNumeroVolta());
            } else if (!(tempoComparado.isNegative())){
                melhorVoltaCorrida.setNumeroVolta(resultadoCorridaPiloto.getMelhorVolta().getNumeroVolta());
                melhorVoltaCorrida.setTempoMelhorVoltaCorrida(resultadoCorridaPiloto.getMelhorVolta().getTempoVolta());
                melhorVoltaCorrida.setNomePiloto(resultadoCorridaPiloto.getNomePiloto());
                melhorVoltaCorrida.setCodigoPiloto(resultadoCorridaPiloto.getCodigoPiloto());
            }
        }

        return melhorVoltaCorrida;
    }
}
