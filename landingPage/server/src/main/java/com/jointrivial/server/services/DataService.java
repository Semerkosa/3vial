package com.jointrivial.server.services;

import com.jointrivial.server.models.binding.DataBindingModel;
import com.jointrivial.server.models.binding.SurveyBindingModel;

import java.util.List;

public interface DataService {

    void createData(DataBindingModel dataBindingModel);

    String getAllData(int page);

    long count();

    List<String> getAllEmails();

    long getActualCountOfUsers();

    long getQuestion1Statistics(String answer);

    long getQuestion2Statistics(String answer);

    List<String> getQuestion3Statistics();

    void addSurvey(SurveyBindingModel surveyBindingModel);

}
