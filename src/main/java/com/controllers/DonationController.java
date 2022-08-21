package com.controllers;

import com.models.Donation;
import com.models.History;
import com.services.DonationService;
import com.services.HistoryService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend")
public class DonationController {

    private final DonationService donationService;
    private final HistoryService historyService;
    private final UserController userController;

    public DonationController(DonationService donationService, HistoryService historyService, UserController userController) {
        this.donationService = donationService;
        this.historyService = historyService;
        this.userController = userController;
    }

    @RequestMapping(value = "/get-all-request", method = RequestMethod.GET)
    public List<Donation> getAllRequestByDonor(ServletRequest servletRequest) {
        return donationService.getAllByUser(userController.getUser(servletRequest).getUserId());
    }

    @RequestMapping(value = "/request-blood", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Donation> requestBlood(@RequestBody Donation donation) {
        donationService.save(donation);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        History history = new History();
        history.setDonorId(donation.getDonorId());
        history.setRequestId(donation.getRequestId());
        history.setAction("REQUESTED");
        history.setBloodType(donation.getBloodType());
        history.setTime(dtf.format(now));
        historyService.save(history);
        return ResponseEntity.ok(donation);
    }

    @RequestMapping(value = "/donate-blood/{id}", method = RequestMethod.GET)
    public ResponseEntity donateBlood(@PathVariable("id") int id) {
        Donation donation = donationService.get(id);
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        History history = new History();
        history.setDonorId(donation.getDonorId());
        history.setRequestId(donation.getRequestId());
        history.setBloodType(donation.getBloodType());
        history.setAction("DONATED");
        history.setTime(dtf.format(now));

        donationService.delete(id);
        historyService.save(history);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
