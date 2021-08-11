package com.teste.criar.converter.dto;

import com.teste.criar.converter.Converter;
import com.teste.criar.dto.MelhorVoltaPilotoDTO;
import com.teste.criar.model.MelhorVoltaPiloto;
import com.teste.criar.utils.TesteCriarUtils;
import org.springframework.stereotype.Component;

@Component
public class MelhorVoltaPilotoDTOConverter implements Converter<MelhorVoltaPiloto, MelhorVoltaPilotoDTO> {
    @Override
    public MelhorVoltaPilotoDTO from(MelhorVoltaPiloto melhorVoltaPiloto) {
        MelhorVoltaPilotoDTO melhorVoltaPilotoDTO = new MelhorVoltaPilotoDTO();

        melhorVoltaPilotoDTO.setNumeroVolta(melhorVoltaPiloto.getNumeroVolta());
        melhorVoltaPilotoDTO.setTempoVolta(TesteCriarUtils.durationToString(melhorVoltaPiloto.getTempoVolta()));

        return melhorVoltaPilotoDTO;
    }
}
