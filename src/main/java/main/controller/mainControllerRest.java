package main.controller;

import main.model.User;
import main.service.ServiceUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class mainControllerRest {

    @Autowired
    private ServiceUser serviceUser;

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

    @PostMapping("/getByName")
    public User getByName(@RequestParam("name") String name) {
        return  serviceUser.findByName(name);
    }
}
