package ua.in.sz.hibernate.xml;

import ua.in.sz.hibernate.xml.impl.NumberScheduleValue;
import ua.in.sz.hibernate.xml.impl.Schedule;
import ua.in.sz.hibernate.xml.impl.StringScheduleValue;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class ScheduleGenerator {

    public static Schedule generate() {
        LocalDateTime startDate = LocalDateTime.now();

        Schedule schedule = Schedule.builder()
                .identification("Schedule 1")
                .startDate(startDate)
                .stopDate(startDate.plusDays(1))
                .build();

        List<NumberScheduleValue> numberValues = new ArrayList<>();
        List<StringScheduleValue> stringValues = new ArrayList<>();

        schedule.setNumberValueList(numberValues);
        schedule.setStringValueList(stringValues);

        for (int i = 0; i < 96; i++) {
            NumberScheduleValue number = NumberScheduleValue.builder()
                    .effectiveDay(startDate.plusMinutes(i * 15))
                    .terminationDay(startDate.plusMinutes((i + 1) * 15))
                    .value(BigDecimal.valueOf(1))
                    .schedule(schedule)
                    .build();

            numberValues.add(number);
        }

        for (int i = 0; i < 96; i++) {
            StringScheduleValue string = StringScheduleValue.builder()
                    .effectiveDay(startDate.plusMinutes(i * 15))
                    .terminationDay(startDate.plusMinutes((i + 1) * 15))
                    .value(String.format("One %d", i))
                    .schedule(schedule)
                    .build();

            stringValues.add(string);
        }

        return schedule;
    }
}
