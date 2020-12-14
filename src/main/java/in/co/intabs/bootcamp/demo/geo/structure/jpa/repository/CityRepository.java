package in.co.intabs.bootcamp.demo.geo.structure.jpa.repository;

import in.co.intabs.bootcamp.demo.geo.structure.jpa.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CityRepository extends JpaRepository<City, Long> {

}
