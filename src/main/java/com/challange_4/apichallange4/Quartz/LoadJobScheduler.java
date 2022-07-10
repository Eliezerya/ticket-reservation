package com.challange_4.apichallange4.Quartz;

import com.challange_4.apichallange4.Service.FilmService;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class LoadJobScheduler extends QuartzJobBean {
    FilmService filmService;
    @Override
    protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
        filmService.films_display();
    }
}
