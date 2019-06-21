class UserValidator {
    void validate(UserDTO user) {
        if (isPasswordTooShort(user.getPassword())) {
            throw new RuntimeException("Password is too short.");
        }

        if (isLoginTooShort(user.getLogin())) {
            throw new RuntimeException("Login is too short.");
        }
    }

    private boolean isLoginTooShort(String login) {
        return login.length() < 3;
    }

    private boolean isPasswordTooShort(String password) {
        return password.length() < 6;
    }
}
