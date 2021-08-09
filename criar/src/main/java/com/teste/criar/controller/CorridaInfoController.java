package com.teste.criar.controller;

import com.teste.criar.model.CorridaInfo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/")
public class CorridaInfoController {

    @GetMapping("/corridainfo")
    public List<CorridaInfo> getCorridaInfo(){



    }
}
