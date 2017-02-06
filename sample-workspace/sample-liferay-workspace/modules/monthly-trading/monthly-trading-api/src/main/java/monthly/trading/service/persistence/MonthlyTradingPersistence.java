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

package monthly.trading.service.persistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

import monthly.trading.exception.NoSuchMonthlyTradingException;

import monthly.trading.model.MonthlyTrading;

/**
 * The persistence interface for the monthly trading service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see monthly.trading.service.persistence.impl.MonthlyTradingPersistenceImpl
 * @see MonthlyTradingUtil
 * @generated
 */
@ProviderType
public interface MonthlyTradingPersistence extends BasePersistence<MonthlyTrading> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link MonthlyTradingUtil} to access the monthly trading persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the monthly tradings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByUuid(java.lang.String uuid);

	/**
	* Returns a range of all the monthly tradings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @return the range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByUuid(java.lang.String uuid,
		int start, int end);

	/**
	* Returns an ordered range of all the monthly tradings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns an ordered range of all the monthly tradings where uuid = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByUuid(java.lang.String uuid,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first monthly trading in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public MonthlyTrading findByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the first monthly trading in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public MonthlyTrading fetchByUuid_First(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns the last monthly trading in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public MonthlyTrading findByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the last monthly trading in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public MonthlyTrading fetchByUuid_Last(java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns the monthly tradings before and after the current monthly trading in the ordered set where uuid = &#63;.
	*
	* @param monthlyTradingId the primary key of the current monthly trading
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly trading
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public MonthlyTrading[] findByUuid_PrevAndNext(long monthlyTradingId,
		java.lang.String uuid,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Removes all the monthly tradings where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public void removeByUuid(java.lang.String uuid);

	/**
	* Returns the number of monthly tradings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching monthly tradings
	*/
	public int countByUuid(java.lang.String uuid);

	/**
	* Returns the monthly trading where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMonthlyTradingException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public MonthlyTrading findByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the monthly trading where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public MonthlyTrading fetchByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns the monthly trading where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public MonthlyTrading fetchByUUID_G(java.lang.String uuid, long groupId,
		boolean retrieveFromCache);

	/**
	* Removes the monthly trading where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the monthly trading that was removed
	*/
	public MonthlyTrading removeByUUID_G(java.lang.String uuid, long groupId)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the number of monthly tradings where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching monthly tradings
	*/
	public int countByUUID_G(java.lang.String uuid, long groupId);

	/**
	* Returns all the monthly tradings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByUuid_C(java.lang.String uuid,
		long companyId);

	/**
	* Returns a range of all the monthly tradings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @return the range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end);

	/**
	* Returns an ordered range of all the monthly tradings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns an ordered range of all the monthly tradings where uuid = &#63; and companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public MonthlyTrading findByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the first monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public MonthlyTrading fetchByUuid_C_First(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns the last monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public MonthlyTrading findByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the last monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public MonthlyTrading fetchByUuid_C_Last(java.lang.String uuid,
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns the monthly tradings before and after the current monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param monthlyTradingId the primary key of the current monthly trading
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly trading
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public MonthlyTrading[] findByUuid_C_PrevAndNext(long monthlyTradingId,
		java.lang.String uuid, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Removes all the monthly tradings where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public void removeByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns the number of monthly tradings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching monthly tradings
	*/
	public int countByUuid_C(java.lang.String uuid, long companyId);

	/**
	* Returns all the monthly tradings where year = &#63;.
	*
	* @param year the year
	* @return the matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByYear(int year);

	/**
	* Returns a range of all the monthly tradings where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @return the range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByYear(int year, int start,
		int end);

	/**
	* Returns an ordered range of all the monthly tradings where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByYear(int year, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns an ordered range of all the monthly tradings where year = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param year the year
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching monthly tradings
	*/
	public java.util.List<MonthlyTrading> findByYear(int year, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first monthly trading in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public MonthlyTrading findByYear_First(int year,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the first monthly trading in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public MonthlyTrading fetchByYear_First(int year,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns the last monthly trading in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public MonthlyTrading findByYear_Last(int year,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the last monthly trading in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public MonthlyTrading fetchByYear_Last(int year,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns the monthly tradings before and after the current monthly trading in the ordered set where year = &#63;.
	*
	* @param monthlyTradingId the primary key of the current monthly trading
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly trading
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public MonthlyTrading[] findByYear_PrevAndNext(long monthlyTradingId,
		int year,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException;

	/**
	* Removes all the monthly tradings where year = &#63; from the database.
	*
	* @param year the year
	*/
	public void removeByYear(int year);

	/**
	* Returns the number of monthly tradings where year = &#63;.
	*
	* @param year the year
	* @return the number of matching monthly tradings
	*/
	public int countByYear(int year);

	/**
	* Caches the monthly trading in the entity cache if it is enabled.
	*
	* @param monthlyTrading the monthly trading
	*/
	public void cacheResult(MonthlyTrading monthlyTrading);

	/**
	* Caches the monthly tradings in the entity cache if it is enabled.
	*
	* @param monthlyTradings the monthly tradings
	*/
	public void cacheResult(java.util.List<MonthlyTrading> monthlyTradings);

	/**
	* Creates a new monthly trading with the primary key. Does not add the monthly trading to the database.
	*
	* @param monthlyTradingId the primary key for the new monthly trading
	* @return the new monthly trading
	*/
	public MonthlyTrading create(long monthlyTradingId);

	/**
	* Removes the monthly trading with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monthlyTradingId the primary key of the monthly trading
	* @return the monthly trading that was removed
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public MonthlyTrading remove(long monthlyTradingId)
		throws NoSuchMonthlyTradingException;

	public MonthlyTrading updateImpl(MonthlyTrading monthlyTrading);

	/**
	* Returns the monthly trading with the primary key or throws a {@link NoSuchMonthlyTradingException} if it could not be found.
	*
	* @param monthlyTradingId the primary key of the monthly trading
	* @return the monthly trading
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public MonthlyTrading findByPrimaryKey(long monthlyTradingId)
		throws NoSuchMonthlyTradingException;

	/**
	* Returns the monthly trading with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param monthlyTradingId the primary key of the monthly trading
	* @return the monthly trading, or <code>null</code> if a monthly trading with the primary key could not be found
	*/
	public MonthlyTrading fetchByPrimaryKey(long monthlyTradingId);

	@Override
	public java.util.Map<java.io.Serializable, MonthlyTrading> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the monthly tradings.
	*
	* @return the monthly tradings
	*/
	public java.util.List<MonthlyTrading> findAll();

	/**
	* Returns a range of all the monthly tradings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @return the range of monthly tradings
	*/
	public java.util.List<MonthlyTrading> findAll(int start, int end);

	/**
	* Returns an ordered range of all the monthly tradings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of monthly tradings
	*/
	public java.util.List<MonthlyTrading> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator);

	/**
	* Returns an ordered range of all the monthly tradings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of monthly tradings
	*/
	public java.util.List<MonthlyTrading> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the monthly tradings from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of monthly tradings.
	*
	* @return the number of monthly tradings
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}