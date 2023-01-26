package ru.neoflex.application.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.application.data.LoanApplicationRequestDTO;
import ru.neoflex.application.data.LoanOfferDTO;
import ru.neoflex.application.service.ApplicationService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(value = "/application")
public class ApplicationController {

    private final ApplicationService applicationService;

    @PostMapping()
    public List<LoanOfferDTO> getLoanOffers(@Valid @RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO){
        return applicationService.getLoanOffers(loanApplicationRequestDTO);
    }

    @PostMapping(value = "/offer")
    public void applyOffer(@RequestBody LoanOfferDTO loanOfferDTO){
        applicationService.applyOffer(loanOfferDTO);
    }
}
