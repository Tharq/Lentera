package com.lentera.crud_application.controller;

import com.lentera.crud_application.model.Customer;
import com.lentera.crud_application.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1")
@CrossOrigin(origins = "*")
public class UserController {

    private final UserService service;

    @PostMapping("/register")

    public String post(@RequestBody Customer user){
        return service.post(user);
    }

    @GetMapping("/find")

    public List<Customer> find(){
        return service.find();
    }

    @DeleteMapping("/delete/{id}")

    public String delete(@PathVariable Integer id){
        return service.delete(id);
    }

    @PutMapping("/update/{id}")

    public String update(@PathVariable int id,@RequestBody Customer customer){
        return service.update(id,customer);
    }
}
