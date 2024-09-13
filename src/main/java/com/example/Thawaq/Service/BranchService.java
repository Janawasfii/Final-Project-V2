package com.example.Thawaq.Service;

import com.example.Thawaq.Model.Branch;
import com.example.Thawaq.Model.Store;
import com.example.Thawaq.Repository.BranchRepository;
import com.example.Thawaq.Repository.StoreRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BranchService {

    private final BranchRepository branchRepository;
    private final StoreRepository storeRepository;

    public List<Branch> getBranches()
    {
        return branchRepository.findAll();
    }

    public void addBranch(Integer sID,Branch branch)
    {
        Store s = storeRepository.findStoreById(sID);
        if(s == null)
        {
            //            throw new ApiException("Store not found");
        }
        branch.setStore(s);
        branchRepository.save(branch);
    }
    public void updateBranch(Integer bID,Branch branch)
    {
        Branch b = branchRepository.findBranchById(bID);
        if(b == null)
        {
            //            throw new ApiException("Branch not found");
        }
        b.setName(branch.getName());
        b.setClosed(branch.isClosed());
        branchRepository.save(b);
    }
    public void deleteBranch(Integer bID)
    {
        if(branchRepository.findBranchById(bID) == null)
        {
            //            throw new ApiException("Branch not found");
        }
        branchRepository.deleteById(bID);
    }
}
