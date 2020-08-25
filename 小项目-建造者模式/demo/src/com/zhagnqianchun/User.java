package com.zhagnqianchun;


public class User {
    private String username;
    private String password;
    private String hobby;
    private String address;

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                '}';
    }


    public static final class UserBuilder {
        private String username;
        private String password;
        private String hobby;
        private String address;

        private UserBuilder() {
        }

        public static UserBuilder anUser() {
            return new UserBuilder();
        }

        public UserBuilder setUsername(String username) {
            this.username = username;
            return this;
        }

        public UserBuilder setPassword(String password) {
            this.password = password;
            return this;
        }

        public UserBuilder setHobby(String hobby) {
            this.hobby = hobby;
            return this;
        }

        public UserBuilder setAddress(String address) {
            this.address = address;
            return this;
        }

        public User build() {
            User user = new User();
            user.username = this.username;
            user.address = this.address;
            user.password = this.password;
            user.hobby = this.hobby;
            return user;
        }
    }
}
