package com.max.generic_narrative.service;

import com.max.generic_narrative.bean.IServiceBean;

/**
 * the interface for all services
 */
public interface IService<T extends IServiceBean> {

  void doService(T serviceBean);

}
