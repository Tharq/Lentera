package com.lentera.crud_application.service;

import com.lentera.crud_application.Repository.UserRepository;
import com.lentera.crud_application.model.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    public String post(Customer user){
        repository.save(user);
        return "user saved";
    }

    public List<Customer> find() {
        return repository.findAll();
    }

    public String delete (Integer id){
        repository.deleteById(id);
        return "id deleted";
    }
    public String update(Integer id, Customer newUserDetails) {
        Optional<Customer> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {
            Customer existingUser = optionalUser.get();

            // Update fields with new details
            if (newUserDetails.getName() != null) {
                existingUser.setName(newUserDetails.getName());
            }
            if (newUserDetails.getEmail() != null) {
                existingUser.setEmail(newUserDetails.getEmail());
            }
            if (newUserDetails.getPassword() != null) {
                existingUser.setPassword(newUserDetails.getPassword());
            }

            System.out.println(existingUser.getName());
            repository.save(existingUser);
            return "user updated";
        } else {
            return "user not found";
        }
    }

}
