package com.max.generic_narrative.controller;

import com.max.generic_narrative.mapper.TestTableMapper;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/table")
public class TestTableController {

  @Resource
  private TestTableMapper mapper;

  @GetMapping("/queryAll")
  public Object queryAll() {
    return mapper.selectAll();
  }

}
