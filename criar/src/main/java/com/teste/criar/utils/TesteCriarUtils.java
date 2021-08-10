package com.teste.criar.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TesteCriarUtils {

    public static <T> List<T> removeDuplicatas(List<T> list){
        List<T> novaLista = new ArrayList<>();

        for (T item: list) {
            if (!novaLista.contains(item))
                novaLista.add(item);
        }

        return novaLista;
    }

    public static Duration stringToDuration(String tempo){
        String[] tempoDividido = tempo.replace(".", ":").split(":");
        Duration duration = Duration.ofMinutes(Integer.valueOf(tempoDividido[0]));
        duration = duration.plusSeconds(Integer.valueOf(tempoDividido[1]));
        duration = duration.plusMillis(Integer.valueOf(tempoDividido[2]));

        return duration;
    }

    public static List<String> stringToList(String string){
        return Arrays.stream(string.trim().split("\n"))
                .collect(Collectors.toList());
    }
}
