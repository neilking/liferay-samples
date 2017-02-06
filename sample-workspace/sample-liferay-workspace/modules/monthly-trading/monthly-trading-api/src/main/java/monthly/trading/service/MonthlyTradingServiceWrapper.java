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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link MonthlyTradingService}.
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTradingService
 * @generated
 */
@ProviderType
public class MonthlyTradingServiceWrapper implements MonthlyTradingService,
	ServiceWrapper<MonthlyTradingService> {
	public MonthlyTradingServiceWrapper(
		MonthlyTradingService monthlyTradingService) {
		_monthlyTradingService = monthlyTradingService;
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _monthlyTradingService.getOSGiServiceIdentifier();
	}

	@Override
	public java.util.List<monthly.trading.model.MonthlyTrading> getMonthlyTradingByYear(
		int year) {
		return _monthlyTradingService.getMonthlyTradingByYear(year);
	}

	@Override
	public monthly.trading.model.MonthlyTrading addMonthlyTrading(int year,
		int month, int volume) {
		return _monthlyTradingService.addMonthlyTrading(year, month, volume);
	}

	@Override
	public MonthlyTradingService getWrappedService() {
		return _monthlyTradingService;
	}

	@Override
	public void setWrappedService(MonthlyTradingService monthlyTradingService) {
		_monthlyTradingService = monthlyTradingService;
	}

	private MonthlyTradingService _monthlyTradingService;
}