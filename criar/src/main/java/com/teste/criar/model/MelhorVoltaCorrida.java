package com.teste.criar.model;

import java.time.Duration;

public class MelhorVoltaCorrida {

    private Duration tempoMelhorVoltaCorrida;
    private Integer numeroVolta;
    private String codigoPiloto;
    private String nomePiloto;

    public Duration getTempoMelhorVoltaCorrida() {
        return tempoMelhorVoltaCorrida;
    }

    public void setTempoMelhorVoltaCorrida(Duration tempoMelhorVoltaCorrida) {
        this.tempoMelhorVoltaCorrida = tempoMelhorVoltaCorrida;
    }

    public Integer getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(Integer numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public String getCodigoPiloto() {
        return codigoPiloto;
    }

    public void setCodigoPiloto(String codigoPiloto) {
        this.codigoPiloto = codigoPiloto;
    }

    public String getNomePiloto() {
        return nomePiloto;
    }

    public void setNomePiloto(String nomePiloto) {
        this.nomePiloto = nomePiloto;
    }
}
