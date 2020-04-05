package ladder.domain;

import ladder.Exception.ExceptionType;
import ladder.Exception.LadderException;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class UserTest {
    @Test
    void listOf() {
        List<User> users = User.listOf("pobi,honux,crong,jk");

        assertThat(users).hasSize(4);
        assertThat(users.get(0).getName()).isEqualTo("pobi");
        assertThat(users.get(1).getName()).isEqualTo("honux");
        assertThat(users.get(2).getName()).isEqualTo("crong");
        assertThat(users.get(3).getName()).isEqualTo("jk");
    }

    @Test
    void listOf_EXCEPTION() {
        assertThatThrownBy(() -> User.listOf("crong12"))
                .isInstanceOf(LadderException.class)
                .hasMessageContaining(ExceptionType.INVALID_NAME_SIZE.getErrorMessage());
    }
}
