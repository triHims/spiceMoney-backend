package com.spicemoney.Payment.Entity;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "BeneficiaryTable")
@RequiredArgsConstructor
@Getter
public class BeneficiaryTable {
  @Id
  private String id;
  public final String name;
  public final String accountNo;
  public final String isfcCode;
  public long amount;
}
