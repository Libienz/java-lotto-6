package lotto.service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.PurchaseAmount;

public class LottoStoreService {
    public static final int LOTTO_PRICE = 1000;
    private static final int START_INDEX = 0;
    private final LottoGeneratorService lottoGeneratorService;

    public LottoStoreService(LottoGeneratorService lottoGeneratorService) {
        this.lottoGeneratorService = lottoGeneratorService;
    }

    public List<Lotto> purchaseLotto(PurchaseAmount purchaseAmount) {
        int count = purchaseAmount.affordableCountOfLotto();
        return IntStream.range(START_INDEX, count)
                .mapToObj(i -> lottoGeneratorService.generateLotto())
                .collect(Collectors.toList());
    }
}
