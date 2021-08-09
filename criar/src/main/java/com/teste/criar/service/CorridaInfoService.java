package com.teste.criar.service;

import com.teste.criar.converter.Converter;
import com.teste.criar.converter.CorridaInfoConverter;
import com.teste.criar.model.CorridaInfo;

import java.util.List;

public class CorridaInfoService {

    private Converter<String, CorridaInfo> corridaInfoConverter = new CorridaInfoConverter();

    public List<CorridaInfo> getCorridaInfo(String log){
        return corridaInfoConverter.from(log);
    }

}
