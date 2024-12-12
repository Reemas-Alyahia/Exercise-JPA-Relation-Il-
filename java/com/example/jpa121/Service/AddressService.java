package com.example.jpa121.Service;

import com.example.jpa121.ApiResponse.ApiException;
import com.example.jpa121.DTO.AddressDTO;
import com.example.jpa121.Model.Address;
import com.example.jpa121.Model.Teacher;
import com.example.jpa121.Repository.AddressRepository;
import com.example.jpa121.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address>getAllAddress(){
        return addressRepository.findAll();
    }

    public void addAddress(AddressDTO addressDTO){
        Teacher teacher=teacherRepository.findTeacherById(addressDTO.getTeacherId());
        if(teacher==null){
            throw new ApiException("Teacher cannot found ");
        }
 Address address=new Address(null,addressDTO.getArea(),addressDTO.getStreet(),addressDTO.getBuildingNumber(),teacher);

        addressRepository.save(address);

    }

    public void updateAddress(AddressDTO addressDTO){
        Address address=addressRepository.findAddressById(addressDTO.getTeacherId());
        if(address==null){
            throw new ApiException("Address cannot found ");
        }
   address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());

        addressRepository.save(address);

    }



}
