package home.demo.ws.web.api;

import java.util.Collection;
import java.util.HashMap;

import javax.ws.rs.ApplicationPath;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import home.demo.ws.model.GreetingDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class GreetingController {
	
	private static int nextId;
	private static HashMap<Integer, GreetingDto> greetingRepository;
	
	private static void save(GreetingDto g) {
		if (greetingRepository == null) {
			greetingRepository = new HashMap<>();
			nextId = 1;
		}
		g.setId(nextId++);
		greetingRepository.put(g.getId(), g);
	}
	
	static {
		GreetingDto g1 = new GreetingDto();
		g1.setText("hello");
		save(g1);
		
		GreetingDto g2 = new GreetingDto();
		g2.setText("goodbye");
		save(g2);
	}
	
	@ApiOperation(value="Get all greetings",
			response=GreetingDto.class,
			responseContainer="List")
	@RequestMapping(value="/api/greetings", 
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Collection<GreetingDto>> getGreetings() {
		Collection<GreetingDto> greetings = greetingRepository.values();
		return new ResponseEntity<Collection<GreetingDto>>(greetings, HttpStatus.OK);
	}
}
