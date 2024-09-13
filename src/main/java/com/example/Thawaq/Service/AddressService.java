package com.example.Thawaq.Service;

import com.example.Thawaq.DTO.AddressDTO;
import com.example.Thawaq.Model.Address;
import com.example.Thawaq.Model.Branch;
import com.example.Thawaq.Repository.AddressRepository;
import com.example.Thawaq.Repository.BranchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {

    private final AddressRepository addressRepository;
    private final BranchRepository branchRepository;

    public List<Address> getAddresses()
    {
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO)
    {
        Branch b = branchRepository.findBranchById(addressDTO.getBranch_id());
        if(b == null)
        {
            //            throw new ApiException("Branch not found");
        }
        Address a = new Address(null,addressDTO.getCity(), addressDTO.getStreet(), b);
        addressRepository.save(a);
    }

    public void updateAddress(AddressDTO addressDTO)
    {
        Address a = addressRepository.findAddressById(addressDTO.getBranch_id());
        if(a == null)
        {
            //            throw new ApiException("Address not found");
        }
        a.setCity(addressDTO.getCity());
        a.setStreet(addressDTO.getStreet());
        addressRepository.save(a);
    }
    public void deleteAddress(Integer id)
    {
        if(addressRepository.findAddressById(id) == null)
        {
            //            throw new ApiException("Address not found");
        }
        addressRepository.deleteById(id);
    }
}
