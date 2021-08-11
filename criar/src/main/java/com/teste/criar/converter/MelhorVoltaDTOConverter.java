package com.teste.criar.converter;

import com.teste.criar.dto.MelhorVoltaDTO;
import com.teste.criar.model.MelhorVolta;
import com.teste.criar.utils.TesteCriarUtils;
import org.springframework.stereotype.Component;

@Component
public class MelhorVoltaDTOConverter implements Converter<MelhorVolta, MelhorVoltaDTO>{
    @Override
    public MelhorVoltaDTO from(MelhorVolta melhorVolta) {
        MelhorVoltaDTO melhorVoltaDTO = new MelhorVoltaDTO();

        melhorVoltaDTO.setNumeroVolta(melhorVolta.getNumeroVolta());
        melhorVoltaDTO.setTempoVolta(TesteCriarUtils.durationToString(melhorVolta.getTempoVolta()));

        return melhorVoltaDTO;
    }
}
