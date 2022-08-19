package com.services;

import com.models.Donor;

import java.util.List;

public interface DonorService {

    public List<Donor> getAll();

    public List<Donor> getAllByBlood(String bloodType);

    public void save(Donor donor);

    public Donor get(int id);

    Donor getDonorEligibility(int userid);

    public void update(Donor donor);

    public void delete(int id);

}
