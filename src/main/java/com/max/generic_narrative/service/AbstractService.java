package com.max.generic_narrative.service;

import com.max.generic_narrative.bean.IServiceBean;

public abstract class AbstractService<T extends IServiceBean> implements IService<T> {

  @Override
  public void doService(T serviceBean) {
    doBeforeService(serviceBean);

    doInternalService(serviceBean);

    doAfterService(serviceBean);
  }

  protected void doAfterService(T serviceBean) {

  }

  protected void doInternalService(T serviceBean) {

  }

  protected void doBeforeService(T serviceBean) {

  }

}
