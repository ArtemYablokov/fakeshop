package com.h0lmes.fakeshop.service;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

@Component
public class CacheTestService {

    @Cacheable(value = "getLongRunningTaskResult", key="{#seconds}", cacheManager = "cacheManager1Hour")
    public TaskDTO getLongRunningTaskResult(long seconds) {
        try {
            TaskDTO taskDTO = new TaskDTO();
            taskDTO.setCalculatedResult(seconds);
            Thread.sleep(2000);

            return taskDTO;
        } catch (InterruptedException e) {
            return null;
        }
    }

    public static class TaskDTO {

        private long calculatedResult;

        public long getCalculatedResult() {
            return calculatedResult;
        }

        public void setCalculatedResult(long calculatedResult) {
            this.calculatedResult = calculatedResult;
        }
    }
}
