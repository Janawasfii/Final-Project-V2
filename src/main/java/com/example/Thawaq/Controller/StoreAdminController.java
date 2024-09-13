package com.example.Thawaq.Controller;

import com.example.Thawaq.Api.ApiResponse;
import com.example.Thawaq.Model.Store;
import com.example.Thawaq.Model.StoreAdmin;
import com.example.Thawaq.Service.StoreAdminService;
import com.example.Thawaq.Service.StoreService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/store-admin")
public class StoreAdminController {
    private final StoreAdminService storeAdminService;
    private final StoreService storeService;

    @GetMapping("/get-all")
    public ResponseEntity getAll() {

        return ResponseEntity.status(200).body(storeAdminService.getAllStoreAdmins());
    }
    @GetMapping("/get-id/{id}")
    public ResponseEntity getById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(storeAdminService.getStoreAdminById(id));
    }


}
