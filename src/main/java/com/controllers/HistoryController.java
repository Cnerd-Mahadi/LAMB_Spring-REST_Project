package com.controllers;

import com.models.Donation;
import com.models.History;
import com.services.DonationService;
import com.services.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend")
public class HistoryController {

    private final HistoryService historyService;

    public HistoryController(HistoryService historyService) {
        this.historyService = historyService;
    }

    @RequestMapping(value = "/get-visitor-history/{visitorId}", method = RequestMethod.GET)
    public List<History> getVisitorHistory(@PathVariable("visitorId") int visitorId) {
        return historyService.getVisitorHistory(visitorId);
    }

    @RequestMapping(value = "/get-donor-history/{donorId}", method = RequestMethod.GET)
    public List<History> getDonorHistory(@PathVariable("donorId") int donorId) {
        return historyService.getDonorHistory(donorId);
    }


}
