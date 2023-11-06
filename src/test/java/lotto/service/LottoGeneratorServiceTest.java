package lotto.service;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

@DisplayName("자동 로또 발행기 테스트")
class LottoGeneratorServiceTest {

    @DisplayName("생성된 로또는 검증 요구사항을 통과한다")
    @RepeatedTest(50)
    void testGeneratedLottoIsValid() {
        LottoGeneratorService lottoGeneratorService = new LottoGeneratorService();
        Assertions.assertThatNoException().isThrownBy(lottoGeneratorService::generateLotto);
    }
}