package com.example.hw21.Controller;

import com.example.hw21.Api.ApiResponse;
import com.example.hw21.DTO.AddressDTO;
import com.example.hw21.Service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;


    @GetMapping("/get/{id}")
    public ResponseEntity getTeacherAddress(@PathVariable Integer id){

        return ResponseEntity.status(200).body( addressService.getAddress(id));

    }

    @PostMapping("/add")
    public ResponseEntity addTeacherAddress(@RequestBody AddressDTO addressDTO){
       addressService.addAddress(addressDTO);
       return ResponseEntity.status(200).body(new ApiResponse("added"));
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateTeacherAddress(@PathVariable Integer id, @RequestBody AddressDTO addressDTO){
        addressService.updateAddress(id,addressDTO);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteTeacherAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("deleted"));
    }
}
