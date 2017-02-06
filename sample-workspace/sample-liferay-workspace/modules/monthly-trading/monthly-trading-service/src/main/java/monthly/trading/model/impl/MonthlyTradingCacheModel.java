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

package monthly.trading.model.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import monthly.trading.model.MonthlyTrading;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing MonthlyTrading in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTrading
 * @generated
 */
@ProviderType
public class MonthlyTradingCacheModel implements CacheModel<MonthlyTrading>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MonthlyTradingCacheModel)) {
			return false;
		}

		MonthlyTradingCacheModel monthlyTradingCacheModel = (MonthlyTradingCacheModel)obj;

		if (monthlyTradingId == monthlyTradingCacheModel.monthlyTradingId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, monthlyTradingId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(23);

		sb.append("{uuid=");
		sb.append(uuid);
		sb.append(", monthlyTradingId=");
		sb.append(monthlyTradingId);
		sb.append(", groupId=");
		sb.append(groupId);
		sb.append(", companyId=");
		sb.append(companyId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", userName=");
		sb.append(userName);
		sb.append(", createDate=");
		sb.append(createDate);
		sb.append(", modifiedDate=");
		sb.append(modifiedDate);
		sb.append(", year=");
		sb.append(year);
		sb.append(", month=");
		sb.append(month);
		sb.append(", volume=");
		sb.append(volume);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public MonthlyTrading toEntityModel() {
		MonthlyTradingImpl monthlyTradingImpl = new MonthlyTradingImpl();

		if (uuid == null) {
			monthlyTradingImpl.setUuid(StringPool.BLANK);
		}
		else {
			monthlyTradingImpl.setUuid(uuid);
		}

		monthlyTradingImpl.setMonthlyTradingId(monthlyTradingId);
		monthlyTradingImpl.setGroupId(groupId);
		monthlyTradingImpl.setCompanyId(companyId);
		monthlyTradingImpl.setUserId(userId);

		if (userName == null) {
			monthlyTradingImpl.setUserName(StringPool.BLANK);
		}
		else {
			monthlyTradingImpl.setUserName(userName);
		}

		if (createDate == Long.MIN_VALUE) {
			monthlyTradingImpl.setCreateDate(null);
		}
		else {
			monthlyTradingImpl.setCreateDate(new Date(createDate));
		}

		if (modifiedDate == Long.MIN_VALUE) {
			monthlyTradingImpl.setModifiedDate(null);
		}
		else {
			monthlyTradingImpl.setModifiedDate(new Date(modifiedDate));
		}

		monthlyTradingImpl.setYear(year);
		monthlyTradingImpl.setMonth(month);
		monthlyTradingImpl.setVolume(volume);

		monthlyTradingImpl.resetOriginalValues();

		return monthlyTradingImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		uuid = objectInput.readUTF();

		monthlyTradingId = objectInput.readLong();

		groupId = objectInput.readLong();

		companyId = objectInput.readLong();

		userId = objectInput.readLong();
		userName = objectInput.readUTF();
		createDate = objectInput.readLong();
		modifiedDate = objectInput.readLong();

		year = objectInput.readInt();

		month = objectInput.readInt();

		volume = objectInput.readInt();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		if (uuid == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(uuid);
		}

		objectOutput.writeLong(monthlyTradingId);

		objectOutput.writeLong(groupId);

		objectOutput.writeLong(companyId);

		objectOutput.writeLong(userId);

		if (userName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(userName);
		}

		objectOutput.writeLong(createDate);
		objectOutput.writeLong(modifiedDate);

		objectOutput.writeInt(year);

		objectOutput.writeInt(month);

		objectOutput.writeInt(volume);
	}

	public String uuid;
	public long monthlyTradingId;
	public long groupId;
	public long companyId;
	public long userId;
	public String userName;
	public long createDate;
	public long modifiedDate;
	public int year;
	public int month;
	public int volume;
}