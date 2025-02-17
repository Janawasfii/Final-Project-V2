package com.example.Thawaq.Repository;

import com.example.Thawaq.Model.Store;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends JpaRepository<Store,Integer> {

    Store findStoreById(Integer id);

    //List of stores by type if it's restaurant or cafe (Jana) v2
    List<Store> findStoreByTypeOfActivity(String typeOfActivity);
}
