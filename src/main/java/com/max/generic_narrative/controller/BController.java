package com.max.generic_narrative.controller;

import com.max.generic_narrative.bean.BServiceBean;
import com.max.generic_narrative.bean.IServiceBean;
import com.max.generic_narrative.result.HttpResult;
import com.max.generic_narrative.service.AbstractService;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/b")
public class BController extends AbstractController {

    @Resource(name = "BServiceImpl")
//  @Autowired
//  @Qualifier(value = "BServiceImpl")
  private AbstractService<? super IServiceBean> bService;

  @PostConstruct
  public void init() {
    super.abstractService = bService;
  }

  @RequestMapping("/request")
  public HttpResult request(HttpServletRequest request) {
    return super.doController(request);
  }

  @Override
  protected IServiceBean buildServiceBean() {
    return BServiceBean.builder().build();
  }
}
