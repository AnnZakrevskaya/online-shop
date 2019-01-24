package repository.model;

public class Rewiew {
    private Integer iduser;
    private String username;
    private String rewiew;
    private String date;

    public Integer getIduser() {
        return iduser;
    }

    public String getUsername() {
        return username;
    }

    public String getRewiew() {
        return rewiew;
    }

    public String getDate() {
        return date;
    }

    private Rewiew(Builder builder) {
        iduser = builder.iduser;
        username = builder.username;
        rewiew = builder.rewiew;
        date = builder.date;
    }

    public static Builder newBuilder() {
        return new Builder();
    }


    public static final class Builder {
        private Integer iduser;
        private String username;
        private String rewiew;
        private String date;

        private Builder() {
        }

        public Builder id(int val) {
            iduser = val;
            return this;
        }

        public Builder username(String val) {
            username = val;
            return this;
        }

        public Builder rewiew(String val) {
            rewiew = val;
            return this;
        }

        public Builder date(String val) {
            date = val;
            return this;
        }

        public Rewiew build() {return new Rewiew(this); }
    }
    @Override
    public String toString(){
        return "Cart{" +
                "id=" + iduser +
                ", user=" + username +
                ", status=" + rewiew +
                ", adress=" + date +
                '}';
    }
}
