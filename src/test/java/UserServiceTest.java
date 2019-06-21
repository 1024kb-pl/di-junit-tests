import org.junit.Assert;
import org.junit.Test;

public class UserServiceTest {
    private final String POLAND = "poland";
    private final Country POLAND_COUNTRY = new Country("Warsaw", 38437239L, "Polska");

    @Test
    public void shouldCorrectAddNewUser() {
        // given
        UserService userService = new UserService();
        UserDTO userDTO = new UserDTO("pablo", "pablo123", POLAND);
        User expectedUser = new User("pablo", "pablo123", POLAND_COUNTRY);
        expectedUser.setId(0L);

        // when
        User resultUser = userService.createUser(userDTO);

        // then
        Assert.assertEquals(expectedUser, resultUser);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowLoginExceptionWhileCreatingNewUser() {
        // given
        UserService userService = new UserService();
        UserDTO userDTO = new UserDTO("pa", "pablo123", POLAND);

        // when
        userService.createUser(userDTO);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowPasswordExceptionWhileCreatingNewUser() {
        // given
        UserService userService = new UserService();
        UserDTO userDTO = new UserDTO("pablo", "pass", POLAND);

        // when
        userService.createUser(userDTO);
    }

    @Test
    public void shouldCorrectRemoveUser() {
        // given
        UserService userService = new UserService();
        UserDTO userDTO = new UserDTO("pablo", "pablo123", POLAND);
        userService.createUser(userDTO);


        //when
        userService.removeUser(0L);
    }

    @Test(expected = RuntimeException.class)
    public void shouldThrowExceptionWhenUserDoesntExistWhileRemoving() {
        // given
        UserService userService = new UserService();

        //when
        userService.removeUser(1L);
    }

}
