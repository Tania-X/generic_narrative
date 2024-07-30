package com.max.generic_narrative;

import com.max.generic_narrative.mapper.TestTableMapper;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomApplicationRunner implements ApplicationRunner {

  @Resource
  private TestTableMapper mapper;

  private static final String STABLE_RUNNING = "0";

  public static volatile int RUNNING_STATUS = -1;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    String startMode = args.getSourceArgs().length > 0 ? args.getSourceArgs()[0] : null;
    log.info("startMode = {}", startMode);
    preCheck();
    if (STABLE_RUNNING.equals(startMode)) {
      log.info("stable start, running...");
    } else {
      // check
      if (RUNNING_STATUS == 0) {
        log.info("test running succeeds");
        System.exit(0);
      } else {
        log.error("test running fails");
        System.exit(1);
      }
    }
  }

  public int preCheck() {
    // do preCheck...
    boolean checkResult = true;
    try {
      mapper.selectAll();
    } catch (Throwable e) {
      log.error("fail to connect to mysql");
      checkResult = false;
    }
    if (!checkResult) {
      RUNNING_STATUS = 1;
    } else {
      RUNNING_STATUS = 0;
    }
    return RUNNING_STATUS;
  }

}
