package com.spicemoney.Payment.repo;

import com.spicemoney.Payment.Entity.MasterTable;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MasterTableRepo extends MongoRepository<MasterTable, String> {
}
