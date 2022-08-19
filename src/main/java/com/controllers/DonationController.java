package com.controllers;

import com.models.Donation;
import com.models.Donor;
import com.models.Post;
import com.services.DonationService;
import com.services.DonorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @RequestMapping(value = "/get-all-request/{donorId}", method = RequestMethod.GET)
    public List<Donation> getAllRequestByDonor(@PathVariable("donorId") int donorId) {
        return donationService.getAllByUser(donorId);
    }

    @RequestMapping(value = "/request-blood", method = RequestMethod.POST, consumes = {"application/json"})
    public ResponseEntity<Donation> requestBlood(@RequestBody Donation donation) {
        donationService.save(donation);
        return ResponseEntity.ok(donation);
    }

    @RequestMapping(value = "/delete-donation/{id}", method = RequestMethod.GET)
    public ResponseEntity deleteDonation(@PathVariable("id") int id) {
        donationService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}
