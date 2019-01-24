package repository.model;

public class User {
    private int id;
    private String username;
    private String password;
    private String fio;
    private String phone;
    private String adress;
    private String email;

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public String getFio() {return fio;}

    public String getPhone() { return phone; }

    public String getAdress() { return adress; }

    public String getEmail(){return email;}

    private User(Builder builder) {
        id = builder.id;
        username = builder.username;
        password = builder.password;
        fio = builder.fio;
        phone = builder.phone;
        adress = builder.adress;
        email = builder.email;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private int id;
        private String username;
        private String password;
        private String fio;
        private String phone;
        private String adress;
        private String email;

        private Builder() {
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder password(String val) {
            password = val;
            return this;
        }

        public Builder fio(String val) {
            fio = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }

        public Builder adress(String val) {
            adress = val;
            return this;
        }

        public Builder email(String val) {
            email = val;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
    @Override
    public String toString(){
        return "User{" +
                "id=" + id +
                ", user='" + username + '\'' +
                ", fio=" + fio +
                ", email=" + email +
                ", phone=" + phone +
                ", adress=" + adress +
                '}';
    }
}
