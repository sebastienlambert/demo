package home.demo.web.book.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import home.demo.web.book.model.BookDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@Api
public class BookController {

	private static List<BookDto> books;

	static {
		books = new ArrayList<>();

		BookDto b1 = new BookDto();
		b1.setAuthorNames(Arrays.asList("Stephen Convey"));
		b1.setTitle("7 Habits of Highly Efficient People");
		b1.setCategory("Self-Improvement");
		b1.setIsin("A0123456");
		books.add(b1);

		BookDto b2 = new BookDto();
		b2.setAuthorNames(Arrays.asList("Chose La"));
		b2.setTitle("Happiness Advantage");
		b2.setCategory("Self-Improvement");
		b2.setIsin("B0123456");
		books.add(b2);
	}

	@ApiOperation(value="Get books",
			response=BookDto.class,
			responseContainer="List")
	@RequestMapping(value="/api/books", 
			method=RequestMethod.GET, 
			produces = MediaType.APPLICATION_JSON_VALUE) 
	public ResponseEntity<Collection<BookDto>> getBooks(
@RequestParam(required = false) String isin,
			@RequestParam(required = false) String author, @RequestParam(required = false) String category,
			@RequestParam(required = false) String title) {
		Collection<BookDto> filteredBooks = books.stream().filter(
				b -> (isin == null ? true : isin.equalsIgnoreCase(b.getIsin()))
				&& (author == null ? true : org.apache.commons.collections4.CollectionUtils.countMatches(b.getAuthorNames(), an -> an.equals(author)) > 0)
				&& (category == null ? true : category.equalsIgnoreCase(b.getCategory()))
						&& (title == null ? true : title.equalsIgnoreCase(b.getTitle())))
				.collect(Collectors.toList());
		return new ResponseEntity<Collection<BookDto>>(filteredBooks, HttpStatus.OK);
	}
}
