import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.AbstractMap;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.*;


public class TestMethodExample2 {

    private User user1;
    private User user2;
    private User user3;
    private List<User> users;

    @BeforeEach
    void init() {
        user1 = new User(1L, "YB", 29);
        user2 = new User(2L, "YB2", 28);
        user3 = new User(3L, "YB3", 30);
        users = List.of(user1, user2, user3);
    }

    // AssertJ
    @Test
    @DisplayName("isEqualTo 예제")
    void test1() {
        int i = 100;

        assertThat(i).isEqualTo(100);
        assertThat(i).isNotEqualTo(99);
    }

    @Test
    @DisplayName("isTrue, isFalse 예제")
    void test2() {
        boolean t = true;
        boolean f = false;

        assertThat(user1.getAge() == 29).isTrue();
        assertThat(t).isTrue();
        assertThat(f).isFalse();
    }

    @Test
    @DisplayName("isIn 예제")
    void test3() {
        List<Integer> list = List.of(29,30,31,32);

        assertThat(user1.getAge()).isIn(list);
        assertThat(28).isNotIn(list);
    }

    @Test
    @DisplayName("문자열 검증 예제")
    void test4() {
        String whiteSpace = "   ";
        String number = "12323";
        String numberWhiteSpace = "22\r\n";

        // 숫자만 들어있는 문자열인지 검증
        assertThat(number).containsOnlyDigits();
        // 문자열이 전부 공백인지 검증
        assertThat(whiteSpace).containsOnlyWhitespaces();
        // 문자열에 공백이 있는지 검증 \t, \r\n 도 성공
        assertThat(numberWhiteSpace).containsWhitespaces();
        // 1 로 시작하는지 검증
        assertThat(number).startsWith("1");
        // 3으로 끝나는지 검증
        assertThat(number).endsWith("3");
    }

    @Test
    @DisplayName("LocalDateTime 검증 예제")
    void test5() {
        LocalDateTime now = LocalDateTime.of(2022, 12, 6, 23, 10);
        LocalDateTime ldt = LocalDateTime.of(2022, 12, 6, 23, 59);

        //일단위 까지 같은지 검증
        assertThat(now).isEqualToIgnoringHours(ldt);
        //시간단위까지 같은지 검증
        assertThat(now).isEqualToIgnoringMinutes(ldt);
    }


    @Test
    @DisplayName("contains 예제")
    void test6() {
        List<Integer> list = List.of(29,30,31,32);

        assertThat(user1.getAge()).isIn(list);
    }

    @Test
    @DisplayName("Collection List 검증 예제")
    void test7() {
        List<Integer> list = List.of(29,30,31,32);
        User user4 = new User(4L, "TB", 22);
        //List 크기 검증
        assertThat(users).hasSize(3);
        //List 가 값을 포함했는지 검증
        assertThat(users).contains(user1,user2);
        assertThat(users).containsAnyOf(user1,user4);

        // List 안의 값이 모두 조건에 만족하는지
        assertThat(users).allMatch(user -> user.getAge() > 20);
    }

    @Test
    @DisplayName("List 안의 객체 필드만 따로 리스트로 만들기")
    void test8() {
        //List 안의 객체 필드만 따로 리스트로 만들기
        assertThat(users).extracting("age").contains(28,29,30);
    }


    @Test
    @DisplayName("Collection Map 검증 예제")
    void test9() {
        Map<Integer, String> map = Map.of(29, "YB",30, "YB2",31, "YB3",32, "YB4");
        Map.Entry<Integer, String> entry = new AbstractMap.SimpleEntry<>(29, "YB");
        User user4 = new User(4L, "TB", 22);

        //Map 크기 검증
        assertThat(map).hasSize(4);
        //Map 이 Key 를 포함했는지 검증
        assertThat(map).containsKey(29);
        assertThat(map).containsKeys(29,30);
        //Map value 검증
        assertThat(map).containsValue("YB");
        // entry 가 포함되었는지 검증
        assertThat(map).contains(entry);
    }

    @Test
    @DisplayName("Exception 검증 예제")
    void test10() {
        // 코드를 실행 하고 그 익셉션의 타입이 맞는지 검사
        assertThatThrownBy(() -> user1.throwExceptionTest())
                .isInstanceOf(IllegalArgumentException.class);
        // 타입을 지정하고 익셉션 발생 코드 실행
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> user1.throwExceptionTest());
    }


}
