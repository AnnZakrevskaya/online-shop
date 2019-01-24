package repository.model;

public class Cart {
    private Integer id_cart;
    private Integer userId;
    private String user;
    private Double price;
    private String status;
    private String adress;

    public Integer getId() {
        return id_cart;
    }

    public Integer getUserId() {
        return userId;
    }

    public String getUser() {
        return user;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getAdress() {return adress;   }

    private Cart(Builder builder) {
        id_cart = builder.id_cart;
        userId = builder.userId;
        user = builder.user;
        price = builder.price;
        status = builder.status;
        adress =builder.adress;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer id_cart;
        private Integer userId;
        private String user;
        private Double price;
        private String status;
        private String adress;

        private Builder() {
        }

        public Builder id(int val) {
            id_cart = val;
            return this;
        }

        public Builder userId(int val) {
            userId = val;
            return this;
        }

        public Builder user(String val) {
            user = val;
            return this;
        }

        public Builder price(Double val) {
            price = val;
            return this;
        }

        public Builder status(String val) {
            status = val;
            return this;
        }

        public Builder adress(String val) {
            adress = val;
            return this;
        }

        public Cart build() {return new Cart(this); }
    }
    @Override
    public String toString(){
        return "Cart{" +
                "id=" + id_cart +
                ", id_user='" + userId + '\'' +
                ", price=" + price +
                ", user=" + user +
                ", status=" + status +
                ", adress=" + adress +
                '}';
    }
}
