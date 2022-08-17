package com.daos;

import com.models.Visitor;

import java.util.List;

public interface VisitorDao {

    public List<Visitor> getAll();

    public void save(Visitor visitor);

    public Visitor get(int id);

    public void update(Visitor visitor);

    public void delete(int id);

}
