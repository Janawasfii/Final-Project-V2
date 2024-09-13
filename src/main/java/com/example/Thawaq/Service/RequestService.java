package com.example.Thawaq.Service;

import com.example.Thawaq.Api.ApiException;
import com.example.Thawaq.Model.Expert;
import com.example.Thawaq.Model.Request;
import com.example.Thawaq.Model.Store;
import com.example.Thawaq.Model.StoreAdmin;
import com.example.Thawaq.Repository.ExpertRepository;
import com.example.Thawaq.Repository.RequestRepository;
import com.example.Thawaq.Repository.StoreAdminRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class RequestService {

    private final RequestRepository requestRepository;
    private final StoreAdminRepository storeAdminRepository;
    private final ExpertRepository expertRepository;

    public List<Request> getAllRequests() {

        return requestRepository.findAll();
    }
//Add Request from store admin to the expert(That Expert can rate the store)
    public void addRequest(Request request,Integer storeAdminId,Integer expertId) {
        StoreAdmin storeAdmin = storeAdminRepository.findStoreAdminById(storeAdminId);
        Expert e = expertRepository.findExpertById(expertId);
        if(storeAdmin == null){
            throw new ApiException("Store admin not found");}
        if(e == null){
            throw new ApiException("Expert not found");}
        request.setStatus(Request.Status.PENDING);
        request.setExpert(e);
        request.setStore(storeAdmin.getStore());
        expertRepository.save(e);
        requestRepository.save(request);}


    public void updateRequest(Request request,Integer requestId,Integer storeAdminId) {
        Request request1 = requestRepository.findRequestById(requestId);
        StoreAdmin storeAdmin = storeAdminRepository.findStoreAdminById(storeAdminId);
        if(request1 == null) {
            throw new ApiException("Request not found");}
        if(storeAdmin == null){
            throw new ApiException("Store admin not found");}
        request1.setDescription(request.getDescription());
        request1.setStatus(request.getStatus());
        request1.setPrice(request.getPrice());
        request1.setRequestDate(request.getRequestDate());
        requestRepository.save(request1);}


    public void deleteRequest(Integer requestId, Integer storeAdminId ) {
        Request r = requestRepository.findRequestById(requestId);
        StoreAdmin storeAdmin = storeAdminRepository.findStoreAdminById(storeAdminId);
        if(r == null) {
            throw new ApiException("Request not found");
        }
        if(storeAdmin == null){
            throw new ApiException("Store admin not found");
        }
        requestRepository.delete(r);
    }




}
