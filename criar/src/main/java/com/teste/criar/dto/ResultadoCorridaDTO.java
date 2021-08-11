package com.teste.criar.dto;

public class ResultadoCorridaDTO {

    private String posicaoChegada;
    private String codigoPiloto;
    private String nomePiloto;
    private Integer qntVoltaCompletada;
    private String tempoTotalProva;
    private MelhorVoltaDTO melhorVoltaDTO;

    public MelhorVoltaDTO getMelhorVoltaDTO() {
        return melhorVoltaDTO;
    }

    public void setMelhorVoltaDTO(MelhorVoltaDTO melhorVoltaDTO) {
        this.melhorVoltaDTO = melhorVoltaDTO;
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

    public String getTempoTotalProva() {
        return tempoTotalProva;
    }

    public void setTempoTotalProva(String tempoTotalProva) {
        this.tempoTotalProva = tempoTotalProva;
    }
}
