package dao;

class ExampleConfig {

    private String url = "jdbc:mysql://localhost/db_name?useSSL=false";
    private String user = "user";
    private String password = "password";

    public String getUrl() {
        return url;
    }

    public String getUser() {
        return user;
    }

    public String getPassword() {
        return password;
    }
}