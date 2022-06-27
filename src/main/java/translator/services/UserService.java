package translator.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import translator.entities.tables.Users;
import translator.entities.UsersRepository;

import java.util.List;

@Service
public class UserService {

    private UsersRepository usersRepository;

    @Autowired
    public void setUsersRepository(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public Users getUserByName(String  username){
        return usersRepository.findByUsername(username);
    }


    public List<Users> getAllUsers(){
        return usersRepository.findAll();
    }

    public void deliteUser(Users user){
        usersRepository.delete(user);
    }



}
