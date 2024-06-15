package com.max.generic_narrative.controller;

import com.max.generic_narrative.result.HttpResult;
import jakarta.servlet.http.HttpServletRequest;

/**
 * the interface for all controllers
 */
public interface IController {

  HttpResult doController(HttpServletRequest request);

}
