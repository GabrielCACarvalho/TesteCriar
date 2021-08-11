package com.teste.criar.dto;

public class MelhorVoltaCorridaDTO {

    private String tempoMelhorVoltaCorrida;
    private Integer numeroVolta;
    private String codigoPiloto;
    private String nomePiloto;

    public String getTempoMelhorVoltaCorrida() {
        return tempoMelhorVoltaCorrida;
    }

    public void setTempoMelhorVoltaCorrida(String tempoMelhorVoltaCorrida) {
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
