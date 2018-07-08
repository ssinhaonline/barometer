package com.teebrow.barometer;

import com.teebrow.barometer.model.BarometerRequestModel;
import com.teebrow.barometer.scheduler.BarometerScheduler;
import com.google.gson.Gson;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author dsinha003c
 */

@RestController
public class AppController {

    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AppController.class);

    @RequestMapping(value = "/detectOutliers", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<?> detectOutliersApp(@RequestBody String body)  {
        try {
            BarometerRequestModel requestModel = new Gson().fromJson(body, BarometerRequestModel.class);
            BarometerScheduler scheduleTaskService = new BarometerScheduler();
            return scheduleTaskService.scheduleTask(requestModel);
        }catch (Exception e){
            log.error("Exception in start baseline collection task endpoint ", e);
            UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
            String path = builder.buildAndExpand().getPath();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(e.getMessage());
        }
    }
}
