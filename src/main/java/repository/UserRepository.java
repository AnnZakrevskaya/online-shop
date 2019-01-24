package repository;

import repository.model.Rewiew;
import repository.model.User;

import java.util.List;

public interface UserRepository {
    User getByUserName(String username);
    boolean isValid(String username, String password);
    Integer findIdLastUser();
    boolean addToUser(String fio, String login, String password, String phone, String adress, String email);
    boolean findLoginUser(String login);
    List<User> getUserList();
    List<Rewiew> getRewiewsList();
    boolean addRewiew(int userId, String rewiew, String date);
}
