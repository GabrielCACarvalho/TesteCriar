package com.teste.criar.model;

import java.time.Duration;

public class ResultadoCorridaPiloto implements Comparable<ResultadoCorridaPiloto> {

    private String posicaoChegada;
    private String codigoPiloto;
    private String nomePiloto;
    private Integer qntVoltaCompletada;
    private Duration tempoTotalProva;
    private MelhorVoltaPiloto melhorVoltaPiloto;

    public MelhorVoltaPiloto getMelhorVolta() {
        return melhorVoltaPiloto;
    }

    public void setMelhorVolta(MelhorVoltaPiloto melhorVoltaPiloto) {
        this.melhorVoltaPiloto = melhorVoltaPiloto;
    }

    public String getPosicaoChegada() {
        return posicaoChegada;
    }

    public void setPosicaoChegada(String posicaoChegada) {
        this.posicaoChegada = posicaoChegada;
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

    public Integer getQntVoltaCompletada() {
        return qntVoltaCompletada;
    }

    public void setQntVoltaCompletada(Integer qntVoltaCompletada) {
        this.qntVoltaCompletada = qntVoltaCompletada;
    }

    public Duration getTempoTotalProva() {
        return tempoTotalProva;
    }

    public void setTempoTotalProva(Duration tempoTotalProva) {
        this.tempoTotalProva = tempoTotalProva;
    }

    @Override
    public int compareTo(ResultadoCorridaPiloto resultadoCorridaPiloto) {
        return getTempoTotalProva().compareTo(resultadoCorridaPiloto.getTempoTotalProva());
    }
}
