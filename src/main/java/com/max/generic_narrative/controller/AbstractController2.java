package com.max.generic_narrative.controller;

import com.max.generic_narrative.bean.IServiceBean;
import com.max.generic_narrative.result.HttpResult;
import com.max.generic_narrative.service.IService;
import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractController2<T extends IService<V>, V extends IServiceBean> implements
    IController {

  @Autowired
//  @Resource
  private T iService;

  @Override
  public HttpResult doController(HttpServletRequest request) {
    iService.doService(buildServiceBean());
    return new HttpResult("200", null, null);
  }

  protected abstract V buildServiceBean();

}
