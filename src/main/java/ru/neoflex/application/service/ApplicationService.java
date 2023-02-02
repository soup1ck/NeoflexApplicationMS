package ru.neoflex.application.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ru.neoflex.application.data.LoanApplicationRequestDTO;
import ru.neoflex.application.data.LoanOfferDTO;
import ru.neoflex.application.utils.feign.FeignDealClient;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final FeignDealClient feignDealClient;

    public List<LoanOfferDTO> getLoanOffers(LoanApplicationRequestDTO loanApplicationRequestDTO) {
        log.info("Прескоринг пройден");
        log.info("Идет процесс получения предложений");
        log.info("Запрашиваемый кредит: {}", loanApplicationRequestDTO);
        List<LoanOfferDTO> loanOffers = feignDealClient.getLoanOffers(loanApplicationRequestDTO);
        log.info("Процесс формирования предложений завершен");
        log.info("Предложения по кредиту: {}", loanOffers);
        return loanOffers;
    }

    public void applyOffer(LoanOfferDTO loanOfferDTO) {
        log.info("Идет процесс отправки принятого предложения: {}", loanOfferDTO);
        feignDealClient.applyOffer(loanOfferDTO);
        log.info("Процесс отправки принятого предложения завершен");
    }
}
