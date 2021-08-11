package com.teste.criar.model;

import java.util.List;

public class ResultadoCorrida {

    private MelhorVoltaCorrida melhorVoltaCorrida;
    private List<ResultadoCorridaPiloto> resultadoCorridaPilotos;

    public MelhorVoltaCorrida getMelhorVoltaCorrida() {
        return melhorVoltaCorrida;
    }

    public void setMelhorVoltaCorrida(MelhorVoltaCorrida melhorVoltaCorrida) {
        this.melhorVoltaCorrida = melhorVoltaCorrida;
    }

    public List<ResultadoCorridaPiloto> getResultadoCorridaPilotos() {
        return resultadoCorridaPilotos;
    }

    public void setResultadoCorridaPilotos(List<ResultadoCorridaPiloto> resultadoCorridaPilotos) {
        this.resultadoCorridaPilotos = resultadoCorridaPilotos;
    }
}
