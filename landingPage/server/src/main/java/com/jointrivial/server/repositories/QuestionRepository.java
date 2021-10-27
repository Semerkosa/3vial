package com.jointrivial.server.repositories;

import com.jointrivial.server.models.entities.Answer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface QuestionRepository extends JpaRepository<Answer, String> {
    @Query("select count(a) from Answer a where a.value=?1")
    long getAnswersCountByNumber(String number);
}
