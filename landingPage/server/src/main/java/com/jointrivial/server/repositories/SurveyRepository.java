package com.jointrivial.server.repositories;

import com.jointrivial.server.models.entities.Survey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SurveyRepository extends JpaRepository<Survey,String> {
    @Query("select count(s.answer2) from Survey s where s.answer2 =?1")
    long getAllAnswersToQuestion2(String num);

    @Query("select s.answer3 from Survey s")
    List<String> getAllAnswersToQuestion3();
}
