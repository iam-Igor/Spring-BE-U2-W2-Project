package ygorgarofalo.SpringU2W2Project.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import ygorgarofalo.SpringU2W2Project.entities.User;
import ygorgarofalo.SpringU2W2Project.exceptions.BadRequestExc;
import ygorgarofalo.SpringU2W2Project.exceptions.NotFoundExc;
import ygorgarofalo.SpringU2W2Project.payloads.UserPayloadDTO;
import ygorgarofalo.SpringU2W2Project.reposiories.UserDAO;

@Service
public class UserService {

    @Autowired
    UserDAO userDAO;


    // metodo richiamato dal get /users
    public Page<User> getUsers(int page, int size, String order) {
        Pageable pageable = PageRequest.of(page, size, Sort.by(order));
        return userDAO.findAll(pageable);
    }


    // metodo richiamato dal Get /users/id

    public User findById(long id) {
        return userDAO.findById(id).orElseThrow(() -> new NotFoundExc(id));
    }


    // metodo richiamato dalla Post /users con payload

    public User saveUser(UserPayloadDTO payload) {


        User newUser = new User(payload.name(), payload.surname(), payload.email(), payload.username());

        // controlli sull'esistenza sul db di email e username tramite due metodi booleani creati sul dao di User
        if (userDAO.existsByEmail(payload.email())) {
            throw new BadRequestExc("L'email " + payload.email() + " è gia presente nel sistema.");
        } else if (userDAO.existsByUsername(payload.username())) {
            throw new BadRequestExc("Lo username " + payload.username() + " è gia presente nel sistema.");
        } else {

            return userDAO.save(newUser);
        }

    }


    //metodo richiamato da PUT /users/id

    public User findByIdAndUpdate(long id, UserPayloadDTO payload) {

        User foundUser = this.findById(id);

        if (userDAO.existsByEmail(payload.email())) {
            throw new BadRequestExc("L'email " + payload.email() + " è gia presente nel sistema.");
        } else if (userDAO.existsByUsername(payload.username())) {
            throw new BadRequestExc("Lo username " + payload.username() + " è gia presente nel sistema.");
        } else {
            foundUser.setName(payload.name());
            foundUser.setSurname(payload.surname());
            foundUser.setEmail(payload.email());
            foundUser.setUsername(payload.username());

            return userDAO.save(foundUser);
        }


    }


    // metodo richiamato da Delete /users/id

    public void findByidAndDelete(long id) {
        User foundUser = this.findById(id);

        userDAO.delete(foundUser);

    }
}
