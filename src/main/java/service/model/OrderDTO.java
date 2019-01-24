package service.model;

import java.util.List;

public class OrderDTO {

    private String username;
    private Integer id_order;
    private Double price;
    private String status;
    private String adress;
    private List<PerfumeDTO> perfumes;

    public Integer getIdorder() {
        return id_order;
    }

    public String getUser() {
        return username;
    }

    public Double getPrice() {
        return price;
    }

    public String getStatus() {
        return status;
    }

    public String getAdress(){return adress;}

    public List<PerfumeDTO> getPerfumes() {
        return perfumes;
    }

    private OrderDTO(Builder builder) {
        id_order = builder.id_order;
        username = builder.username;
        price = builder.price;
        status = builder.status;
        adress = builder.adress;
        perfumes = builder.perfumes;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer id_order;
        private String username;
        private Double price;
        private String status;
        private String adress;
        private List<PerfumeDTO> perfumes;

        private Builder() {
        }

        public Builder id(Integer val) {
            id_order = val;
            return this;
        }

        public Builder user(String val) {
            username = val;
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

        public Builder perfumes(List<PerfumeDTO> val) {
            perfumes = val;
            return this;
        }

        public OrderDTO build() {
            return new OrderDTO(this);
        }
    }
    @Override
    public String toString() {
        return "Perfume{" +
                "id=" + id_order +
                ", user='" + username + '\'' +
                ", status=" + status +
                ", price=" + price +
                '}';
    }
}
