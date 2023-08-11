package de.mstiehr.polar.catalogservice;

import de.mstiehr.polar.catalogservice.config.PolarProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

    @Autowired
    private PolarProperties polarProperties;

    @RequestMapping("/")
    public String getGreeting() {
        return polarProperties.getGreeting();
    }
}
