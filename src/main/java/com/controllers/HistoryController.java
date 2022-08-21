package com.controllers;

import com.models.History;
import com.services.HistoryService;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend")
public class HistoryController {

    private final HistoryService historyService;
    private final UserController userController;

    public HistoryController(HistoryService historyService, UserController userController) {
        this.historyService = historyService;
        this.userController = userController;
    }

    @RequestMapping(value = "/get-visitor-history/", method = RequestMethod.GET)
    public List<History> getVisitorHistory(ServletRequest servletRequest) {
        return historyService.getVisitorHistory(userController.getUser(servletRequest).getUserId());
    }

    @RequestMapping(value = "/get-donor-history", method = RequestMethod.GET)
    public List<History> getDonorHistory(ServletRequest servletRequest) {
        return historyService.getVisitorHistory(userController.getUser(servletRequest).getUserId());
    }


}
