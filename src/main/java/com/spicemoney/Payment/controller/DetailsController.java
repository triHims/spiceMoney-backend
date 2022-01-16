package com.spicemoney.Payment.controller;

import com.spicemoney.Payment.Entity.BeneficiaryTable;
import com.spicemoney.Payment.model.BeneficiaryDTO;
import com.spicemoney.Payment.model.DataModel;
import com.spicemoney.Payment.service.DetailsService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/data")
@RequiredArgsConstructor
@Slf4j
public class DetailsController {
  final private DetailsService detailsService;

  @GetMapping(path = "amount" , produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity <String> getMapping(){
    log.info("getMapping called from class {}",this.getClass());
    return ResponseEntity.ok(String.valueOf(detailsService.getAmount()));
  }

  @PostMapping(path = "addBeneficiary" , produces = MediaType.TEXT_PLAIN_VALUE)
  public ResponseEntity <String> addBeneficiary(@RequestBody BeneficiaryDTO beneficiaryDTO){
    log.info("addBeneficiary called from class {}",this.getClass());
    return ResponseEntity.ok(String.valueOf(detailsService.addBeneficiary(beneficiaryDTO)));
  }

  @PostMapping(path = "getAllBeneficiary" , produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity <List<BeneficiaryTable>> getAllBeneficiary(){
    log.info("addBeneficiary called from class {}",this.getClass());
    return ResponseEntity.ok(detailsService.getAllBeneficiary());
  }
  @PostMapping(path = "addMoney" , produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity <String> addMoneyToBeneficiary(@RequestBody DataModel dataModel){
    log.info("addBeneficiary called from class {}",this.getClass());
    return ResponseEntity.ok(String.valueOf(detailsService.addMoneyToBeneficiary(dataModel)));
  }

}
