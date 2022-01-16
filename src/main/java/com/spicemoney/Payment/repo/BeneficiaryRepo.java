package com.spicemoney.Payment.repo;

import com.spicemoney.Payment.Entity.BeneficiaryTable;
import com.spicemoney.Payment.Entity.MasterTable;
import com.spicemoney.Payment.model.BeneficiaryDTO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BeneficiaryRepo extends MongoRepository<BeneficiaryTable, String> {
  BeneficiaryTable findByAccountNo(String accountNo);
}
