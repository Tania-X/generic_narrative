package com.max.generic_narrative.controller;

import com.max.generic_narrative.bean.IServiceBean;
import com.max.generic_narrative.result.HttpResult;
import com.max.generic_narrative.service.AbstractService;
import jakarta.servlet.http.HttpServletRequest;

public abstract class AbstractController implements IController {

  protected AbstractService<? super IServiceBean> abstractService;

  @Override
  public HttpResult doController(HttpServletRequest request) {
    abstractService.doService(buildServiceBean());
    return new HttpResult("200", null, null);
  }

  protected abstract IServiceBean buildServiceBean();

}
