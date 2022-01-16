package com.spicemoney.Payment.service;

import com.spicemoney.Payment.Entity.BeneficiaryTable;
import com.spicemoney.Payment.Entity.MasterTable;
import com.spicemoney.Payment.model.BeneficiaryDTO;
import com.spicemoney.Payment.model.DataModel;
import com.spicemoney.Payment.repo.BeneficiaryRepo;
import com.spicemoney.Payment.repo.MasterTableRepo;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DetailsServiceImpl implements DetailsService{
  final private MasterTableRepo masterTableRepo;
  final private BeneficiaryRepo beneficiaryRepo;
  @Override
  public long getAmount() {
      List<MasterTable> outList = masterTableRepo.findAll();
      return outList.get(0).amount;
  }

  @Override
  public boolean addBeneficiary(BeneficiaryDTO beneficiaryDTO) {
    BeneficiaryTable beneficiaryTable = new BeneficiaryTable(beneficiaryDTO.name,beneficiaryDTO.accountNo,beneficiaryDTO.isfcCode);
    beneficiaryTable.amount=0;
    BeneficiaryTable out = beneficiaryRepo.save(beneficiaryTable);
    return out.name.equals(beneficiaryTable.name);
  }

  @Override
  public List<BeneficiaryTable> getAllBeneficiary() {
    return beneficiaryRepo.findAll();
  }

  @Override
  public boolean addMoneyToBeneficiary(DataModel model) {
      MasterTable masterTable = masterTableRepo.findAll().get(0);
      if(masterTable.amount<model.amount)
        return false;

      BeneficiaryTable out = beneficiaryRepo.findByAccountNo(model.accountNo);
      out.amount+=model.amount;
      beneficiaryRepo.save(out);

      masterTable.amount-=model.amount;
      masterTableRepo.save(masterTable);
      return true;



  }
}
