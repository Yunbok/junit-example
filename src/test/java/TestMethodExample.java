import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMethodExample {

    @Test
    @DisplayName("assertEqual() 예제")
    void test1() {
        //assertEquals(기대값, 실제값)
        int i = 100;

        assertEquals(100, i);
        assertNotEquals(99, i);
    }

    @Test
    @DisplayName("assertSame() 예제")
    void test2() {
        User user1 = new User(1L, "YB", 29);
        User user2 = user1;
        User user3 = new User(2L, "YB", 30);

        assertSame(user1, user2);
        assertNotSame(user3, user2);
    }

    @Test
    @DisplayName("assertTrue, False 예제")
    void test3() {
        User user1 = new User(1L, "YB", 29);

        assertTrue(user1.getAge() == 29);
        assertFalse(user1.getAge() == 30);
    }

    @Test
    @DisplayName("assertNull, notNull 예제")
    void test4() {
        User user1 = null;
        User user2 = new User(1L, "YB", 29);

        assertNull(user1);
        assertNotNull(user2);
    }

    @Test
    @DisplayName("assertThrows 예제")
    void test5() {
        User user = new User(1L, "YB", 29);

        assertThrows(IllegalArgumentException.class, () -> user.throwExceptionTest());
        assertDoesNotThrow(() -> user.getName());
    }



}
