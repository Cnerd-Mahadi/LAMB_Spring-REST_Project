package com.services;

import com.models.Donation;

import java.util.List;

public interface DonationService {

    public List<Donation> getAllByUser(int userid);

    public void save(Donation donor);

    public Donation get(int id);

    public void update(Donation donor);

    public void delete(int id);

}
