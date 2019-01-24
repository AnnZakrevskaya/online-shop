package service;

import repository.model.Rewiew;
import repository.model.User;

import java.util.List;

public interface UserService {
    boolean isUserValid(String username, String password);
    int getUserIdByName(String username);
    boolean isAdminValid(String username, String password);
    List<User> getUserAllList();
    List<Rewiew> getRewiewsList();
    void addRewiew(String username, String rewiew);
}
