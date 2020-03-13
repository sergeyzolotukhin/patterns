package ua.in.sz.camel;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.AggregationStrategy;
import org.apache.camel.Exchange;
import org.apache.camel.Predicate;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;

import java.util.Objects;

import static java.util.Objects.isNull;

@Slf4j
public class FtpRouteBuilder extends RouteBuilder {
	@Override
	public void configure() throws Exception {
		onException(IllegalStateException.class)
				.log("illegal")
		.logExhausted(false);
		//.setHeader("status", constant("failed-1"));

		onException(RuntimeException.class)
				.log("runtime")
				.logExhausted(false);

		from("direct:start")
				.multicast(new AtLeastOneSuccessAggregationStrategy())
				.to("bean:ftp-1?method=send")
				.to("bean:ftp-2?method=send")
				.to("bean:ftp-3?method=send")
				.to("bean:ftp-4?method=send")
				.end()
				.to("bean:completed?method=send");
	}
}
