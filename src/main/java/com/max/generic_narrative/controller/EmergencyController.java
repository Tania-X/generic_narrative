package com.max.generic_narrative.controller;

import com.max.generic_narrative.CustomApplicationRunner;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emergency")
public class EmergencyController {

  @Resource
  private CustomApplicationRunner applicationRunner;

  @GetMapping("/checkHealth")
  public int checkHealth() {
    return CustomApplicationRunner.RUNNING_STATUS;
  }

  @GetMapping("/preCheck")
  public int preCheck() {
    return applicationRunner.preCheck() ? 0 : 1;
  }

}
