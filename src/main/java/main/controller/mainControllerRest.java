package main.controller;

import main.model.Role;
import main.model.User;
import main.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.Set;

@RestController
public class mainControllerRest {

    @Autowired
    private ServiceUser serviceUser;
//    @Autowired
//    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public Iterable<User> allUser() {
        Iterable<User> list = serviceUser.findAll();
        return list;
    }

    @PostMapping("/add")
    public User createUser(@RequestBody User user) {
        return  serviceUser.save(user);
    }

    @PostMapping("/edit")
    public User update(@RequestBody User user) {
//        Long id = Long.parseLong(idd);
//        int ageInt = Integer.parseInt(age);
//        HashSet<Role> roles = (HashSet<Role>) getRoles(userRoles);
//        User byName = serviceUser.findById(id).get();
//        if (!password.equals("")) {
//            byName.setPassword(password);
//
//            //  byName.setPassword(passwordEncoder.encode(password));
//        }
//        byName.setId(id);
//        byName.setName(name);
//        byName.setLastName(lastName);
//        byName.setAge(ageInt);
//        byName.setEmail(email);
//        byName.setUserRoles(roles);

        return serviceUser.save(user);
    }


    @PostMapping("/delete")
    public HttpStatus delete(@RequestParam("id") String idd) {
        Long id = Long.parseLong(idd);
        serviceUser.deleteById(id);
        return HttpStatus.OK;
    }

    @GetMapping("/get/{id}")
    public User getUser(@PathVariable("id") String idd) {
        Long id = Long.parseLong(idd);
        User byId = serviceUser.findById(id).get();
        return byId;
    }
    @PostMapping("/findById")
    public User getUserById(@RequestParam("id") String idd) {
        Long id = Long.parseLong(idd);
        User byId = serviceUser.findById(id).get();
        return byId;
    }

    private Set<Role> getRoles(@RequestParam("role") String role) {
        Set<Role> userRoles = new HashSet<>();
        String[] split = role.split(",");
        for (String s : split) {
            userRoles.add(Role.valueOf(s));
        }
        return userRoles;
    }

    @PostMapping("/getByName")
    public User getByName(@RequestParam("name") String name) {
        return  serviceUser.findByName(name);
    }
}
