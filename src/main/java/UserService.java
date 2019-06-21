class UserService {
    private final UserDao userDao = new UserDao();
    private final UserValidator userValidator = new UserValidator();
    private final CountryService countryService = new CountryService();

    User createUser(UserDTO userDTO) {
        userValidator.validate(userDTO);

        Country country = countryService.getCountryByName(userDTO.getCountry());

        User user = convertToUser(userDTO, country);

        return userDao.create(user);
    }

    private User convertToUser(UserDTO userDTO, Country country) {
        return new User(userDTO.getLogin(), userDTO.getPassword(), country);
    }

    void removeUser(Long userId) {
        boolean result = userDao.delete(userId);

        if (!result) {
            throw new RuntimeException("User with id: " + userId + " doesn't exist.");
        }
    }
}
