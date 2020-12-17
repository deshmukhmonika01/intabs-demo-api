package in.co.intabs.bootcamp.demo.geo.structure.jpa.repository;

import in.co.intabs.bootcamp.demo.geo.structure.jpa.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    List<City> findByIsDeletedFalse();

    @Query("FROM City ORDER BY name ASC")
    List<City> findAllOrderByNameAsc();

    @Query("FROM City ORDER BY name DESC")
    List<City> findAllOrderByNameDesc();

    List<City> findByLanguage(String language);
}
