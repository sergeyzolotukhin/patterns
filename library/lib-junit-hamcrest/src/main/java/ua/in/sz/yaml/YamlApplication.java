package ua.in.sz.yaml;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import lombok.extern.slf4j.Slf4j;
import ua.in.sz.json.BookDto;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
public class YamlApplication {
	public static void main(String[] args) throws IOException {
		YAMLFactory factory = YAMLFactory.builder()
				.enable(YAMLGenerator.Feature.MINIMIZE_QUOTES)
				.disable(YAMLGenerator.Feature.WRITE_DOC_START_MARKER)
				.build();

		ObjectMapper mapper = new ObjectMapper(factory);
		mapper.setDateFormat(new SimpleDateFormat("dd-MM-yyyy"));

		BookDto bookDto = BookDto.of("Book - 1", new Date());
		BookDto bookDto2 = BookDto.of("Book - 2", new Date());
		final List<BookDto> books = Arrays.asList(bookDto, bookDto2);
		log.info("to yaml:[{}]", mapper.writeValueAsString(books));

		BookDto bookDto1 = mapper.readValue("{ name: Book - 1, date: 11-11-2019 }", BookDto.class);
		log.info("from yaml: [{}]", bookDto1.getDate());


		Path path = Paths.get("src/main/resources", "books.yaml");
		List<BookDto> list = Arrays.asList(mapper.readValue(Files.newInputStream(path), BookDto[].class));
		list.forEach(book -> log.info("{}", book.getName()));
	}
}
