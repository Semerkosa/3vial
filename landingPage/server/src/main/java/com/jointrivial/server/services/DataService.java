package com.jointrivial.server.services;

import com.jointrivial.server.models.binding.BindingModel;

import java.util.List;

public interface DataService {

    boolean create(BindingModel bindingModel);
    String getAllData();
    long count();

    List<String> getAllEmails();

    long getActualCountOfUsers();

    long getQuestion1Statistics(String answer);

    long getQuestion2Statistics(String answer);

    List<String> getQuestion3Statistics();
}
