package com.max.generic_narrative.controller;

import com.max.generic_narrative.bean.AServiceBean;
import com.max.generic_narrative.service.impl.AServiceImpl;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AController2 extends AbstractController2<AServiceImpl, AServiceBean> {

  @Override
  protected AServiceBean buildServiceBean() {
    return AServiceBean.builder().build();
  }
}
