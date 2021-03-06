/**
 * The contents of this file are subject to the OpenMRS Public License
 * Version 1.0 (the "License"); you may not use this file except in
 * compliance with the License. You may obtain a copy of the License at
 * http://license.openmrs.org
 *
 * Software distributed under the License is distributed on an "AS IS"
 * basis, WITHOUT WARRANTY OF ANY KIND, either express or implied. See the
 * License for the specific language governing rights and limitations
 * under the License.
 *
 * Copyright (C) OpenMRS, LLC.  All Rights Reserved.
 */
package org.openmrs.web.test;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.support.AbstractContextLoader;

/**
 * The only reason why i created this class is to be able to create an application context which can
 * be refreshed multiple times, unlike the default GenericApplicationContext which can be refreshed
 * only once. This class is used for @ContextConfiguration in WebModuleActivatorTest
 */
public class TestContextLoader extends AbstractContextLoader {
	
	public TestContextLoader() {
	}
	
	@Override
	public final ConfigurableApplicationContext loadContext(String... locations) throws Exception {
		return new ClassPathXmlApplicationContext(locations);
	}
	
	@Override
	protected String getResourceSuffix() {
		return "-context.xml";
	}
}
