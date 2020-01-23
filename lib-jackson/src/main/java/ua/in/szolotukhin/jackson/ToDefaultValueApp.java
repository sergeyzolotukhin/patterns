package ua.in.szolotukhin.jackson;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import ua.in.szolotukhin.jackson.model.RowDataProvider;
import ua.in.szolotukhin.jackson.model.SchedulesRowDataProvider;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

@Slf4j
public class ToDefaultValueApp {

	public static final String BASE_PATH = "lib-jackson/src/main/resources";
	public static final String DEFAULT = "provider-default-version.json";
	public static final String ALL = "provider-all.json";

	public static void main(String[] args) throws IOException {
		ObjectMapper mapper = MapperFactory.createMapper();

		String json = Files.readString(Paths.get(BASE_PATH, DEFAULT));

		RowDataProvider provider = mapper.readValue(json, RowDataProvider.class);

		log.info("{}", provider);
	}
}