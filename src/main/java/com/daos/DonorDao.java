package com.daos;

import com.models.Donor;

import java.util.List;

public interface DonorDao {

    public List<Donor> getAll();

    public void save(Donor donor);

    public Donor get(int id);

    public void update(Donor donor);

    public void delete(int id);

}
