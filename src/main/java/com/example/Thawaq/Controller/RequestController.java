package com.example.Thawaq.Controller;

import com.example.Thawaq.Api.ApiResponse;
import com.example.Thawaq.Model.Request;
import com.example.Thawaq.Service.RequestService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@RestController
@RequestMapping("/api/v1/request")
@RequiredArgsConstructor
public class RequestController {
    private final RequestService requestService;

    @GetMapping("/get-all")
    public ResponseEntity getAllRatings() {
        return ResponseEntity.status(200).body(requestService.getAllRequests());
    }


    //add Request (Jana) v2
    @PostMapping("/add-request/{storeAdminId}/{expertId}")
    public ResponseEntity addRequest(@Valid @RequestBody Request request,@PathVariable Integer storeAdminId, @PathVariable Integer expertId) {
        requestService.addRequest(request,storeAdminId,expertId);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully added request !"));
    }

    @PutMapping("/update-request/{requestId}/{storeAdminId}")
    public ResponseEntity updateRequest(@PathVariable Integer requestId,@PathVariable Integer storeAdminId, @Valid @RequestBody Request request) {
        requestService.updateRequest(request,requestId,storeAdminId);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully updated request!"));}


    @DeleteMapping("/delete-request/{requestId}/{storeAdminId}")
    public ResponseEntity deleteRequest(@PathVariable Integer requestId,@PathVariable Integer storeAdminId) {
        requestService.deleteRequest(requestId,storeAdminId);
        return ResponseEntity.status(200).body(new ApiResponse("Successfully deleted request!"));}
}
