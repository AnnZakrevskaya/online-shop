package repository.model;

public class Perfume {
    private int id_perfume;
    private String name_perfume;
    private int size;
    private int price;
    private int quantity;
    private String image_adress;
    private String type;

    private Perfume(Builder builder) {
        id_perfume = builder.id_perfume;
        name_perfume = builder.name_perfume;
        size = builder.size;
        quantity = builder.quantity;
        price = builder.price;
        image_adress = builder.image_adress;
        type = builder.type;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getId_perfume() {
        return id_perfume;
    }

    public String getName_perfume() {return name_perfume;}

    public int getSize(){return size;}

    public int getPrice(){return price;}

    public int getQuantity(){return quantity;}

    public String getImage_adress(){return image_adress;}

    public String getType(){return type;}

    public static final class Builder {
        private int id_perfume;
        private String name_perfume;
        private int size;
        private int quantity;
        private int price;
        private String image_adress;
        private String type;

        private Builder() {
        }

        public Builder id_perfume(int val) {
            id_perfume = val;
            return this;
        }

        public Builder name_perfume(String val) {
            name_perfume = val;
            return this;
        }

        public Builder size(int val) {
            size = val;
            return this;
        }

        public Builder quantity(int val) {
            quantity = val;
            return this;
        }

        public Builder price(int val) {
            price = val;
            return this;
        }

        public Builder image(String val){
            image_adress = val;
            return this;
        }

        public Builder type(String val){
            type= val;
            return this;
        }

        public Perfume build() {
            return new Perfume(this);
        }
    }

    @Override
    public String toString() {
        return "Perfume{" +
                "id=" + id_perfume +
                ", name_perfume='" + name_perfume + '\'' +
                ", size=" + size +
                ", quantity=" + quantity +
                ", price=" + price +
                ", image_adress=" + image_adress +
                ", type=" + type +
                '}';
    }
}
