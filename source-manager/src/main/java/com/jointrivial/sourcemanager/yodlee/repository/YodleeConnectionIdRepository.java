package com.jointrivial.sourcemanager.yodlee.repository;

import com.jointrivial.sourcemanager.yodlee.model.entity.YodleeConnectionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface YodleeConnectionIdRepository extends JpaRepository<YodleeConnectionId, String> {

    YodleeConnectionId getByUserId(String userId);
}
