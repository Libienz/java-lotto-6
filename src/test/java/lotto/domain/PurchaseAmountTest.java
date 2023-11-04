package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.view.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayName("로또 구매 금액 테스트")
class PurchaseAmountTest {


    @DisplayName("구매 금액이 로또 금액보다 낮으면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 999})
    void testNotEnoughMoney(int amount) {
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_ENOUGH_PURCHASE_AMOUNT.getErrorMessage());
    }

    @DisplayName("구매 금액이 로또 금액의 배수가 아니면 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1001, 2001, 9999})
    void testInvalidAmountOfMoney(int amount) {
        assertThatThrownBy(() -> PurchaseAmount.from(amount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_PURCHASE_AMOUNT.getErrorMessage());
    }


}