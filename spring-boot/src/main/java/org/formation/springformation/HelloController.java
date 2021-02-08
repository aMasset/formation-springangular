package org.formation.springformation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloController.class);
    private final HelloProperties props;

    @Value("${hasard}")
    private String uuid;

    public HelloController(HelloProperties props) {
        this.props = props;
    }

    @RequestMapping("/hello")
    public String hello(@RequestParam String name) {
        return props.getGreeting() + name;
    }

    @RequestMapping("/hasard")
    public String hello() {
        return uuid;
    }
}