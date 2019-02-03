package com.airFlights.common;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class TimeProvider {

	private static final long serialVersionUID = -3301695478208950415L;

    public Date now() {
        return new Date();
    }
}
