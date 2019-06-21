public class UserService {
    public final static Country DEFAULT_COUNTRY = new Country("LONDON", 668000004L, "Wielka Brytania");
    private final UserDao userDao;
    private final UserValidator userValidator;
    private final CountryRestService countryService;

    UserService(UserDao userDao, UserValidator userValidator, CountryRestService countryService) {
        this.userDao = userDao;
        this.userValidator = userValidator;
        this.countryService = countryService;
    }


    User createUser(UserDTO userDTO) {
        userValidator.validate(userDTO);

        Country country = getCountry(userDTO.getCountry());

        User user = convertToUser(userDTO, country);

        return userDao.create(user);
    }

    private Country getCountry(String country) {
        try {
            return countryService.getCountryByName(country);
        } catch (Exception e) {
            System.err.println("Can't fetch country by name: " + country + " due to: " + e.getMessage());
            return DEFAULT_COUNTRY;
        }
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
