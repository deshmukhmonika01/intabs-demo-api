package in.co.intabs.bootcamp.demo.geo.structure.api;

import in.co.intabs.bootcamp.demo.geo.structure.dto.CityDto;
import in.co.intabs.bootcamp.demo.geo.structure.jpa.entity.City;
import in.co.intabs.bootcamp.demo.geo.structure.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value="/api/v1/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @RequestMapping(value = "/getAll", method = RequestMethod.GET)
    public List<City> getAllCities() {
        return cityService.getAllCities();
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public City addCity(@RequestBody CityDto cityDto) {
        return cityService.add(cityDto);
    }

    // Update City (name/State/language) - PUT
    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public City updateCity(@RequestBody CityDto cityDto,@PathVariable Long id) {
        return cityService.updateCity(cityDto,id);
    }

    // Get By Id - City
    @RequestMapping(value = "/getCity/{id}", method = RequestMethod.GET)
    public Optional<City> GetCityById(@PathVariable Long id){
        return cityService.GetCityById(id);
    }

    // Delete City
    @RequestMapping(value = "/delete/{cityId}", method = RequestMethod.DELETE)
    public boolean deleteCity(@PathVariable Long cityId) {
        return cityService.deleteCity(cityId);
    }

    // Get All Cities arranged asc alphabetical order
    @RequestMapping(value = "/ascending", method = RequestMethod.GET)
    public List<City> getCitiesByNameAsc() {

        return cityService.findAllOrderByNameAsc();
    }

    // Get All Cities arranged Desc alphabetical order
    @RequestMapping(value = "/descending", method = RequestMethod.GET)
    public List<City> getCitiesByNameDesc() {

        return cityService.findAllOrderByNameDesc();
    }

    // Get By Language - List<City>
    @RequestMapping(value ="/{language}",method = RequestMethod.GET)
    public List<City> findCityByLanguage(@PathVariable String language) {

        List<City> city = cityService.findByLanguage(language);
        return city;
    }

    // Delete City  No Hard Record deletion - just make this flag as True
    @RequestMapping(value = "/delete-soft/{cityId}", method = RequestMethod.DELETE)
    public City deleteCitySoft(@PathVariable Long cityId) {
        return cityService.deleteCitySoft(cityId);
    }

    // Get All Non Deleted cities
    @RequestMapping(value = "/is-deleted", method = RequestMethod.GET)
    public List<City> GetAllNonDeletedCity() {
        return cityService.findByIsDeletedFalse();
    }


}
