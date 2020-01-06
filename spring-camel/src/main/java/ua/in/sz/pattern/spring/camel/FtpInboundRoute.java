package ua.in.sz.pattern.spring.camel;

import lombok.extern.slf4j.Slf4j;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class FtpInboundRoute extends RouteBuilder {
	@Override
	public void configure() {
		from("timer:foo").to("log:" + getClass().getName());
	}
}
