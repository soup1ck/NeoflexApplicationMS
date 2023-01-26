package ru.neoflex.application.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.neoflex.application.data.LoanApplicationRequestDTO;
import ru.neoflex.application.data.LoanOfferDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/application")
public class ApplicationController {

    @PostMapping()
    public List<LoanOfferDTO> getLoanOffers(@Valid @RequestBody LoanApplicationRequestDTO loanApplicationRequestDTO){
        return null;
    }

    @PostMapping(value = "/offer")
    public void applyOffer(@RequestBody LoanOfferDTO loanOfferDTO){
    }
}
