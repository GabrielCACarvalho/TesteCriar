package com.teste.criar.converter;

public interface Converter <T, R>{
    R from(T t);
}
