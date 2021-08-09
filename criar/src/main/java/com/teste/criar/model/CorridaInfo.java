package com.teste.criar.model;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;

public class CorridaInfo {

    private LocalTime hora;
    private String piloto;
    private String codigoPiloto;
    private Integer numeroVolta;
    private Duration tempoVolta;
    private BigDecimal velocidadeMediaVolta;

    public String getCodigoPiloto() {
        return codigoPiloto;
    }

    public void setCodigoPiloto(String codigoPiloto) {
        this.codigoPiloto = codigoPiloto;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public String getPiloto() {
        return piloto;
    }

    public void setPiloto(String piloto) {
        this.piloto = piloto;
    }

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

    public BigDecimal getVelocidadeMediaVolta() {
        return velocidadeMediaVolta;
    }

    public void setVelocidadeMediaVolta(BigDecimal velocidadeMediaVolta) {
        this.velocidadeMediaVolta = velocidadeMediaVolta;
    }
}
