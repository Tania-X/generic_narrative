package com.max.generic_narrative;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class CustomApplicationRunner implements ApplicationRunner {

  private static final String STABLE_RUNNING = "0";

  public static volatile int RUNNING_STATUS = -1;

  @Override
  public void run(ApplicationArguments args) throws Exception {
    String startMode = args.getSourceArgs().length > 0 ? args.getSourceArgs()[0] : null;
    log.info("startMode = {}", startMode);
    if (STABLE_RUNNING.equals(startMode)) {
      log.info("stable start, running...");
    } else {
      // check
      boolean checkResult = preCheck();
      if (true) {
        RUNNING_STATUS = 0;
        System.exit(0);
      } else {
        log.error("start for testing, exiting...");
        System.exit(1);
      }
    }
  }

  public boolean preCheck() {
    // do preCheck...
    boolean checkResult = false;
    if (checkResult) {
      RUNNING_STATUS = 1;
    } else {
      RUNNING_STATUS = 0;
    }
    return checkResult;
  }

}
