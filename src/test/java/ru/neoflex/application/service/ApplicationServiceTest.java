package ru.neoflex.application.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.neoflex.application.data.LoanApplicationRequestDTO;
import ru.neoflex.application.data.LoanOfferDTO;
import ru.neoflex.application.utils.feign.FeignDealClient;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ApplicationServiceTest {

    private final FeignDealClient feignDealClient = Mockito.mock(FeignDealClient.class);
    private final ApplicationService applicationService = new ApplicationService(feignDealClient);

    private LoanApplicationRequestDTO loanApplicationRequestDTO;
    private LoanOfferDTO loanOfferDTO;

    @BeforeEach
    public void setUp() {
        loanApplicationRequestDTO = new LoanApplicationRequestDTO();
        loanApplicationRequestDTO.setEmail("test");
        loanOfferDTO = new LoanOfferDTO();
        loanOfferDTO.setApplicationId(1L);
    }

    @Test
    @DisplayName(value = "Получение предложений с deal")
    void getLoanOffers() {

        Mockito.when(feignDealClient.getLoanOffers(loanApplicationRequestDTO))
                .thenAnswer(invocationOnMock -> {
                    List<LoanOfferDTO> loanOffers = new ArrayList<>();
                    loanOffers.add(new LoanOfferDTO());
                    loanOffers.add(new LoanOfferDTO());
                    loanOffers.add(new LoanOfferDTO());
                    loanOffers.add(new LoanOfferDTO());
                    return loanOffers;
                });

        List<LoanOfferDTO> loanOffersFromDeal = applicationService.getLoanOffers(loanApplicationRequestDTO);

        Assertions.assertEquals(4, loanOffersFromDeal.size());
    }

    @Test
    @DisplayName(value = "Отправка принято предложения через feign на deal")
    void applyOffer() {
        applicationService.applyOffer(loanOfferDTO);

        Mockito.verify(feignDealClient, Mockito.times(1)).applyOffer(loanOfferDTO);
    }
}