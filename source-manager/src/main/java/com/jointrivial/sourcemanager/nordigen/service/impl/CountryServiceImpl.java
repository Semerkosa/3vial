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

        List<CountryViewModel> countries = countryRepository.findAll()
                .stream().map(nordigenSupportedCountries -> {
                    return modelMapper.map(nordigenSupportedCountries, CountryViewModel.class);
                }).collect(Collectors.toList());

        return countries;
    }
}
