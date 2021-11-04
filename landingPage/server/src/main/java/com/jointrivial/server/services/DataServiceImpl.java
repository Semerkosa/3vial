package com.jointrivial.server.services;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jointrivial.server.models.binding.DataBindingModel;
import com.jointrivial.server.models.binding.SurveyBindingModel;
import com.jointrivial.server.models.entities.*;
import com.jointrivial.server.repositories.DataRepository;
import com.jointrivial.server.repositories.QuestionRepository;
import com.jointrivial.server.repositories.SurveyRepository;
import com.jointrivial.server.repositories.TextInputRepository;
import com.jointrivial.server.utils.CustomLocalDateTimeSerializer;
import org.modelmapper.ModelMapper;
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
    private final SurveyRepository surveyRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public DataServiceImpl(DataRepository dataRepository, QuestionRepository questionRepository,
                           TextInputRepository textInputRepository, SurveyRepository surveyRepository,
                           ModelMapper modelMapper) {
        this.dataRepository = dataRepository;
        this.questionRepository = questionRepository;
        this.textInputRepository = textInputRepository;
        this.surveyRepository = surveyRepository;
        this.modelMapper = modelMapper;
    }


    @Override
    public boolean createData(DataBindingModel dataBindingModel) {
        try {
            Data data = modelMapper.map(dataBindingModel, Data.class);
            dataRepository.saveAndFlush(data);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    @Transactional
    public boolean addSurvey(SurveyBindingModel surveyBindingModel) {
        try {
            Survey survey = new Survey();
            Data data = dataRepository.getDataByEmail(surveyBindingModel.getEmail());
            survey.setData(data);
            survey.setAnswer2(surveyBindingModel.getAnswer2());
            survey.setAnswer3(surveyBindingModel.getAnswer3());
            survey.setAnswers1(surveyBindingModel.getAnswers1()
                    .stream().map(e -> new Answer(e, survey)).collect(Collectors.toSet()));
            surveyRepository.saveAndFlush(survey);
            if (!surveyBindingModel.getTextInput1().equals("")) {
                TextInputFirstQuestion textInput1 = new TextInputFirstQuestion(surveyBindingModel.getTextInput1(), survey);
                textInputRepository.saveAndFlush(textInput1);
            }
            if (!surveyBindingModel.getTextInput2().equals("")) {
                TextInputSecondQuestion textInput2 = new TextInputSecondQuestion(surveyBindingModel.getTextInput2(), survey);
                textInputRepository.saveAndFlush(textInput2);
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
        return this.surveyRepository.getAllAnswersToQuestion2(answer);
    }

    @Override
    public List<String> getQuestion3Statistics() {
        return this.surveyRepository.getAllAnswersToQuestion3();
    }


}
