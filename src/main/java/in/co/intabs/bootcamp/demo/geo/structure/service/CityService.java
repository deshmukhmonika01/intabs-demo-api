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

    //GET ALL CITIES(GET)
    public List<City> getAllCities() {
        List<City> allCities = cityRepository.findAll();
        return allCities;
    }

    //ADD CITY(POST)
    public City add(CityDto cityDto) {
        City toAdd = new City();
        toAdd.setName(cityDto.getName());
        toAdd.setLanguage(cityDto.getLanguage());
        toAdd.setState(cityDto.getState());
        City savedCity = cityRepository.save(toAdd);
        return savedCity;
    }

    //DELETE BY ID(DELETE)
    public boolean deleteCity(Long cityId) {
        cityRepository.deleteById(cityId);
        return true;
    }

    //SOFT-DELETE(DELETE)
    public City deleteCitySoft(Long cityId) {
        City city = cityRepository.findById(cityId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "City not found for id " + cityId));
        city.setDeleted(true);
        return cityRepository.save(city);
    }

    //GET CITY BY ID(GET)
    public Optional<City> GetCityById(Long id) {
        Optional<City> city = cityRepository.findById(id);
        return city;
    }

    //GET CITY LIST BY ASCENDING ORDER OF NAMES(GET)
    public List<City> findAllOrderByNameAsc() {
        return cityRepository.findAllOrderByNameAsc();
    }


    //GET CITY LIST BY DESCENDING ORDER OF NAMES(GET)
    public List<City> findAllOrderByNameDesc() { return cityRepository.findAllOrderByNameDesc(); }


    //GET CITY LIST BY LANGUAGE(GET)
    public List<City> findByLanguage(String language) {

        List<City> city = cityRepository.findByLanguage(language);
        return city;
    }


    //GET ALL NON DELETED CITIES(GET)
    public List<City> findByIsDeletedFalse() {
        return cityRepository.findByIsDeletedFalse();
    }


    //UPDATE CITY(PUT)
    public City updateCity( CityDto cityDto,Long id) {

        if (cityRepository.findById(id).isPresent()){
            City upCity = cityRepository.findById(id).get();

            upCity.setName(cityDto.getName());
            upCity.setState(cityDto.getState());
            upCity.setLanguage(cityDto.getLanguage());
            City updatedCity = cityRepository.save(upCity);
            return updatedCity;
        }else{
            return null;
        }
    }
}
