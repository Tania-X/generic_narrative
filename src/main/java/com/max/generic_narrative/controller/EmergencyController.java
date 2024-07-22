package com.max.generic_narrative.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emergency")
public class EmergencyController {

  @GetMapping("/checkHealth")
  public String checkHealth() {
    return "0";
  }

}
