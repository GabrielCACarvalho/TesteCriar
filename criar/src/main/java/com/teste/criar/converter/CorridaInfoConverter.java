package com.teste.criar.converter;

import com.teste.criar.model.CorridaInfo;
import com.teste.criar.utils.TesteCriarUtils;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CorridaInfoConverter  implements Converter<String, List<CorridaInfo>>{
    @Override
    public List<CorridaInfo> from(String log) {
        List<CorridaInfo> corridaInfoList = new ArrayList<>();

        String[] list = log.split("Hora|Piloto|Nº\nVolta|Tempo\nVolta|Velocidade\nmédia\nda\nvolta");

        List<String> horas = TesteCriarUtils.stringToList(list[1]);
        List<String> codigosPilotos = convertCodigoPiloto(list[2]);
        List<String> pilotos = convertPilotos(list[2]);
        List<String> numeroVolta = TesteCriarUtils.stringToList(list[3]);
        List<String> tempoVolta = TesteCriarUtils.stringToList(list[4]);
        List<String> velocidadeMediaVolta = TesteCriarUtils.stringToList(list[5]);

        for (int i = 0; i < horas.size(); i++) {
            CorridaInfo corridaInfo = new CorridaInfo();

            corridaInfo.setHora(LocalTime.parse(horas.get(i)));
            corridaInfo.setCodigoPiloto(codigosPilotos.get(i));
            corridaInfo.setPiloto(pilotos.get(i));
            corridaInfo.setNumeroVolta(Integer.valueOf(numeroVolta.get(i)));
            corridaInfo.setTempoVolta(TesteCriarUtils.stringToDuration(tempoVolta.get(i)));
            corridaInfo.setVelocidadeMediaVolta(new BigDecimal(velocidadeMediaVolta.get(i).replace(",",".")));

            corridaInfoList.add(corridaInfo);
        }

        return corridaInfoList;
    }

    private List<String> convertCodigoPiloto(String pilotos){
        String[] listaSeparada = separarPorHifen(pilotos);

        return Arrays.stream(listaSeparada[0].trim().split("\n")).collect(Collectors.toList());
    }

    private List<String> convertPilotos(String pilotos) {
        String[] listaSeparada = pilotos.split("\n–\n");

        return Arrays.stream(listaSeparada[12].trim().split("\n")).collect(Collectors.toList());
    }

    private String[] separarPorHifen(String pilotos){
        return pilotos.split("\n–\n");
    }
}
