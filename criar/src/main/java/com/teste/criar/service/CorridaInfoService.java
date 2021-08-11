package com.teste.criar.service;

import com.teste.criar.converter.model.CorridaInfoConverter;
import com.teste.criar.model.CorridaInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

@Service
public class CorridaInfoService {

    @Autowired
    private CorridaInfoConverter corridaInfoConverter;

    public List<CorridaInfo> getCorridaInfo(){
        return corridaInfoConverter.from(getLog());
    }

    private String getLog(){
        try {
            Scanner inputLog = new Scanner(new FileReader("/home/gabrielg/Área de Trabalho/testeCriar/logCorrida.txt"));

            StringBuilder stringBuilder = new StringBuilder();

            while(inputLog.hasNext()){
                stringBuilder.append(inputLog.next());
                stringBuilder.append(System.lineSeparator());
            }
            inputLog.close();

            return stringBuilder.toString();
        } catch (IOException e) {
            throw new RuntimeException("ERRO NA INTERPRETACAO DO ARQUIVO DE LOG" + e);
        }
    }
}
