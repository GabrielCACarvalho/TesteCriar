package com.teste.criar.dto;

import java.util.List;

public class ResultadoCorridaDTO {

    private MelhorVoltaCorridaDTO melhorVoltaCorridaDTO;
    private List<ResultadoCorridaPilotoDTO> resultadoCorridaPilotosDTO;

    public MelhorVoltaCorridaDTO getMelhorVoltaCorridaDTO() {
        return melhorVoltaCorridaDTO;
    }

    public void setMelhorVoltaCorridaDTO(MelhorVoltaCorridaDTO melhorVoltaCorridaDTO) {
        this.melhorVoltaCorridaDTO = melhorVoltaCorridaDTO;
    }

    public List<ResultadoCorridaPilotoDTO> getResultadoCorridaPilotosDTO() {
        return resultadoCorridaPilotosDTO;
    }

    public void setResultadoCorridaPilotosDTO(List<ResultadoCorridaPilotoDTO> resultadoCorridaPilotosDTO) {
        this.resultadoCorridaPilotosDTO = resultadoCorridaPilotosDTO;
    }
}
