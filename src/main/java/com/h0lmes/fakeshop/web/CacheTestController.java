package com.h0lmes.fakeshop.web;

import com.h0lmes.fakeshop.service.CacheTestService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cache")
public class CacheTestController {

    CacheTestService testService;

    public CacheTestController(CacheTestService cacheTestService) {
        this.testService = cacheTestService;
    }

    // @ApiOperation(value = "Perform the long running task")
    @RequestMapping(value = "/{seconds}", method = RequestMethod.GET)
    public ResponseEntity<CacheTestService.TaskDTO> longRunningTask(@PathVariable long seconds) {
        CacheTestService.TaskDTO user = testService.getLongRunningTaskResult(seconds);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

}
