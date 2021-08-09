package com.teste.criar.converter;

import com.teste.criar.model.CorridaInfo;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CorridaInfoConverter  implements Converter<String, CorridaInfo>{
    @Override
    public List<CorridaInfo> from(String log) {
        List<CorridaInfo> corridaInfo = new ArrayList<>();

        return corridaInfo;
    }
}
