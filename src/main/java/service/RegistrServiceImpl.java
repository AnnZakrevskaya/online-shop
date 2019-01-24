package service;

import repository.UserRepository;
import repository.UserRepositoryImpl;

public class RegistrServiceImpl implements RegistrService {
    private static RegistrServiceImpl instance;

    private RegistrServiceImpl() {
    }

    public static RegistrServiceImpl getInstance() {
        if (instance == null) {
            instance = new RegistrServiceImpl();
        }
        return instance;
    }

    private UserRepository userRepository = UserRepositoryImpl.getInstance();

    @Override
    public boolean addUser(String fio, String login, String password, String phone, String adress, String email){
        if(userRepository.addToUser(fio, login, password, phone, adress, email)==false){
            return false;
        }
        System.out.println(fio+" "+adress);
        return true;
    }
}
