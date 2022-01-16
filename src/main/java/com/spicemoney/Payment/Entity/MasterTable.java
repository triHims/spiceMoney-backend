package com.spicemoney.Payment.Entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(value = "MasterTable")
@RequiredArgsConstructor
public class MasterTable {
  @Id
  public final String id;
  public long amount;
}
