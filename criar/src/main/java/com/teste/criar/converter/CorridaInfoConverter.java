package com.teste.criar.converter;

import com.teste.criar.model.CorridaInfo;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.time.Duration;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CorridaInfoConverter  implements Converter<String, CorridaInfo>{
    @Override
    public List<CorridaInfo> from(String log) {
        List<CorridaInfo> corridaInfoList = new ArrayList<>();

        String[] list = log.split("Hora|Piloto|Nº\nVolta|Tempo\nVolta|Velocidade\nmédia\nda\nvolta");

        List<String> horas = stringToList(list[1]);
        List<String> codigosPilotos = convertCodigoPiloto(list[2]);
        List<String> pilotos = convertPilotos(list[2]);
        List<String> numeroVolta = stringToList(list[3]);
        List<String> tempoVolta = stringToList(list[4]);
        List<String> velocidadeMediaVolta = stringToList(list[5]);

        for (int i = 0; i < horas.size(); i++) {
            CorridaInfo corridaInfo = new CorridaInfo();

            corridaInfo.setHora(LocalTime.parse(horas.get(i)));
            corridaInfo.setCodigoPiloto(codigosPilotos.get(i));
            corridaInfo.setPiloto(pilotos.get(i));
            corridaInfo.setNumeroVolta(Integer.valueOf(numeroVolta.get(i)));
            corridaInfo.setTempoVolta(stringToDuration(tempoVolta.get(i)));
            corridaInfo.setVelocidadeMediaVolta(new BigDecimal(velocidadeMediaVolta.get(1).replace(",",".")));

            corridaInfoList.add(corridaInfo);
        }

        return corridaInfoList;
    }

    private List<String> convertCodigoPiloto(String pilotos){
        String[] listaSemHifem = pilotos.split("\n–\n");

        return Arrays.stream(listaSemHifem[0].trim().split("\n")).collect(Collectors.toList());
    }

    private List<String> convertPilotos(String pilotos) {
        String[] listaSemHifem = pilotos.split("\n–\n");

        return Arrays.stream(listaSemHifem[12].trim().split("\n")).collect(Collectors.toList());
    }

    private List<String> stringToList(String string){
        return Arrays.stream(string.trim().split("\n"))
                .collect(Collectors.toList());
    }

    private Duration stringToDuration(String tempo){
        String[] tempoDividido = tempo.replace(".", ":").split(":");
        Duration duration = Duration.ofMinutes(Integer.valueOf(tempoDividido[0]));
        duration = duration.plusSeconds(Integer.valueOf(tempoDividido[1]));
        duration = duration.plusMillis(Integer.valueOf(tempoDividido[2]));

        return duration;
    }
}
