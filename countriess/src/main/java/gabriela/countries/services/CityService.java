package gabriela.countries.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gabriela.countries.models.City;
import gabriela.countries.repositories.CityRepository;


@Service
public class CityService {
	@Autowired
	CityRepository cityRep;
	

	public List<City> findAll() {
		return cityRep.findAll();
	}
	
	public List<Object[]> queryOne(){
		return cityRep.queryOne();
	}
	public List<Object[]> queryTwo(){
		return cityRep.queryTwo();
	}
	public List<Object[]> queryThree(){
		return cityRep.queryThree();
	}
	public List<Object[]> queryFour(){
		return cityRep.queryFour();
	}
	public List<Object[]> queryFive(){
		return cityRep.queryFive();
	}
	public List<Object[]> querySix(){
		return cityRep.querySix();
	}
	public List<Object[]> querySeven(){
		return cityRep.querySeven();
	}
	public List<Object[]> queryEight(){
		return cityRep.queryEight();
	}
}
