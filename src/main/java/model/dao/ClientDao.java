

 package model.dao;

import java.util.List;

import model.dao.entities.Client;

public interface ClientDao {

    void insert(Client cliente);
    void update(Client cliente);
    void deleteById(Integer id);
    Client findById(Integer id);
    List<Client> findAll();
    int getSize();
}