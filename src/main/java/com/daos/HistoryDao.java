package com.daos;

import com.models.History;

import java.util.List;

public interface HistoryDao {

    public List<History> getVisitorHistory(int userid);

    public List<History> getDonorHistory(int userid);

    public void save(History history);

    public History get(int id);

    public void update(History history);

    public void delete(int id);

}
