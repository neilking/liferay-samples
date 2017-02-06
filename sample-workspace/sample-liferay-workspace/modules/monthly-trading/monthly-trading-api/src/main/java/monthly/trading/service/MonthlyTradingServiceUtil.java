/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package monthly.trading.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the remote service utility for MonthlyTrading. This utility wraps
 * {@link monthly.trading.service.impl.MonthlyTradingServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTradingService
 * @see monthly.trading.service.base.MonthlyTradingServiceBaseImpl
 * @see monthly.trading.service.impl.MonthlyTradingServiceImpl
 * @generated
 */
@ProviderType
public class MonthlyTradingServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link monthly.trading.service.impl.MonthlyTradingServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	public static java.util.List<monthly.trading.model.MonthlyTrading> getMonthlyTradingByYear(
		int year) {
		return getService().getMonthlyTradingByYear(year);
	}

	public static monthly.trading.model.MonthlyTrading addMonthlyTrading(
		int year, int month, int volume) {
		return getService().addMonthlyTrading(year, month, volume);
	}

	public static MonthlyTradingService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MonthlyTradingService, MonthlyTradingService> _serviceTracker =
		ServiceTrackerFactory.open(MonthlyTradingService.class);
}