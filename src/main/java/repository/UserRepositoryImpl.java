package repository;

import repository.model.Rewiew;
import repository.model.User;
import repository.property.AdminProperty;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {
    private static UserRepositoryImpl instance;
    public List<User> userList;

    private UserRepositoryImpl() {
    }

    public static UserRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new UserRepositoryImpl();
        }
        return instance;
    }

    private ConnectionService connectionService = ConnectionServiceImpl.getInstance();

    @Override
    public User getByUserName(String username) {
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if(connection !=null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT iduser, login, password, fio, phone, adress, email FROM t_user WHERE login=?")) {
                    statement.setString(1, username);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        System.out.println("попали в бд");
                       return User.newBuilder()
                                .id(resultSet.getInt("iduser"))
                                .username(resultSet.getString("login"))
                                .password(resultSet.getString("password"))
                                .fio(resultSet.getString("fio"))
                                .phone(resultSet.getString("phone"))
                                .adress(resultSet.getString("adress"))
                                .email(resultSet.getString("email"))
                                .build();
                    }
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } finally {
            if(connection !=null){
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return null;
    }

    @Override
    public List<User> getUserList(){
        List<User> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT iduser, login, password, fio, phone, adress, email FROM t_user"
                    );
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        list.add(User.newBuilder()
                                .id(resultSet.getInt("iduser"))
                                .username(resultSet.getString("login"))
                                .password(resultSet.getString("password"))
                                .fio(resultSet.getString("fio"))
                                .phone(resultSet.getString("phone"))
                                .adress(resultSet.getString("adress"))
                                .email(resultSet.getString("email"))
                                .build()
                        );
                    }
                    return list;
                }
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public List<Rewiew> getRewiewsList(){
        List<Rewiew> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT  t_user.iduser," +
                                    "t_user.login, t_rewiews.rewiew, t_rewiews.date " +
                                    "FROM t_rewiews, t_user WHERE t_user.iduser=t_rewiews.id_user;"
                    );
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        list.add(Rewiew.newBuilder()
                                .id(resultSet.getInt("t_user.iduser"))
                                .username(resultSet.getString("t_user.login"))
                                .rewiew(resultSet.getString("t_rewiews.rewiew"))
                                .date(resultSet.getString("t_rewiews.date"))
                                .build()
                        );
                    }
                    for(Rewiew rewiew:list){
                        System.out.println(rewiew.toString());
                    }
                    return list;
                }
            }
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    @Override
    public boolean isValid(String username, String password) {
        if(username.equals(AdminProperty.username) && password.equals(AdminProperty.password)){
            return true;
        }
        return false;
    }

    @Override
    public boolean addToUser(String fio, String login, String password, String phone, String adress, String email){
        Connection connection = null;
        if(findLoginUser(login)==false){
            System.out.println("попали в проверку");
            return false;
        }
        int number = findIdLastUser();
        System.out.println(fio+" "+adress);
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = null;
                    preparedStatement = connection.prepareStatement(
                            "INSERT  INTO t_user(iduser, login, password, fio, phone, adress, email) " +
                                    "VALUES(?, ?, ?, ?, ?, ?, ?);"
                    );
                    preparedStatement.setInt(1, (number + 1));
                    preparedStatement.setString(2, login);
                    preparedStatement.setString(3, password);
                    preparedStatement.setString(4, fio);
                    preparedStatement.setString(5, phone);
                    preparedStatement.setString(6, adress);
                    preparedStatement.setString(7, email);
                    preparedStatement.executeUpdate();
                }
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public boolean addRewiew(int idUser, String rewiew, String date){
        Connection connection = null;
               System.out.println(idUser+" "+rewiew+ " "+date);
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = null;
                    preparedStatement = connection.prepareStatement(
                            "INSERT  INTO t_rewiews(id_user, rewiew, date) " +
                                    "VALUES(?, ?, ?);"
                    );
                    preparedStatement.setInt(1, idUser);
                    preparedStatement.setString(2, rewiew);
                    preparedStatement.setString(3, date);
                    preparedStatement.executeUpdate();
                }
                connection.commit();
                return true;
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
            e.printStackTrace();
        } finally {
            try {
                connection.setAutoCommit(true);
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return false;
    }

    @Override
    public Integer findIdLastUser() {
        Connection connection = null;
        int count = 0;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT MAX(iduser) FROM t_user;")) {
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        count = resultSet.getInt(1);
                    }
                    return count;
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return count;
    }

    @Override
    public boolean findLoginUser(String login) {
        Connection connection = null;
        int count = 0;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT login FROM t_user;")) {
                    ResultSet resultSet = statement.executeQuery();
                    System.out.println("проверочка");
                    while (resultSet.next()) {
                        if(login.equals(resultSet.getString(1))){
                            System.out.println(login);
                            System.out.println(resultSet.getString(1));
                        return false;}
                    }
                    return true;
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                    e.printStackTrace();
                }
            }
        } finally {
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
        return true;
    }
}
