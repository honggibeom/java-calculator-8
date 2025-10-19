package calculator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 커스텀_구분자_사용() {
        assertSimpleTest(() -> {
            run("//;\\n1");
            assertThat(output()).contains("결과 : 1");
        });
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("-1,2,3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전제조건1() {
        assertSimpleTest(() -> {
            run("//;w;\\n1;w;2");
            assertThat(output()).contains("결과 : 3");
        });
    }

    @Test
    void 전제조건2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//,2\\n1,222"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 전제조건3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("//;;\\n\\n2;;\\n\\n2"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자열처리_case1() {
        assertSimpleTest(() -> {
            run("//,sw\\n1,sw2,5,sw6");
            assertThat(output()).contains("결과 : 14");
        });
    }

    @Test
    void 문자열처리_case2() {
        assertSimpleTest(() -> {
            run("1,2,32");
            assertThat(output()).contains("결과 : 35");
        });
    }

    @Test
    void 입력값검증_case1_1() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1,-2,3,-4"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값검증_case1_2() {
        assertSimpleTest(() -> {
            run("1,2,3,4");
            assertThat(output()).contains("결과 : 10");
        });
    }

    @Test
    void 입력값검증_case2_1_1() {
        assertSimpleTest(() -> {
            run("//;;;\\n2;;;3,1");
            assertThat(output()).contains("결과 : 6");
        });
    }

    @Test
    void 입력값검증_case2_1_2() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("//\\n2,3,1"))
                    .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력값검증_case2_2() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("/;;;\\n2;;;3,1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
            Application.main(new String[]{});
    }
}
