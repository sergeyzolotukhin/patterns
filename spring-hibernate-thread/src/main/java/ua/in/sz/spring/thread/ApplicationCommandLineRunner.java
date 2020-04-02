package ua.in.sz.spring.thread;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import ua.in.sz.spring.thread.entity.ScheduleEntity;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;

@Slf4j
@Getter
@Component
@RequiredArgsConstructor
public class ApplicationCommandLineRunner implements CommandLineRunner {

	private final EntityManager entityManager;

	@Override
	public void run(String...args) {
		long count = countEntity();
		log.info("Entity count {}", count);
	}

	private long countEntity() {
		CriteriaBuilder cb = getEntityManager().getCriteriaBuilder();
		CriteriaQuery<Long> cq = cb.createQuery(Long.class);
		CriteriaQuery<Long> query = cq.select(cb.count(cq.from(ScheduleEntity.class)));

		return getEntityManager().createQuery(query).getSingleResult();
	}
}