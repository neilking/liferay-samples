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

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import monthly.trading.model.MonthlyTrading;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the monthly trading service. This utility wraps {@link monthly.trading.service.persistence.impl.MonthlyTradingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTradingPersistence
 * @see monthly.trading.service.persistence.impl.MonthlyTradingPersistenceImpl
 * @generated
 */
@ProviderType
public class MonthlyTradingUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(MonthlyTrading monthlyTrading) {
		getPersistence().clearCache(monthlyTrading);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<MonthlyTrading> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<MonthlyTrading> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<MonthlyTrading> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static MonthlyTrading update(MonthlyTrading monthlyTrading) {
		return getPersistence().update(monthlyTrading);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static MonthlyTrading update(MonthlyTrading monthlyTrading,
		ServiceContext serviceContext) {
		return getPersistence().update(monthlyTrading, serviceContext);
	}

	/**
	* Returns all the monthly tradings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the matching monthly tradings
	*/
	public static List<MonthlyTrading> findByUuid(java.lang.String uuid) {
		return getPersistence().findByUuid(uuid);
	}

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
	public static List<MonthlyTrading> findByUuid(java.lang.String uuid,
		int start, int end) {
		return getPersistence().findByUuid(uuid, start, end);
	}

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
	public static List<MonthlyTrading> findByUuid(java.lang.String uuid,
		int start, int end, OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence().findByUuid(uuid, start, end, orderByComparator);
	}

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
	public static List<MonthlyTrading> findByUuid(java.lang.String uuid,
		int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid(uuid, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first monthly trading in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public static MonthlyTrading findByUuid_First(java.lang.String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence().findByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the first monthly trading in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static MonthlyTrading fetchByUuid_First(java.lang.String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence().fetchByUuid_First(uuid, orderByComparator);
	}

	/**
	* Returns the last monthly trading in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public static MonthlyTrading findByUuid_Last(java.lang.String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence().findByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the last monthly trading in the ordered set where uuid = &#63;.
	*
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static MonthlyTrading fetchByUuid_Last(java.lang.String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence().fetchByUuid_Last(uuid, orderByComparator);
	}

	/**
	* Returns the monthly tradings before and after the current monthly trading in the ordered set where uuid = &#63;.
	*
	* @param monthlyTradingId the primary key of the current monthly trading
	* @param uuid the uuid
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly trading
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public static MonthlyTrading[] findByUuid_PrevAndNext(
		long monthlyTradingId, java.lang.String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence()
				   .findByUuid_PrevAndNext(monthlyTradingId, uuid,
			orderByComparator);
	}

	/**
	* Removes all the monthly tradings where uuid = &#63; from the database.
	*
	* @param uuid the uuid
	*/
	public static void removeByUuid(java.lang.String uuid) {
		getPersistence().removeByUuid(uuid);
	}

	/**
	* Returns the number of monthly tradings where uuid = &#63;.
	*
	* @param uuid the uuid
	* @return the number of matching monthly tradings
	*/
	public static int countByUuid(java.lang.String uuid) {
		return getPersistence().countByUuid(uuid);
	}

	/**
	* Returns the monthly trading where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMonthlyTradingException} if it could not be found.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public static MonthlyTrading findByUUID_G(java.lang.String uuid,
		long groupId)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence().findByUUID_G(uuid, groupId);
	}

	/**
	* Returns the monthly trading where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static MonthlyTrading fetchByUUID_G(java.lang.String uuid,
		long groupId) {
		return getPersistence().fetchByUUID_G(uuid, groupId);
	}

	/**
	* Returns the monthly trading where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static MonthlyTrading fetchByUUID_G(java.lang.String uuid,
		long groupId, boolean retrieveFromCache) {
		return getPersistence().fetchByUUID_G(uuid, groupId, retrieveFromCache);
	}

	/**
	* Removes the monthly trading where uuid = &#63; and groupId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the monthly trading that was removed
	*/
	public static MonthlyTrading removeByUUID_G(java.lang.String uuid,
		long groupId)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence().removeByUUID_G(uuid, groupId);
	}

	/**
	* Returns the number of monthly tradings where uuid = &#63; and groupId = &#63;.
	*
	* @param uuid the uuid
	* @param groupId the group ID
	* @return the number of matching monthly tradings
	*/
	public static int countByUUID_G(java.lang.String uuid, long groupId) {
		return getPersistence().countByUUID_G(uuid, groupId);
	}

	/**
	* Returns all the monthly tradings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the matching monthly tradings
	*/
	public static List<MonthlyTrading> findByUuid_C(java.lang.String uuid,
		long companyId) {
		return getPersistence().findByUuid_C(uuid, companyId);
	}

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
	public static List<MonthlyTrading> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end) {
		return getPersistence().findByUuid_C(uuid, companyId, start, end);
	}

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
	public static List<MonthlyTrading> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end, orderByComparator);
	}

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
	public static List<MonthlyTrading> findByUuid_C(java.lang.String uuid,
		long companyId, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByUuid_C(uuid, companyId, start, end,
			orderByComparator, retrieveFromCache);
	}

	/**
	* Returns the first monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public static MonthlyTrading findByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence()
				   .findByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the first monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static MonthlyTrading fetchByUuid_C_First(java.lang.String uuid,
		long companyId, OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_First(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public static MonthlyTrading findByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence()
				   .findByUuid_C_Last(uuid, companyId, orderByComparator);
	}

	/**
	* Returns the last monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static MonthlyTrading fetchByUuid_C_Last(java.lang.String uuid,
		long companyId, OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence()
				   .fetchByUuid_C_Last(uuid, companyId, orderByComparator);
	}

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
	public static MonthlyTrading[] findByUuid_C_PrevAndNext(
		long monthlyTradingId, java.lang.String uuid, long companyId,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence()
				   .findByUuid_C_PrevAndNext(monthlyTradingId, uuid, companyId,
			orderByComparator);
	}

	/**
	* Removes all the monthly tradings where uuid = &#63; and companyId = &#63; from the database.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	*/
	public static void removeByUuid_C(java.lang.String uuid, long companyId) {
		getPersistence().removeByUuid_C(uuid, companyId);
	}

	/**
	* Returns the number of monthly tradings where uuid = &#63; and companyId = &#63;.
	*
	* @param uuid the uuid
	* @param companyId the company ID
	* @return the number of matching monthly tradings
	*/
	public static int countByUuid_C(java.lang.String uuid, long companyId) {
		return getPersistence().countByUuid_C(uuid, companyId);
	}

	/**
	* Returns all the monthly tradings where year = &#63;.
	*
	* @param year the year
	* @return the matching monthly tradings
	*/
	public static List<MonthlyTrading> findByYear(int year) {
		return getPersistence().findByYear(year);
	}

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
	public static List<MonthlyTrading> findByYear(int year, int start, int end) {
		return getPersistence().findByYear(year, start, end);
	}

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
	public static List<MonthlyTrading> findByYear(int year, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence().findByYear(year, start, end, orderByComparator);
	}

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
	public static List<MonthlyTrading> findByYear(int year, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByYear(year, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first monthly trading in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public static MonthlyTrading findByYear_First(int year,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence().findByYear_First(year, orderByComparator);
	}

	/**
	* Returns the first monthly trading in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static MonthlyTrading fetchByYear_First(int year,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence().fetchByYear_First(year, orderByComparator);
	}

	/**
	* Returns the last monthly trading in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading
	* @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	*/
	public static MonthlyTrading findByYear_Last(int year,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence().findByYear_Last(year, orderByComparator);
	}

	/**
	* Returns the last monthly trading in the ordered set where year = &#63;.
	*
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static MonthlyTrading fetchByYear_Last(int year,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence().fetchByYear_Last(year, orderByComparator);
	}

	/**
	* Returns the monthly tradings before and after the current monthly trading in the ordered set where year = &#63;.
	*
	* @param monthlyTradingId the primary key of the current monthly trading
	* @param year the year
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next monthly trading
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public static MonthlyTrading[] findByYear_PrevAndNext(
		long monthlyTradingId, int year,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence()
				   .findByYear_PrevAndNext(monthlyTradingId, year,
			orderByComparator);
	}

	/**
	* Removes all the monthly tradings where year = &#63; from the database.
	*
	* @param year the year
	*/
	public static void removeByYear(int year) {
		getPersistence().removeByYear(year);
	}

	/**
	* Returns the number of monthly tradings where year = &#63;.
	*
	* @param year the year
	* @return the number of matching monthly tradings
	*/
	public static int countByYear(int year) {
		return getPersistence().countByYear(year);
	}

	/**
	* Caches the monthly trading in the entity cache if it is enabled.
	*
	* @param monthlyTrading the monthly trading
	*/
	public static void cacheResult(MonthlyTrading monthlyTrading) {
		getPersistence().cacheResult(monthlyTrading);
	}

	/**
	* Caches the monthly tradings in the entity cache if it is enabled.
	*
	* @param monthlyTradings the monthly tradings
	*/
	public static void cacheResult(List<MonthlyTrading> monthlyTradings) {
		getPersistence().cacheResult(monthlyTradings);
	}

	/**
	* Creates a new monthly trading with the primary key. Does not add the monthly trading to the database.
	*
	* @param monthlyTradingId the primary key for the new monthly trading
	* @return the new monthly trading
	*/
	public static MonthlyTrading create(long monthlyTradingId) {
		return getPersistence().create(monthlyTradingId);
	}

	/**
	* Removes the monthly trading with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monthlyTradingId the primary key of the monthly trading
	* @return the monthly trading that was removed
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public static MonthlyTrading remove(long monthlyTradingId)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence().remove(monthlyTradingId);
	}

	public static MonthlyTrading updateImpl(MonthlyTrading monthlyTrading) {
		return getPersistence().updateImpl(monthlyTrading);
	}

	/**
	* Returns the monthly trading with the primary key or throws a {@link NoSuchMonthlyTradingException} if it could not be found.
	*
	* @param monthlyTradingId the primary key of the monthly trading
	* @return the monthly trading
	* @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	*/
	public static MonthlyTrading findByPrimaryKey(long monthlyTradingId)
		throws monthly.trading.exception.NoSuchMonthlyTradingException {
		return getPersistence().findByPrimaryKey(monthlyTradingId);
	}

	/**
	* Returns the monthly trading with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param monthlyTradingId the primary key of the monthly trading
	* @return the monthly trading, or <code>null</code> if a monthly trading with the primary key could not be found
	*/
	public static MonthlyTrading fetchByPrimaryKey(long monthlyTradingId) {
		return getPersistence().fetchByPrimaryKey(monthlyTradingId);
	}

	public static java.util.Map<java.io.Serializable, MonthlyTrading> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the monthly tradings.
	*
	* @return the monthly tradings
	*/
	public static List<MonthlyTrading> findAll() {
		return getPersistence().findAll();
	}

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
	public static List<MonthlyTrading> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

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
	public static List<MonthlyTrading> findAll(int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

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
	public static List<MonthlyTrading> findAll(int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the monthly tradings from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of monthly tradings.
	*
	* @return the number of monthly tradings
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static MonthlyTradingPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MonthlyTradingPersistence, MonthlyTradingPersistence> _serviceTracker =
		ServiceTrackerFactory.open(MonthlyTradingPersistence.class);
}