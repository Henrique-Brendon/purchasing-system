package model.dao;

import java.util.List;

import model.entities.Sector;

public interface SectorDao {
    void insert(Sector product);
    void update(Sector product);
    void deleteById(Integer id);
    Sector findById(Integer id);
    List<Sector> findAll();
}
