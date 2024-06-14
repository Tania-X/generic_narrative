package com.max.generic_narrative.service.impl;

import com.max.generic_narrative.bean.AServiceBean;
import com.max.generic_narrative.service.AbstractService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service("AServiceImpl")
@Slf4j
public class AServiceImpl extends AbstractService<AServiceBean> {

  @Override
  protected void doAfterService(AServiceBean serviceBean) {
    log.info("do A after service.");
    super.doAfterService(serviceBean);
  }

  @Override
  protected void doInternalService(AServiceBean serviceBean) {
    log.info("do A internal service");
    super.doInternalService(serviceBean);
  }

  @Override
  protected void doBeforeService(AServiceBean serviceBean) {
    log.info("do A before service");
    super.doBeforeService(serviceBean);
  }
}
