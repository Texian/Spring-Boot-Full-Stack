package com.packt.cardatabase.domain;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CarRepository extends PagingAndSortingRepository<Car, Long>, CrudRepository<Car, Long> {
    //Custom query: fetch by entity class field
    List<Car> findByColor(String color);
    List<Car> findByYear(int year);

    //Custom query: logic operators
    List<Car> findByMakeAndModel(String make, String model);
    List<Car> findByColorOrYear(String color, int year);

    //Custom query: ordered
    List<Car> findByMakeOrderByYearAsc(String make);

    //Custom query: SQL, no semicolon at the end
    @Query("select c from Car c where c.make = ?1")
    List<Car> findByMake(String make);

    //Custom query: SQL query, 'like', no semicolon at the end
    @Query("select c from Car c where c.make like %?1")
    List<Car> findByMakeEndsWith(String make);

    //Custom query: paginated and sorted
    Iterable<Car> findAll(Sort year);
    Page<Car> findAll(Pageable model);
}
