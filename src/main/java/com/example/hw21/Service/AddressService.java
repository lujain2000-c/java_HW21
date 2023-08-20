package com.example.hw21.Service;

import com.example.hw21.Api.ApiException;
import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Model.Address;
import com.example.hw21.Model.Teacher;
import com.example.hw21.Repository.AddressRepository;
import com.example.hw21.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public Address getAddress(Integer id) {
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("not found");
        }
        Address address = addressRepository.findAddressById(id);
        return address;
    }

    public void addAddress(AddressDTO addressDTO) {
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("not found");

        }
        Address address = new Address(null, addressDTO.getArea(), addressDTO.getStreet(), addressDTO.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(Integer id,AddressDTO addressDTO){
        Teacher teacher = teacherRepository.findTeacherById(addressDTO.getTeacher_id());
        if (teacher == null) {
            throw new ApiException("not found");

        }
        Address address = addressRepository.findAddressById(addressDTO.getTeacher_id());
        address.setArea(addressDTO.getArea());
        address.setStreet(addressDTO.getStreet());
        address.setBuildingNumber(addressDTO.getBuildingNumber());
        addressRepository.save(address);

    }

    public void deleteAddress(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher == null) {
            throw new ApiException("not found");

        }
        Address address = addressRepository.findAddressById(id);
        addressRepository.delete(address);
    }
}
