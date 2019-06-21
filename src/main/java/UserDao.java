import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserDao {
    private final Map<Long, User> users = new HashMap<>();
    private Long userId = 0L;

    public User create(User user) {
        Long id = userId;
        userId += 1;

        user.setId(id);
        users.put(id, user);
        return user;
    }

    public Optional<User> getById(Long id) {
        return Optional.ofNullable(users.get(id));
    }

    public boolean delete(Long id) {
        return Optional.ofNullable(users.remove(id)).isPresent();
    }
}
