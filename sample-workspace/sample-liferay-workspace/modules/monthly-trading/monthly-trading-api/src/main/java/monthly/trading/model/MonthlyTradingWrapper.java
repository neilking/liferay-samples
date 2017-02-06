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

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.exportimport.kernel.lar.StagedModelType;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link MonthlyTrading}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTrading
 * @generated
 */
@ProviderType
public class MonthlyTradingWrapper implements MonthlyTrading,
	ModelWrapper<MonthlyTrading> {
	public MonthlyTradingWrapper(MonthlyTrading monthlyTrading) {
		_monthlyTrading = monthlyTrading;
	}

	@Override
	public Class<?> getModelClass() {
		return MonthlyTrading.class;
	}

	@Override
	public String getModelClassName() {
		return MonthlyTrading.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("uuid", getUuid());
		attributes.put("monthlyTradingId", getMonthlyTradingId());
		attributes.put("groupId", getGroupId());
		attributes.put("companyId", getCompanyId());
		attributes.put("userId", getUserId());
		attributes.put("userName", getUserName());
		attributes.put("createDate", getCreateDate());
		attributes.put("modifiedDate", getModifiedDate());
		attributes.put("year", getYear());
		attributes.put("month", getMonth());
		attributes.put("volume", getVolume());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String uuid = (String)attributes.get("uuid");

		if (uuid != null) {
			setUuid(uuid);
		}

		Long monthlyTradingId = (Long)attributes.get("monthlyTradingId");

		if (monthlyTradingId != null) {
			setMonthlyTradingId(monthlyTradingId);
		}

		Long groupId = (Long)attributes.get("groupId");

		if (groupId != null) {
			setGroupId(groupId);
		}

		Long companyId = (Long)attributes.get("companyId");

		if (companyId != null) {
			setCompanyId(companyId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String userName = (String)attributes.get("userName");

		if (userName != null) {
			setUserName(userName);
		}

		Date createDate = (Date)attributes.get("createDate");

		if (createDate != null) {
			setCreateDate(createDate);
		}

		Date modifiedDate = (Date)attributes.get("modifiedDate");

		if (modifiedDate != null) {
			setModifiedDate(modifiedDate);
		}

		Integer year = (Integer)attributes.get("year");

		if (year != null) {
			setYear(year);
		}

		Integer month = (Integer)attributes.get("month");

		if (month != null) {
			setMonth(month);
		}

		Integer volume = (Integer)attributes.get("volume");

		if (volume != null) {
			setVolume(volume);
		}
	}

	@Override
	public boolean isCachedModel() {
		return _monthlyTrading.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _monthlyTrading.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _monthlyTrading.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _monthlyTrading.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<monthly.trading.model.MonthlyTrading> toCacheModel() {
		return _monthlyTrading.toCacheModel();
	}

	@Override
	public int compareTo(monthly.trading.model.MonthlyTrading monthlyTrading) {
		return _monthlyTrading.compareTo(monthlyTrading);
	}

	/**
	* Returns the month of this monthly trading.
	*
	* @return the month of this monthly trading
	*/
	@Override
	public int getMonth() {
		return _monthlyTrading.getMonth();
	}

	/**
	* Returns the volume of this monthly trading.
	*
	* @return the volume of this monthly trading
	*/
	@Override
	public int getVolume() {
		return _monthlyTrading.getVolume();
	}

	/**
	* Returns the year of this monthly trading.
	*
	* @return the year of this monthly trading
	*/
	@Override
	public int getYear() {
		return _monthlyTrading.getYear();
	}

	@Override
	public int hashCode() {
		return _monthlyTrading.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _monthlyTrading.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new MonthlyTradingWrapper((MonthlyTrading)_monthlyTrading.clone());
	}

	/**
	* Returns the user name of this monthly trading.
	*
	* @return the user name of this monthly trading
	*/
	@Override
	public java.lang.String getUserName() {
		return _monthlyTrading.getUserName();
	}

	/**
	* Returns the user uuid of this monthly trading.
	*
	* @return the user uuid of this monthly trading
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _monthlyTrading.getUserUuid();
	}

	/**
	* Returns the uuid of this monthly trading.
	*
	* @return the uuid of this monthly trading
	*/
	@Override
	public java.lang.String getUuid() {
		return _monthlyTrading.getUuid();
	}

	@Override
	public java.lang.String toString() {
		return _monthlyTrading.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _monthlyTrading.toXmlString();
	}

	/**
	* Returns the create date of this monthly trading.
	*
	* @return the create date of this monthly trading
	*/
	@Override
	public Date getCreateDate() {
		return _monthlyTrading.getCreateDate();
	}

	/**
	* Returns the modified date of this monthly trading.
	*
	* @return the modified date of this monthly trading
	*/
	@Override
	public Date getModifiedDate() {
		return _monthlyTrading.getModifiedDate();
	}

	/**
	* Returns the company ID of this monthly trading.
	*
	* @return the company ID of this monthly trading
	*/
	@Override
	public long getCompanyId() {
		return _monthlyTrading.getCompanyId();
	}

	/**
	* Returns the group ID of this monthly trading.
	*
	* @return the group ID of this monthly trading
	*/
	@Override
	public long getGroupId() {
		return _monthlyTrading.getGroupId();
	}

	/**
	* Returns the monthly trading ID of this monthly trading.
	*
	* @return the monthly trading ID of this monthly trading
	*/
	@Override
	public long getMonthlyTradingId() {
		return _monthlyTrading.getMonthlyTradingId();
	}

	/**
	* Returns the primary key of this monthly trading.
	*
	* @return the primary key of this monthly trading
	*/
	@Override
	public long getPrimaryKey() {
		return _monthlyTrading.getPrimaryKey();
	}

	/**
	* Returns the user ID of this monthly trading.
	*
	* @return the user ID of this monthly trading
	*/
	@Override
	public long getUserId() {
		return _monthlyTrading.getUserId();
	}

	@Override
	public monthly.trading.model.MonthlyTrading toEscapedModel() {
		return new MonthlyTradingWrapper(_monthlyTrading.toEscapedModel());
	}

	@Override
	public monthly.trading.model.MonthlyTrading toUnescapedModel() {
		return new MonthlyTradingWrapper(_monthlyTrading.toUnescapedModel());
	}

	@Override
	public void persist() {
		_monthlyTrading.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_monthlyTrading.setCachedModel(cachedModel);
	}

	/**
	* Sets the company ID of this monthly trading.
	*
	* @param companyId the company ID of this monthly trading
	*/
	@Override
	public void setCompanyId(long companyId) {
		_monthlyTrading.setCompanyId(companyId);
	}

	/**
	* Sets the create date of this monthly trading.
	*
	* @param createDate the create date of this monthly trading
	*/
	@Override
	public void setCreateDate(Date createDate) {
		_monthlyTrading.setCreateDate(createDate);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_monthlyTrading.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_monthlyTrading.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_monthlyTrading.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the group ID of this monthly trading.
	*
	* @param groupId the group ID of this monthly trading
	*/
	@Override
	public void setGroupId(long groupId) {
		_monthlyTrading.setGroupId(groupId);
	}

	/**
	* Sets the modified date of this monthly trading.
	*
	* @param modifiedDate the modified date of this monthly trading
	*/
	@Override
	public void setModifiedDate(Date modifiedDate) {
		_monthlyTrading.setModifiedDate(modifiedDate);
	}

	/**
	* Sets the month of this monthly trading.
	*
	* @param month the month of this monthly trading
	*/
	@Override
	public void setMonth(int month) {
		_monthlyTrading.setMonth(month);
	}

	/**
	* Sets the monthly trading ID of this monthly trading.
	*
	* @param monthlyTradingId the monthly trading ID of this monthly trading
	*/
	@Override
	public void setMonthlyTradingId(long monthlyTradingId) {
		_monthlyTrading.setMonthlyTradingId(monthlyTradingId);
	}

	@Override
	public void setNew(boolean n) {
		_monthlyTrading.setNew(n);
	}

	/**
	* Sets the primary key of this monthly trading.
	*
	* @param primaryKey the primary key of this monthly trading
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_monthlyTrading.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_monthlyTrading.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the user ID of this monthly trading.
	*
	* @param userId the user ID of this monthly trading
	*/
	@Override
	public void setUserId(long userId) {
		_monthlyTrading.setUserId(userId);
	}

	/**
	* Sets the user name of this monthly trading.
	*
	* @param userName the user name of this monthly trading
	*/
	@Override
	public void setUserName(java.lang.String userName) {
		_monthlyTrading.setUserName(userName);
	}

	/**
	* Sets the user uuid of this monthly trading.
	*
	* @param userUuid the user uuid of this monthly trading
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_monthlyTrading.setUserUuid(userUuid);
	}

	/**
	* Sets the uuid of this monthly trading.
	*
	* @param uuid the uuid of this monthly trading
	*/
	@Override
	public void setUuid(java.lang.String uuid) {
		_monthlyTrading.setUuid(uuid);
	}

	/**
	* Sets the volume of this monthly trading.
	*
	* @param volume the volume of this monthly trading
	*/
	@Override
	public void setVolume(int volume) {
		_monthlyTrading.setVolume(volume);
	}

	/**
	* Sets the year of this monthly trading.
	*
	* @param year the year of this monthly trading
	*/
	@Override
	public void setYear(int year) {
		_monthlyTrading.setYear(year);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof MonthlyTradingWrapper)) {
			return false;
		}

		MonthlyTradingWrapper monthlyTradingWrapper = (MonthlyTradingWrapper)obj;

		if (Objects.equals(_monthlyTrading,
					monthlyTradingWrapper._monthlyTrading)) {
			return true;
		}

		return false;
	}

	@Override
	public StagedModelType getStagedModelType() {
		return _monthlyTrading.getStagedModelType();
	}

	@Override
	public MonthlyTrading getWrappedModel() {
		return _monthlyTrading;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _monthlyTrading.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _monthlyTrading.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_monthlyTrading.resetOriginalValues();
	}

	private final MonthlyTrading _monthlyTrading;
}