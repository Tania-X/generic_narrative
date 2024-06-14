package com.max.generic_narrative.controller;

import com.max.generic_narrative.bean.AServiceBean;
import com.max.generic_narrative.result.HttpResult;
import com.max.generic_narrative.service.impl.AServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/a2")
public class AController2 extends AbstractController2<AServiceImpl, AServiceBean> {

  @RequestMapping("/request")
  public HttpResult request(HttpServletRequest request) {
    return super.doController(request);
  }

  @Override
  protected AServiceBean buildServiceBean() {
    return AServiceBean.builder().build();
  }
}
