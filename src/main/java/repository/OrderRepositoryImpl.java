package repository;

import repository.model.Cart;
import repository.model.Order;
import repository.model.Perfume;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class OrderRepositoryImpl implements OrderRepository{
    private static OrderRepositoryImpl instance;

    private OrderRepositoryImpl() {
    }

    public static OrderRepositoryImpl getInstance() {
        if (instance == null) {
            instance = new OrderRepositoryImpl();
        }
        return instance;
    }

    private ConnectionService connectionService = ConnectionServiceImpl.getInstance();


    @Override
    public boolean addToOrder(int userId, List<Integer> perfumeId, Double price) {
        Connection connection = null;
        int number = findIdLastOrder();
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = null;
                    preparedStatement = connection.prepareStatement(
                            "INSERT  INTO t_order(id_order, id_user, price, status) " +
                                    "VALUES(?, ?, ?, ?);"
                    );

                    PreparedStatement preparedStatement1 = connection.prepareStatement(
                            "INSERT  INTO t_cart(id_order_cart, id_product)" +
                                    " VALUES(?,?);"
                    );
                    preparedStatement.setInt(1, (number + 1));
                    preparedStatement.setInt(2, userId);
                    preparedStatement.setDouble(3, price);
                    preparedStatement.setString(4, "ожидание");
                    preparedStatement.executeUpdate();

                    for (Integer aInteger : perfumeId) {
                        preparedStatement1.setInt(1, (number + 1));
                        preparedStatement1.setLong(2, aInteger);
                        preparedStatement1.executeUpdate();
                    }
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
    public Integer findNumber() {
        Connection connection = null;
        int count = 0;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT COUNT(*) FROM t_order;")) {
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
    public Integer findIdLastOrder() {
        Connection connection = null;
        int count = 0;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (PreparedStatement statement = connection.prepareStatement(
                        "SELECT MAX(id_order) FROM t_order;")) {
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
    public List<Cart> getOrderItemForUser(int userId) {
        List<Cart> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT DISTINCT t_order.id_order, t_order.price, t_order.status " +
                                    "FROM t_cart, t_order, t_product WHERE t_order.id_user=? " +
                                    "AND t_order.id_order=t_cart.id_order_cart " +
                                    "AND t_cart.id_product=t_product.id_product;"
                    );
                    preparedStatement.setInt(1, userId);
                    ResultSet resultSet = preparedStatement.executeQuery();
                    System.out.println("id заказа");
                    while (resultSet.next()) {
                        list.add(Cart.newBuilder()
                                .id(resultSet.getInt(1))
                                .userId(userId)
                                .price(resultSet.getDouble(2))
                                .status(resultSet.getString(3))
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
    public List<Order> getOrder(List<Cart> orderItemList) {
        Connection connection = null;
        List<Order> orderList = new ArrayList<>();
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = null;
                    for (Cart orderItem : orderItemList) {
                        preparedStatement = connection.prepareStatement(
                                "SELECT t_product.product_name, t_product.price, t_product.image_adress FROM t_cart, t_order, t_product " +
                                        "WHERE t_order.id_user=? AND t_order.id_order=? " +
                                        "AND t_order.id_order=t_cart.id_order_cart " +
                                        "AND t_cart.id_product=t_product.id_product;"
                        );
                        System.out.println(orderItem.getUserId());
                        System.out.println(orderItem.getUserId());
                        preparedStatement.setInt(1, orderItem.getUserId());
                        preparedStatement.setInt(2, orderItem.getId());
                        ResultSet resultSet = preparedStatement.executeQuery();
                        List<Perfume> perfumes = new ArrayList<>();
                        while (resultSet.next()) {
                            perfumes.add(Perfume.newBuilder()
                                    .name_perfume(resultSet.getString("t_product.product_name"))
                                    .price(resultSet.getInt("t_product.price"))
                                    .image(resultSet.getString("t_product.image_adress"))
                                    .build()
                            );
                        }

                        orderList.add(Order.newBuilder()
                                .id(orderItem.getId())
                                .user(orderItem.getUser())
                                .price(orderItem.getPrice())
                                .status(orderItem.getStatus())
                                .adress(orderItem.getAdress())
                                .perfumes(perfumes)
                                .build()
                        );
                    }
                    return orderList;
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
    public List<Cart> getOrderItemForAllUser() {
        List<Cart> list = new ArrayList<>();
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "SELECT DISTINCT t_order.id_order, t_user.iduser," +
                                    "t_user.fio, t_user.adress,t_order.price, t_order.status " +
                                    "FROM t_cart, t_order, t_product, t_user WHERE t_user.iduser=t_order.id_user" +
                                    " AND t_order.id_order=t_cart.id_order_cart " +
                                    "AND t_cart.id_product=t_product.id_product;"
                    );
                    ResultSet resultSet = preparedStatement.executeQuery();
                    while (resultSet.next()) {
                        list.add(Cart.newBuilder()
                                .id(resultSet.getInt("t_order.id_order"))
                                .userId(resultSet.getInt("t_user.iduser"))
                                .user(resultSet.getString("t_user.fio"))
                                .price(resultSet.getDouble("t_order.price"))
                                .status(resultSet.getString("t_order.status"))
                                .adress(resultSet.getString("t_user.adress"))
                                .build()
                        );
                    }
                    for(Cart cart:list){
                        System.out.println(cart.toString());
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
    public void updateOrder(int orderId) {
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "UPDATE t_order SET t_order.status=? WHERE t_order.id_order=?;"
                    );
                    preparedStatement.setString(1, "завершен");
                    preparedStatement.setInt(2, orderId);
                    preparedStatement.executeUpdate();
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
    }

    @Override
    public void deleteOrder(int orderId) {
        Connection connection = null;
        try {
            connection = connectionService.getConnection();
            if (connection != null) {
                try (Statement statement = connection.createStatement()) {
                    connection.setAutoCommit(false);
                    PreparedStatement preparedStatement = connection.prepareStatement(
                            "DELETE FROM t_cart WHERE t_cart.id_order_cart=?;"
                    );
                    preparedStatement.setInt(1, orderId);
                    preparedStatement.executeUpdate();
                    PreparedStatement preparedStatement1 = connection.prepareStatement(
                            "DELETE FROM t_order WHERE t_order.id_order=?;"
                    );
                    preparedStatement1.setInt(1, orderId);
                    preparedStatement1.executeUpdate();
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
    }
}
