package ru.neoflex.application.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.neoflex.application.data.LoanApplicationRequestDTO;
import ru.neoflex.application.data.LoanOfferDTO;
import ru.neoflex.application.utils.feign.DealUtils;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApplicationService {

    private final DealUtils dealUtils;

    public List<LoanOfferDTO> getLoanOffers(LoanApplicationRequestDTO loanApplicationRequestDTO) {
        return dealUtils.getLoanOffers(loanApplicationRequestDTO);
    }

    public void applyOffer(LoanOfferDTO loanOfferDTO) {
        dealUtils.applyOffer(loanOfferDTO);
    }
}
