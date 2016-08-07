package com.redhat.examples.broker;

import java.net.UnknownHostException;

import org.apache.activemq.broker.PublishedAddressPolicy;
import org.apache.log4j.Logger;

public class PublishedAddressPolicyHostnameConfig extends PublishedAddressPolicy {

	private String hostname;
	
	private Logger logger = Logger.getLogger(PublishedAddressPolicyHostnameConfig.class.getName());
	
	public void setHostname(String hostname) {
		logger.trace("using configured hostname for published address policy: " + hostname);
		this.hostname = hostname;
	}
	
	public String getHostname() {
		return hostname;
	}
	
	@Override
	protected String getPublishedHostValue(String val) throws UnknownHostException {
		return (hostname == null) ? super.getPublishedHostValue(val) : hostname;
	}
	
}
