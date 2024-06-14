package com.max.generic_narrative.service;

import com.max.generic_narrative.bean.IServiceBean;

public interface IService<T extends IServiceBean> {

  void doService(T serviceBean);

}
