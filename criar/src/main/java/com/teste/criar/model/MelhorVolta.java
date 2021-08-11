package com.teste.criar.model;

import java.time.Duration;

public class MelhorVolta {

    private Integer numeroVolta;
    private Duration tempoVolta;

    public Integer getNumeroVolta() {
        return numeroVolta;
    }

    public void setNumeroVolta(Integer numeroVolta) {
        this.numeroVolta = numeroVolta;
    }

    public Duration getTempoVolta() {
        return tempoVolta;
    }

    public void setTempoVolta(Duration tempoVolta) {
        this.tempoVolta = tempoVolta;
    }
}
