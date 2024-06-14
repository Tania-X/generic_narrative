package com.max.generic_narrative.controller;

import com.max.generic_narrative.bean.BServiceBean;
import com.max.generic_narrative.result.HttpResult;
import com.max.generic_narrative.service.impl.BServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b2")
public class BController2 extends AbstractController2<BServiceImpl, BServiceBean> {

  @RequestMapping("/request")
  public HttpResult request(HttpServletRequest request) {
    return super.doController(request);
  }

  @Override
  protected BServiceBean buildServiceBean() {
    return BServiceBean.builder().build();
  }
}
