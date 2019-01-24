package repository;

import repository.model.Perfume;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PerfumeRepositoryImpl implements PerfumeRepository {
    private static PerfumeRepositoryImpl instance;

    private PerfumeRepositoryImpl() {
    }

    public static PerfumeRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new PerfumeRepositoryImpl();
        }
        return instance;
    }

    private ConnectionService connectionService = ConnectionServiceImpl.getInstance();

    @Override
    public Perfume getPerfume(Integer id) {
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT * FROM t_product WHERE id_product=?")) {
                    statement.setLong(1, id);
                    ResultSet resultSet = statement.executeQuery();
                    if (resultSet.next()) {
                        return Perfume.newBuilder()
                                .id_perfume(resultSet.getInt("id_product"))
                                .name_perfume(resultSet.getString("product_name"))
                                .size(resultSet.getInt("size"))
                                .quantity(resultSet.getInt("quantity"))
                                .price(resultSet.getInt("price"))
                                .image(resultSet.getString("image_adress"))
                                .type(resultSet.getString("type"))
                                .build();
                    }
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
        return null;
    }

    @Override
    public List<Perfume> getPerfumeList(){
        List<Perfume> listPerfume = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT * FROM t_product;"
                    );
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        listPerfume.add(Perfume.newBuilder()
                                .id_perfume(resultSet.getInt("id_product"))
                                .name_perfume(resultSet.getString("product_name"))
                                .size(resultSet.getInt("size"))
                                .price(resultSet.getInt("price"))
                                .quantity(resultSet.getInt("quantity"))
                                .image(resultSet.getString("image_adress"))
                                .type(resultSet.getString("type"))
                                .build()
                        );
                    }
                    return listPerfume;
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
}
