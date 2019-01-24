package repository.model;

import java.util.List;

public class Order {
    private Integer id_ord;
    private String user;
    private Double price;
    private String status;
    private String adress;
    private List<Perfume> perfumes;

    public Integer getIdorder() {
        return id_ord;
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

    public String getAdress(){return adress;}

    public List<Perfume> getPerfumes() {
        return perfumes;
    }

    private Order(Builder builder) {
        id_ord = builder.id_ord;
        user = builder.user;
        price = builder.price;
        status = builder.status;
        adress = builder.adress;
        perfumes = builder.perfumes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer id_ord;
        private String user;
        private Double price;
        private String status;
        private String adress;
        private List<Perfume> perfumes;

        private Builder() {
        }

        public Builder id(Integer val) {
            id_ord = val;
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

       public Builder adress(String val){
           adress=val;
           return this;
      }

        public Builder perfumes(List<Perfume> val) {
            perfumes = val;
            return this;
        }

        public Order build() {
            return new Order(this);
        }
    }

    @Override
    public String toString(){
        return "Order{" +
                "id=" + id_ord +
                ", id_user='" + user + '\'' +
                ", status=" + status +
                ", price=" + price +
                ", adress=" + adress +
                '}';
    }
}
