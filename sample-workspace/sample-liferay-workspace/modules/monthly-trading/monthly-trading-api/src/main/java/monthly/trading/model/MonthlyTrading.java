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

package monthly.trading.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the MonthlyTrading service. Represents a row in the &quot;Banking_MonthlyTrading&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTradingModel
 * @see monthly.trading.model.impl.MonthlyTradingImpl
 * @see monthly.trading.model.impl.MonthlyTradingModelImpl
 * @generated
 */
@ImplementationClassName("monthly.trading.model.impl.MonthlyTradingImpl")
@ProviderType
public interface MonthlyTrading extends MonthlyTradingModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link monthly.trading.model.impl.MonthlyTradingImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<MonthlyTrading, Long> MONTHLY_TRADING_ID_ACCESSOR =
		new Accessor<MonthlyTrading, Long>() {
			@Override
			public Long get(MonthlyTrading monthlyTrading) {
				return monthlyTrading.getMonthlyTradingId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<MonthlyTrading> getTypeClass() {
				return MonthlyTrading.class;
			}
		};
}