package service;

public interface RegistrService {
    boolean addUser(String fio, String login, String password, String phone, String adress, String email);
}
