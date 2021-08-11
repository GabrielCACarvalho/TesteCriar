package com.teste.criar.model;

import java.time.Duration;

public class ResultadoCorrida  implements Comparable<ResultadoCorrida> {

    private String posicaoChegada;
    private String codigoPiloto;
    private String nomePiloto;
    private Integer qntVoltaCompletada;
    private Duration tempoTotalProva;
    private MelhorVolta melhorVolta;

    public MelhorVolta getMelhorVolta() {
        return melhorVolta;
    }

    public void setMelhorVolta(MelhorVolta melhorVolta) {
        this.melhorVolta = melhorVolta;
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
    public int compareTo(ResultadoCorrida resultadoCorrida) {
        return getTempoTotalProva().compareTo(resultadoCorrida.getTempoTotalProva());
    }
}
