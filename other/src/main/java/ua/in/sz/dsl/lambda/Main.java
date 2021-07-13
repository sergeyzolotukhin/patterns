package ua.in.sz.dsl.lambda;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.joda.time.DateTime;
import org.joda.time.Period;
import org.kie.soup.commons.util.Maps;
import ua.in.sz.dsl.modle.Schedule;
import ua.in.sz.dsl.modle.ValueSchedule;

import java.util.Collections;

/*
A name in the plural form IntegrationFlow[s] is return builder IntegrationFlow[Builder].

SourcePollingChannelAdapter[Spec] ->
The base class is the definition IntegrationFlow[Definition] of all builder.

 */
@Slf4j
public class Main {
    public static void main(String[] args) {
        DateTime date = DateTime.now();

        ValueSchedule valuesOfA = ValueSchedule.builder()
                .code("A")
                .values(Lists.newArrayList("0", "1", "2"))
                .start(date.withTimeAtStartOfDay())
                .end(date.withTimeAtStartOfDay().plusDays(1))
                .resolution(Period.parse("PT5M"))
                .build();

        ValueSchedule valuesOfB = ValueSchedule.builder()
                .code("B")
                .values(Lists.newArrayList("0", "1", "2"))
                .start(date.withTimeAtStartOfDay())
                .end(date.withTimeAtStartOfDay().plusDays(1))
                .resolution(Period.parse("PT5M"))
                .build();

        Schedule schedule = Schedule.builder()
                .start(date.withTimeAtStartOfDay())
                .end(date.withTimeAtStartOfDay().plusDays(1))
                .resolution(Period.parse("PT5M"))
                .values(Lists.newArrayList(valuesOfA, valuesOfB))
                .build();

        String value1 = schedule.getValue("A", date.withTimeAtStartOfDay().withMinuteOfHour(5));
        log.info("The value of [{}] is [{}]", "A", value1);
    }
}
