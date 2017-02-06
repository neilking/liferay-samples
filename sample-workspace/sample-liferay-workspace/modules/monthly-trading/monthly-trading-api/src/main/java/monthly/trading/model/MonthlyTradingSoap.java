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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link monthly.trading.service.http.MonthlyTradingServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see monthly.trading.service.http.MonthlyTradingServiceSoap
 * @generated
 */
@ProviderType
public class MonthlyTradingSoap implements Serializable {
	public static MonthlyTradingSoap toSoapModel(MonthlyTrading model) {
		MonthlyTradingSoap soapModel = new MonthlyTradingSoap();

		soapModel.setUuid(model.getUuid());
		soapModel.setMonthlyTradingId(model.getMonthlyTradingId());
		soapModel.setGroupId(model.getGroupId());
		soapModel.setCompanyId(model.getCompanyId());
		soapModel.setUserId(model.getUserId());
		soapModel.setUserName(model.getUserName());
		soapModel.setCreateDate(model.getCreateDate());
		soapModel.setModifiedDate(model.getModifiedDate());
		soapModel.setYear(model.getYear());
		soapModel.setMonth(model.getMonth());
		soapModel.setVolume(model.getVolume());

		return soapModel;
	}

	public static MonthlyTradingSoap[] toSoapModels(MonthlyTrading[] models) {
		MonthlyTradingSoap[] soapModels = new MonthlyTradingSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static MonthlyTradingSoap[][] toSoapModels(MonthlyTrading[][] models) {
		MonthlyTradingSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new MonthlyTradingSoap[models.length][models[0].length];
		}
		else {
			soapModels = new MonthlyTradingSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static MonthlyTradingSoap[] toSoapModels(List<MonthlyTrading> models) {
		List<MonthlyTradingSoap> soapModels = new ArrayList<MonthlyTradingSoap>(models.size());

		for (MonthlyTrading model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new MonthlyTradingSoap[soapModels.size()]);
	}

	public MonthlyTradingSoap() {
	}

	public long getPrimaryKey() {
		return _monthlyTradingId;
	}

	public void setPrimaryKey(long pk) {
		setMonthlyTradingId(pk);
	}

	public String getUuid() {
		return _uuid;
	}

	public void setUuid(String uuid) {
		_uuid = uuid;
	}

	public long getMonthlyTradingId() {
		return _monthlyTradingId;
	}

	public void setMonthlyTradingId(long monthlyTradingId) {
		_monthlyTradingId = monthlyTradingId;
	}

	public long getGroupId() {
		return _groupId;
	}

	public void setGroupId(long groupId) {
		_groupId = groupId;
	}

	public long getCompanyId() {
		return _companyId;
	}

	public void setCompanyId(long companyId) {
		_companyId = companyId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getUserName() {
		return _userName;
	}

	public void setUserName(String userName) {
		_userName = userName;
	}

	public Date getCreateDate() {
		return _createDate;
	}

	public void setCreateDate(Date createDate) {
		_createDate = createDate;
	}

	public Date getModifiedDate() {
		return _modifiedDate;
	}

	public void setModifiedDate(Date modifiedDate) {
		_modifiedDate = modifiedDate;
	}

	public int getYear() {
		return _year;
	}

	public void setYear(int year) {
		_year = year;
	}

	public int getMonth() {
		return _month;
	}

	public void setMonth(int month) {
		_month = month;
	}

	public int getVolume() {
		return _volume;
	}

	public void setVolume(int volume) {
		_volume = volume;
	}

	private String _uuid;
	private long _monthlyTradingId;
	private long _groupId;
	private long _companyId;
	private long _userId;
	private String _userName;
	private Date _createDate;
	private Date _modifiedDate;
	private int _year;
	private int _month;
	private int _volume;
}