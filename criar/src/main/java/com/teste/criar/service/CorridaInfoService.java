package com.teste.criar.service;

import com.teste.criar.converter.CorridaInfoConverter;
import com.teste.criar.model.CorridaInfo;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
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
            Scanner input = new Scanner(new FileReader("/home/gabrielg/Área de Trabalho/testeCriar/logCorrida.txt"));

            StringBuilder sb = new StringBuilder();

            while(input.hasNext()){
                sb.append(input.next());
                sb.append(System.lineSeparator());
            }
            input.close();

            return sb.toString();
        } catch (IOException e) {
            throw new RuntimeException("ERRO NA INTERPRETACAO DO ARQUIVO DE LOG" + e);
        }
    }
}
