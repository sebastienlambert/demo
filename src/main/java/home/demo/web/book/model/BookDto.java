package home.demo.web.book.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@ToString
public class BookDto {

	@Setter
	@Getter
	private List<String> authorNames;
	
	@Setter
	@Getter
	private String title;
	
	@Setter
	@Getter
	private String isin;
	
	
	@Setter
	@Getter
	private String category;

}
