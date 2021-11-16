package com.jointrivial.sourcemanager.nordigen.service.impl;

import com.jointrivial.sourcemanager.nordigen.model.view.CountryViewModel;
import com.jointrivial.sourcemanager.nordigen.repository.CountryRepository;
import com.jointrivial.sourcemanager.nordigen.service.CountryService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CountryServiceImpl implements CountryService {

    private final CountryRepository countryRepository;
    private final ModelMapper modelMapper;

    public CountryServiceImpl(CountryRepository countryRepository, ModelMapper modelMapper) {
        this.countryRepository = countryRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<CountryViewModel> getAllAvailableCountries() {

        return countryRepository.findAll()
                .stream().map(country ->
                        modelMapper.map(country, CountryViewModel.class)
                ).collect(Collectors.toList());
    }
}
