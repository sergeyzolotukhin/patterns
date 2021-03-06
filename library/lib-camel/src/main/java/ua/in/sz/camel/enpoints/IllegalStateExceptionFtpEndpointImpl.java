package ua.in.sz.camel.enpoints;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IllegalStateExceptionFtpEndpointImpl implements FtpEndpoint {
	private final String name;

	public IllegalStateExceptionFtpEndpointImpl(String name) {
		this.name = name;
	}

	@Override
	public String send(String message) {
		String result = String.format("%s: [%s]", name, message);

		log.info("{}", result);

		throw new IllegalStateException(String.format("exception: %s", result));
	}
}