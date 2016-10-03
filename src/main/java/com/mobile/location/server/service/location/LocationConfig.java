package com.mobile.location.server.service.location;

import java.math.BigDecimal;

import org.springframework.jmx.export.annotation.ManagedResource;

/**
 * 
 * @author sqs
 *
 */
@ManagedResource
public class LocationConfig {

	private BigDecimal reward;

	public BigDecimal getReward() {
		return reward;
	}

	public void setReward(BigDecimal reward) {
		this.reward = reward;
	}

}
