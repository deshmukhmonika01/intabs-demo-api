package in.co.intabs.bootcamp.demo.geo.structure.api;

import in.co.intabs.bootcamp.demo.geo.structure.dto.CityDto;
import in.co.intabs.bootcamp.demo.geo.structure.jpa.entity.City;
import in.co.intabs.bootcamp.demo.geo.structure.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    // Delete City

    // Get By Id - City

    // Get By Language - List<City>

    // Get All Cities arranged asc alphabetical order
    // Get All Cities arranged Desc alphabetical order

    // Add attribute as 'isDeleted' of type Boolean to City
    // Delete City  No Hard Record deletion - just make this flag as True
    // Get All Non Deleted cities
}
