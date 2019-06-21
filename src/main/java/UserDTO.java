public class UserDTO {
    private final String login;
    private final String password;
    private final String country;

    public UserDTO(String login, String password, String country) {
        this.login = login;
        this.password = password;
        this.country = country;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getCountry() {
        return country;
    }
}
