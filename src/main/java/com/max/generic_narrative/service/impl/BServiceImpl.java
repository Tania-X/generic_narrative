package com.max.generic_narrative.service.impl;

import com.max.generic_narrative.bean.BServiceBean;
import com.max.generic_narrative.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("BServiceImpl")
@Slf4j
public class BServiceImpl extends AbstractService<BServiceBean> {

  @Override
  protected void doAfterService(BServiceBean serviceBean) {
    log.info("do B after service.");
    super.doAfterService(serviceBean);
  }

  @Override
  protected void doInternalService(BServiceBean serviceBean) {
    log.info("do B internal service");
    super.doInternalService(serviceBean);
  }

  @Override
  protected void doBeforeService(BServiceBean serviceBean) {
    log.info("do B before service");
    super.doBeforeService(serviceBean);
  }
}
