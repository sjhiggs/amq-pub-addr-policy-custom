/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.redhat.examples.broker;

import java.net.UnknownHostException;
import org.apache.activemq.broker.PublishedAddressPolicy;
import org.apache.log4j.Logger;

/**
 * Allows the broker's hostname to be configured. If a hostname is configured,
 * it will be used, otherwise the policy will revert to the default behavior
 * found in PublishedAddressPolicy.
 */
public class PublishedAddressPolicyHostnameConfig extends PublishedAddressPolicy {

    private String hostname;

    private Logger logger = Logger.getLogger(PublishedAddressPolicyHostnameConfig.class.getName());

    /**
     * Set/Configure the hostname to be returned by the broker when publishing
     * the broker's hostname.
     * 
     * @param hostname
     *            The user-specified hostname to be published
     */
    public void setHostname(String hostname) {
        logger.trace("using configured hostname for published address policy: " + hostname);
        this.hostname = hostname;
    }

    /**
     * @return a String hostname value if one was configured, null otherwise
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * Returns the configured hostname, or reverts to the parent's default
     * behavior if a hostname has not been configured.
     */
    protected String getPublishedHostValue(String val) throws UnknownHostException {
        return (hostname == null) ? super.getPublishedHostValue(val) : hostname;
    }

}
