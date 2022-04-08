package com.restser.controllers;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/restaurant")
public class RestaurantController {

	/*@Autowired
	private RestaurantRepository repo;
	
	@GetMapping
	List<Restaurant> getList(){
		return repo.findAll();
	}
	@PostMapping
	public void setRestaurante(@RequestBody Restaurant rest) {
		repo.save(rest);
	}
	@PutMapping
	public void updateRestaurante(@RequestBody Restaurant rest) {
		repo.save(rest);
	}
	@DeleteMapping(value="/{id}")
	public void deleteRestaurante(@PathVariable("id") Long id) {
		repo.deleteById(id);
	}	*/
}
