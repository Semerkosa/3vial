package com.jointrivial.sourcemanager.nordigen.service;

import com.jointrivial.sourcemanager.nordigen.model.view.CountryViewModel;
import java.util.List;

public interface CountryService {

    List<CountryViewModel> getAllAvailableCountries();
}
