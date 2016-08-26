package com.trusdom.fdip.scheduler;

import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.impl.matchers.GroupMatcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

/**
 * Created by ShenTeng on 2015/3/23.
 * 自动清理不存在的计划任务。不存在的原因是：<br>
 * 不需要再执行，配置文件中已经删除该计划任务的配置（对应的job类可能存在，也可能被删除）<br>
 * 注意：使用该Scheduler工厂时，设置job name必须为bean name。使用org.springframework.scheduling.quartz.SpringBeanJobFactory创建job时，默认的job name即为bean name。
 */
public class AutoCleanSchedulerFactoryBean extends SchedulerFactoryBean {

    private static final Logger LOGGER = LoggerFactory.getLogger(AutoCleanSchedulerFactoryBean.class);

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        super.afterPropertiesSet();
        Scheduler scheduler = getScheduler();
        for (String groupName : scheduler.getJobGroupNames()) {
            for (JobKey jobKey : scheduler.getJobKeys(GroupMatcher.jobGroupEquals(groupName))) {
                String name = jobKey.getName();
                String group = jobKey.getGroup();
                try {
                    applicationContext.getBean(name);
                } catch (NoSuchBeanDefinitionException e) {
                    LOGGER.info("try to delete job " + name + ". reason: not found bean " + name);

                    boolean result = scheduler.deleteJob(new JobKey(name, group));
                    if (!result) {
                        LOGGER.error("fail to delete job " + name + " in group" + group);
                    }
                }
            }

        }
    }
}
