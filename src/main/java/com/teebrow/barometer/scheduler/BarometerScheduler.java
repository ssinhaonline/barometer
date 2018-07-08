package com.teebrow.barometer.scheduler;

import com.teebrow.barometer.barometer.BarometerOperations;
import com.teebrow.barometer.model.BarometerRequestModel;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;
import org.springframework.web.util.UriComponentsBuilder;

/**
 * @author dsinha003c
 */
public class BarometerScheduler {


    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BarometerScheduler.class);

    public ResponseEntity<?> scheduleTask(BarometerRequestModel requestModel) {

        try {

            BarometerOperations barometerOperations = new BarometerOperations();
            String response = barometerOperations.detectOutliers(requestModel);
            if (response == null) {
                UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
                String path = builder.buildAndExpand().getPath();
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                        .body("Received null response from /detectOutliers");
            }

            UriComponentsBuilder builder = ServletUriComponentsBuilder.fromCurrentRequest();
            String path = builder.buildAndExpand().getPath();
            return ResponseEntity.status(HttpStatus.OK)
                    .body(response);
        } catch (Exception e) {
            throw e;
        }
    }
}
