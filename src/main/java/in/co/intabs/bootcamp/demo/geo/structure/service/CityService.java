package in.co.intabs.bootcamp.demo.geo.structure.service;

import in.co.intabs.bootcamp.demo.geo.structure.dto.CityDto;
import in.co.intabs.bootcamp.demo.geo.structure.jpa.entity.City;
import in.co.intabs.bootcamp.demo.geo.structure.jpa.repository.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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

    public boolean deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
        return true;
    }

    public City deleteCitySoft(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found for id " + cityId));
        city.setDeleted(true);
        return cityRepository.save(city);
    }

    public Optional<City> GetCityById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        return city;
    }

    public List<City> findAllOrderByNameAsc() {
        return cityRepository.findAllOrderByNameAsc();
    }

    public List<City> findAllOrderByNameDesc() { return cityRepository.findAllOrderByNameDesc(); }

    public List<City> findByLanguage(String language) {

        List<City> city = cityRepository.findByLanguage(language);
        return city;
    }

    public List<City> findByIsDeletedFalse() {
        return cityRepository.findByIsDeletedFalse();
    }

}
