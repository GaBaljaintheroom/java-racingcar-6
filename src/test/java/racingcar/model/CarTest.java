package racingcar.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

@DisplayName("자동차 객체에 대해")
class CarTest {

    @ParameterizedTest
    @ValueSource(strings = {"박준수12222", "123456", "1234567"})
    @DisplayName("이름 길이가 5 이하가 아니라면 에러가 발생한다.")
    void validate_name_length(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"pobi", "woni", "jun"})
    @DisplayName("이름의 길이가 정상적이다.")
    void correct_name_length(String name) {
        assertThatCode(() -> new Car(name))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("이동한 만큼의 현재 위치를 알 수 있다.")
    void status_car_position() {
        //given
        Car car = new Car("pobi");
        IntStream
                .range(0, 3)
                .forEach(i -> car.movePosition());

        //when
        String carPosition = car.statusCarPosition();

        //then
        assertThat(carPosition).isEqualTo("pobi : ---\n");
    }
}
