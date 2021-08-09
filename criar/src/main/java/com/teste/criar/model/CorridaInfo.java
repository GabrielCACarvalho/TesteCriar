package com.teste.criar.model;

import java.math.BigDecimal;

public class CorridaInfo {

    private String hora;
    private String piloto;
    private String codigoPiloto;
    private Integer numeroVolta;
    private String tempoVolta;
    private BigDecimal velocidadeMediaVolta;

    public String getCodigoPiloto() {
        return codigoPiloto;
    }

    public void setCodigoPiloto(String codigoPiloto) {
        this.codigoPiloto = codigoPiloto;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
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

    public String getTempoVolta() {
        return tempoVolta;
    }

    public void setTempoVolta(String tempoVolta) {
        this.tempoVolta = tempoVolta;
    }

    public BigDecimal getVelocidadeMediaVolta() {
        return velocidadeMediaVolta;
    }

    public void setVelocidadeMediaVolta(BigDecimal velocidadeMediaVolta) {
        this.velocidadeMediaVolta = velocidadeMediaVolta;
    }
}
