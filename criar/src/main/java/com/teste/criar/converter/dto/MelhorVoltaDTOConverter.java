package com.teste.criar.converter.dto;

import com.teste.criar.converter.Converter;
import com.teste.criar.dto.MelhorVoltaCorridaDTO;
import com.teste.criar.model.MelhorVoltaCorrida;
import com.teste.criar.utils.TesteCriarUtils;
import org.springframework.stereotype.Component;

@Component
public class MelhorVoltaDTOConverter implements Converter<MelhorVoltaCorrida, MelhorVoltaCorridaDTO> {

    @Override
    public MelhorVoltaCorridaDTO from(MelhorVoltaCorrida melhorVoltaCorrida) {
        MelhorVoltaCorridaDTO melhorVoltaCorridaDTO = new MelhorVoltaCorridaDTO();

        melhorVoltaCorridaDTO.setNumeroVolta(melhorVoltaCorrida.getNumeroVolta());
        melhorVoltaCorridaDTO.setCodigoPiloto(melhorVoltaCorrida.getCodigoPiloto());
        melhorVoltaCorridaDTO.setNomePiloto(melhorVoltaCorrida.getNomePiloto());
        melhorVoltaCorridaDTO.setTempoMelhorVoltaCorrida(TesteCriarUtils.durationToString(melhorVoltaCorrida.getTempoMelhorVoltaCorrida()));

        return melhorVoltaCorridaDTO;
    }
}
