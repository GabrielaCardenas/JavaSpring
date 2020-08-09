package gabriela.countries.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import gabriela.countries.services.CityService;


@RestController
public class CityController {
	@Autowired
	CityService cityService;
	
	@GetMapping("/query/1")
	public List<Object[]> queryOne(){
		return cityService.queryOne();
	}
	
	@GetMapping("/query/2")
	public List<Object[]> queryTwo(){
		return cityService.queryTwo();
	}
	
	@GetMapping("/query/3")
	public List<Object[]> queryThree(){
		return cityService.queryThree();
	}
	
	@GetMapping("/query/4")
	public List<Object[]> queryFour(){
		return cityService.queryFour();
	}
	
	@GetMapping("/query/5")
	public List<Object[]> queryFive(){
		return cityService.queryFive();
	}
	
	@GetMapping("/query/6")
	public List<Object[]> querySix(){
		return cityService.querySix();
	}
	
	@GetMapping("/query/7")
	public List<Object[]> querySeven(){
		return cityService.querySeven();
	}
	
	@GetMapping("/query/8")
	public List<Object[]> queryEight(){
		return cityService.queryEight();
	}
}

