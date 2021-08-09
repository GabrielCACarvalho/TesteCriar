package com.teste.criar.converter;

import java.util.List;

public interface Converter <T, R>{
    List<R> from(T t);
}
