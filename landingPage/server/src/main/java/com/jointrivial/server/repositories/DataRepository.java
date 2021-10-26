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

    @Query("select count(d.answer2) from Data d where d.answer2 =?1")
    long getAllAnswersToQuestion2(String num);

    @Query("select d.answer3 from Data d")
    List<String> getAllAnswersToQuestion3();
}
