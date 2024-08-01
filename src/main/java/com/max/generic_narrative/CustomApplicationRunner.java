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

  /**
   * 由于本类由@Component注解，被Spring容器管理，因此RUNNING_STATUS全局总是独一份的，跟是否为static无关
   * 可以将static去掉，外部访问它时使用实例点访问。
   * volatile变量RUNNIN_STATUS是直接放入JMM所定义的主内存的，所有工作线程直接访问主存来读取或修改该值，
   * 该值被修改后也会通过缓存一致性协议“同步”给访问该值的工作线程
   * 如果该值仅被CustomApplicationRunner#preCheck方法修改且被Emergency#checkHealth方法查看，
   * 那么并不会触发并发问题
   * 但由于Emergency#preCheck方法和CustomApplicationRunner#preCheck方法都会修改RUNNING_STATUS，
   * 因此仅依赖于volatile是无法保证线程安全的
   * 可以使用synchronized方法来修改RUNNING_STATUS，或者将RUNNING_STATUS改为AtomicInteger类型并
   * 通过原子类赋值操作来操作它。
   */
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
