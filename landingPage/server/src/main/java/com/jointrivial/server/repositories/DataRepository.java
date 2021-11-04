package com.jointrivial.server.repositories;

import com.jointrivial.server.models.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, String> {
    @Query("select d.email from Data d")
    List<String> getAllEmails();

    Data getDataByEmail(String email);
}
