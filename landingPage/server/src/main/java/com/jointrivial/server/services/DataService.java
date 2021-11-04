package com.jointrivial.server.services;

import com.jointrivial.server.models.binding.DataBindingModel;
import com.jointrivial.server.models.binding.SurveyBindingModel;

import java.util.List;

public interface DataService {

    boolean createData(DataBindingModel dataBindingModel);

    String getAllData();

    long count();

    List<String> getAllEmails();

    long getActualCountOfUsers();

    long getQuestion1Statistics(String answer);

    long getQuestion2Statistics(String answer);

    List<String> getQuestion3Statistics();

    boolean addSurvey(SurveyBindingModel surveyBindingModel);

}
