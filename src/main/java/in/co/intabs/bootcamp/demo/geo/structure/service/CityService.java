package in.co.intabs.bootcamp.demo.geo.structure.service;

import in.co.intabs.bootcamp.demo.geo.structure.dto.CityDto;
import in.co.intabs.bootcamp.demo.geo.structure.jpa.entity.City;
import in.co.intabs.bootcamp.demo.geo.structure.jpa.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityService {

    @Autowired
    private CityRepository cityRepository;

    public List<City> getAllCities() {
        List<City> allCities = cityRepository.findAll();
        return allCities;
    }

    public City add(CityDto cityDto) {
        City toAdd = new City();
        toAdd.setName(cityDto.getName());
        toAdd.setLanguage(cityDto.getLanguage());
        toAdd.setState(cityDto.getState());
        City savedCity = cityRepository.save(toAdd);
        return savedCity;
    }
}
