package com.controllers;

import com.models.Donor;
import com.models.Post;
import com.services.DonorService;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/backend")
public class DonorController {

    private final DonorService donorService;

    public DonorController(DonorService donorService) {
        this.donorService = donorService;
    }

    @RequestMapping(value = "/get-all-donor", method = RequestMethod.GET)
    public List<Donor> showAllDonor() {
        return donorService.getAll();
    }

    @RequestMapping(value = "/get-all-donor-blood/{type}", method = RequestMethod.GET)
    public List<Donor> showAllDonorByBlood(@PathVariable("type") String bloodType) {
        return donorService.getAllByBlood(bloodType);
    }





}
