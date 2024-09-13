package com.example.Thawaq.Service;

import com.example.Thawaq.Api.ApiException;
import com.example.Thawaq.Model.Expert;
import com.example.Thawaq.Model.Rating;
import com.example.Thawaq.Model.Store;
import com.example.Thawaq.Model.User;
import com.example.Thawaq.Repository.ExpertRepository;
import com.example.Thawaq.Repository.RatingRepository;
import com.example.Thawaq.Repository.StoreRepository;
import com.example.Thawaq.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RatingService {
    private final RatingRepository ratingRepository;
    private final UserRepository userRepository;
    private final StoreRepository storeRepository;
    private final ExpertRepository expertRepository;

    public List<Rating> getAllRatings() {

        return ratingRepository.findAll();
    }
//Add rating from the user to the store
    public void addRatingFromUserToStore(Rating rating,Integer userId, Integer storeId) {
        User u = userRepository.findUserById(userId);
        Store s = storeRepository.findStoreById(storeId);
        if(u==null) {
            throw new ApiException("User not found");}
        if(s==null) {
            throw new ApiException("Store not found");}
        rating.setStore(s);
        rating.setClient(rating.getClient());
        userRepository.save(u);
        ratingRepository.save(rating);}

//Add rating from expert to the store
public void addRatingFromExpertToStore(Rating rating,Integer expertId, Integer storeId) {
    Expert e =expertRepository.findExpertById(expertId);
    Store s = storeRepository.findStoreById(storeId);
    if(e==null) {
        throw new ApiException("User not found");}
    if(s==null) {
        throw new ApiException("Store not found");}
    rating.setStore(s);
    rating.setExpert(e);
    expertRepository.save(e);
    ratingRepository.save(rating);}


    public void updateRating(Rating rating,Integer id) {
        Rating r = ratingRepository.findRatingById(id);
        if(r == null) {
            throw new ApiException("Rating not found");}
        r.setService(rating.getService());
        r.setCleaning(rating.getCleaning());
        r.setQuality(rating.getQuality());
        r.setCost(rating.getCost());
        r.setComment(rating.getComment());
        r.setTitle(rating.getTitle());
        r.setAverageRating(rating.getAverageRating());
        ratingRepository.save(r);}


    public void deleteRating(Integer id) {
        Rating r = ratingRepository.findRatingById(id);
        if(r == null) {
            throw new ApiException("Rating not found");}
        ratingRepository.delete(r);
    }



}
