package service;

import repository.UserRepository;
import repository.UserRepositoryImpl;
import repository.model.Rewiew;
import repository.model.User;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class UserServiceImpl implements UserService {
    private static UserServiceImpl instance;

    private UserServiceImpl(){
    }

    public static UserServiceImpl getInstance(){
        if(instance==null){
            instance= new UserServiceImpl();
        }
        return instance;
    }

    private UserRepository userRepository = UserRepositoryImpl.getInstance();

    @Override
    public boolean isUserValid(String username, String password) {
        User user = userRepository.getByUserName(username);
        return null != user && Objects.equals(user.getPassword(), password);
    }

    @Override
    public int getUserIdByName(String username) {
        User user= userRepository.getByUserName(username.trim());
        int id=user.getId();
        return id;
    }

    @Override
    public boolean isAdminValid(String username, String password) {
        if(userRepository.isValid(username, password)){
            return true;
        }
        return false;
    }

    @Override
    public List<User> getUserAllList(){return userRepository.getUserList();}

    @Override
    public List<Rewiew> getRewiewsList(){return userRepository.getRewiewsList();}

    @Override
    public void addRewiew(String username, String rewiew){
        int userId = getUserIdByName(username);
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        String dateRewiew = dateFormat.format(date);
        System.out.println(dateFormat.format(date));
        userRepository.addRewiew(userId, rewiew, dateRewiew);
    }
}
