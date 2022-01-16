package com.spicemoney.Payment.service;

import com.spicemoney.Payment.Entity.BeneficiaryTable;
import com.spicemoney.Payment.model.BeneficiaryDTO;
import com.spicemoney.Payment.model.DataModel;
import java.util.List;

public interface DetailsService {
  long getAmount();
  boolean addBeneficiary(BeneficiaryDTO beneficiaryDTO);
  List<BeneficiaryTable> getAllBeneficiary();
  boolean addMoneyToBeneficiary(DataModel model);
}
