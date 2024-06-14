package com.max.generic_narrative.controller;

import com.max.generic_narrative.bean.BServiceBean;
import com.max.generic_narrative.service.impl.BServiceImpl;

public class BController2 extends AbstractController2<BServiceImpl, BServiceBean> {

  @Override
  protected BServiceBean buildServiceBean() {
    return BServiceBean.builder().build();
  }
}
