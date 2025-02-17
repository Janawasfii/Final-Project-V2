package com.example.Thawaq.Repository;

import com.example.Thawaq.Model.Client;
import com.example.Thawaq.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findClientById(Integer id);
    List<Client> findClientByUser(User user);
}
