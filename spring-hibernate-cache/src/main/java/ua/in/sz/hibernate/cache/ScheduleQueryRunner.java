package ua.in.sz.hibernate.cache;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Service;
import ua.in.sz.hibernate.cache.impl.ScheduleService;

@Slf4j
@Service
public class ScheduleQueryRunner implements CommandLineRunner {
	private final ScheduleService scheduleService;

	public ScheduleQueryRunner(ScheduleService scheduleService) {
		this.scheduleService = scheduleService;
	}

	@Override
	public void run(String... args) {
//		for (int i = 0; i < 100_000; i++) {
//			scheduleFilterDao.save(ScheduleEntity.builder().name(getClass().getCanonicalName() + " " + i).build());
//		}

		scheduleService.query();
	}
}
