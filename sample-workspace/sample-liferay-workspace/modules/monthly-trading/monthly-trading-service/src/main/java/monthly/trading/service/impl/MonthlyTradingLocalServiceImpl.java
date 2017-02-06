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

package monthly.trading.service.impl;

import java.util.List;

import aQute.bnd.annotation.ProviderType;
import monthly.trading.model.MonthlyTrading;
import monthly.trading.service.base.MonthlyTradingLocalServiceBaseImpl;

/**
 * The implementation of the monthly trading local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link monthly.trading.service.MonthlyTradingLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTradingLocalServiceBaseImpl
 * @see monthly.trading.service.MonthlyTradingLocalServiceUtil
 */
@ProviderType
public class MonthlyTradingLocalServiceImpl
	extends MonthlyTradingLocalServiceBaseImpl {

	public MonthlyTrading addMonthlyTrading(int year, int month, int volume) {

		long pk = counterLocalService.increment();
		MonthlyTrading monthlyTrading = monthlyTradingPersistence.create(pk);
		monthlyTrading.setYear(year);
		monthlyTrading.setMonth(month);
		monthlyTrading.setVolume(volume);

		return monthlyTradingPersistence.update(monthlyTrading);

	}

	public List<MonthlyTrading> getMonthlyTradingByYear(int year) {
		return monthlyTradingPersistence.findByYear(year);
	}
}