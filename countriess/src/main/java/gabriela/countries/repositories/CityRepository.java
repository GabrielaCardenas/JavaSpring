package gabriela.countries.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gabriela.countries.models.City;


@Repository
public interface CityRepository extends CrudRepository<City, Long>{
	List<City> findAll();
	
	@Query(value="SELECT c.name,l.language,l.percentage FROM cities c JOIN languages l on(c.id=l.country_id) WHERE l.language='slovene' ORDER BY l.percentage DESC", nativeQuery=true)
	List<Object[]> queryOne();
	
	@Query(value="select c.name, count(d.country_id) from countries c join cities d  on(c.id=d.country_id) group by (c.name) order by count(d.country_id) DESC", nativeQuery=true)
	List<Object[]> queryTwo();
	
	@Query(value="SELECT c.name,c.population from cities c join countries d on(d.id=c.country_id) where d.name='Mexico' and c.population>500000", nativeQuery=true)
	List<Object[]> queryThree();
	
	@Query(value="select c.name, l.language from languages l join countries c on(l.country_id=c.id) where l.percentage>89 order by l.percentage desc", nativeQuery=true)
	List<Object[]> queryFour();
	
	@Query(value="select name from countries c where c.population>100000 and c.surface_area<501",nativeQuery=true)
	List<Object[]> queryFive();
	
	@Query(value="select name from countries c where c.government_form='Constitutional Monarchy' and c.surface_area>200 and c.life_expectancy>75",nativeQuery=true)
	List<Object[]> querySix();
	
	// SIN EL "AS" (cname,dname) DABA ERROR EN LA PETICION POSTMAN
	@Query(value="select d.name as cname,c.name as dname,c.district,c.population from cities c join countries d on(d.id=c.country_id) where c.district='Buenos Aires' and c.population>500000",nativeQuery=true)
	List<Object[]> querySeven();
	
	@Query(value="select c.region, count(c.id) from countries c group by c.region order by count(c.id)",nativeQuery=true)
	List<Object[]> queryEight();
}
