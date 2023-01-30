package ru.neoflex.application.utils.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import ru.neoflex.application.data.LoanApplicationRequestDTO;
import ru.neoflex.application.data.LoanOfferDTO;

import java.util.List;

@FeignClient(name = "application", url = "http://localhost:8081/deal")
public interface FeignDealClient {

    @PostMapping(value = "/application")
    List<LoanOfferDTO> getLoanOffers(@RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO);

    @PutMapping(value = "/offer")
    void applyOffer(@RequestBody LoanOfferDTO loanOfferDTO);
}
