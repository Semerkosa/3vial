package com.jointrivial.server.services;

import com.google.gson.*;
import com.jointrivial.server.models.binding.BindingModel;
import com.jointrivial.server.models.entities.*;
import com.jointrivial.server.repositories.DataRepository;
import com.jointrivial.server.repositories.QuestionRepository;
import com.jointrivial.server.repositories.TextInputRepository;
import com.jointrivial.server.utils.CustomLocalDateTimeSerializer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DataServiceImpl implements DataService {
    private final DataRepository dataRepository;
    private final QuestionRepository questionRepository;
    private final TextInputRepository textInputRepository;

    @Autowired
    public DataServiceImpl(DataRepository dataRepository, QuestionRepository questionRepository, TextInputRepository textInputRepository) {
        this.dataRepository = dataRepository;
        this.questionRepository = questionRepository;
        this.textInputRepository = textInputRepository;
    }


    @Override
    @Transactional
    public boolean create(BindingModel bindingModel) {
        try {
            Data data = new Data();
            data.setEmail(bindingModel.getEmail());
            data.setAnswer_2(bindingModel.getAnswer_2());
            data.setAnswer_3(bindingModel.getAnswer_3());
            data.setAnswers_1(bindingModel.getAnswers_1()
                    .stream().map(e -> new Answer(e, data)).collect(Collectors.toSet()));
            dataRepository.saveAndFlush(data);
            if (!bindingModel.getText_input_1().equals("")) {
                TextInput_1 textInput_1 = new TextInput_1(bindingModel.getText_input_1(), data);
                textInputRepository.saveAndFlush(textInput_1);
            }
            if (!bindingModel.getText_input_2().equals("")) {
                TextInput_2 textInput_2 = new TextInput_2(bindingModel.getText_input_2(), data);
                textInputRepository.saveAndFlush(textInput_2);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public String getAllData() {
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(LocalDateTime.class, new CustomLocalDateTimeSerializer())
                .setPrettyPrinting()
                .create();
        return gson.toJson(dataRepository.findAll());
    }

    @Override
    public long count() {
        long days = Duration.between(LocalDate.of(2021, 10, 20).atStartOfDay(), LocalDate.now().atStartOfDay()).toDays();
        return this.dataRepository.count() + 324 + days + (long) Math.sqrt(days);
    }

    @Override
    public List<String> getAllEmails() {
        return this.dataRepository.getAllEmails();
    }

    @Override
    public long getActualCountOfUsers() {
        return this.dataRepository.count();
    }

    @Override
    public long getQuestion1Statistics(String answer) {
        return this.questionRepository.getAnswersCountByNumber(answer);
    }

    @Override
    public long getQuestion2Statistics(String answer) {
        return this.dataRepository.getAllAnswersToQuestion2(answer);
    }

    @Override
    public List<String> getQuestion3Statistics() {
        return this.dataRepository.getAllAnswersToQuestion3();
    }
}
