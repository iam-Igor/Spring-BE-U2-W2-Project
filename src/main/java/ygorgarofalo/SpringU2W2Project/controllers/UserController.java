package ygorgarofalo.SpringU2W2Project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ygorgarofalo.SpringU2W2Project.entities.User;
import ygorgarofalo.SpringU2W2Project.exceptions.BadRequestExc;
import ygorgarofalo.SpringU2W2Project.payloads.UserPayloadDTO;
import ygorgarofalo.SpringU2W2Project.responses.UserResponse;
import ygorgarofalo.SpringU2W2Project.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public Page<User> getUsers(@RequestParam(defaultValue = "0") int page,
                               @RequestParam(defaultValue = "10") int size,
                               @RequestParam(defaultValue = "id") String order) {
        return userService.getUsers(page, size, order);
    }


    @GetMapping("/{id}")
    public User findById(@PathVariable long id) {
        return userService.findById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public UserResponse saveUser(@RequestBody @Validated UserPayloadDTO user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExc(bindingResult.getAllErrors());
        } else {
            User newuser = userService.saveUser(user);
            return new UserResponse(newuser.getId());
        }
    }


    @PutMapping("/{id}")
    public User updateUser(@PathVariable long id, @RequestBody UserPayloadDTO updatedUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            throw new BadRequestExc(bindingResult.getAllErrors());
        } else {
            return userService.findByIdAndUpdate(id, updatedUser);
        }


    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable long id) {
        userService.findByidAndDelete(id);
    }


    //PATCH per uploadare immagine e ricevere la stringa da salvare nel db

    @PatchMapping("/{userId}/upload")
    public String uploadAvatarImg(@RequestParam("image") MultipartFile file, @PathVariable long userId) throws Exception {
        return userService.uploadImage(file, userId);
    }


}
