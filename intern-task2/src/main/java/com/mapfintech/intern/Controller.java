package com.mapfintech.intern;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Logger;

@RestController
public class Controller {

    Logger logger = Logger.getLogger(Controller.class.getName());

    /**
     * GET key
     *
     * @param key
     * @return Hello + key!
     */

    @GetMapping("/hello-world/{key}")
    public String hello(@PathVariable String key) {

        String message = "Hello " + key + "!";
        logger.info(message);
        return "Hello " + key + "!";
    }

    /**
     * @return Hello World!
     */
    @GetMapping("/hello-world")
    public String helloworld() {

        return "Hello World!";
    }


}
