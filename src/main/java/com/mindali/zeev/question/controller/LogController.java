package com.mindali.zeev.question.controller;

import org.springframework.stereotype.Controller;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Arrays;
import java.util.List;

@Controller
public class LogController {
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    @GetMapping("/")
    public String Logger(Model model) {
        logger.debug("Logger data", logger);

        model.addAttribute("num", logger);

        return "index"; // index.html
    }

}
