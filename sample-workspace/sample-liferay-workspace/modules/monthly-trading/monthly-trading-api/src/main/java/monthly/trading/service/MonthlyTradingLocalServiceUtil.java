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
 * Provides the local service utility for MonthlyTrading. This utility wraps
 * {@link monthly.trading.service.impl.MonthlyTradingLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTradingLocalService
 * @see monthly.trading.service.base.MonthlyTradingLocalServiceBaseImpl
 * @see monthly.trading.service.impl.MonthlyTradingLocalServiceImpl
 * @generated
 */
@ProviderType
public class MonthlyTradingLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link monthly.trading.service.impl.MonthlyTradingLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.ExportActionableDynamicQuery getExportActionableDynamicQuery(
		com.liferay.exportimport.kernel.lar.PortletDataContext portletDataContext) {
		return getService().getExportActionableDynamicQuery(portletDataContext);
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of monthly tradings.
	*
	* @return the number of monthly tradings
	*/
	public static int getMonthlyTradingsCount() {
		return getService().getMonthlyTradingsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link monthly.trading.model.impl.MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link monthly.trading.model.impl.MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<monthly.trading.model.MonthlyTrading> getMonthlyTradingByYear(
		int year) {
		return getService().getMonthlyTradingByYear(year);
	}

	/**
	* Returns a range of all the monthly tradings.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link monthly.trading.model.impl.MonthlyTradingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @return the range of monthly tradings
	*/
	public static java.util.List<monthly.trading.model.MonthlyTrading> getMonthlyTradings(
		int start, int end) {
		return getService().getMonthlyTradings(start, end);
	}

	/**
	* Returns all the monthly tradings matching the UUID and company.
	*
	* @param uuid the UUID of the monthly tradings
	* @param companyId the primary key of the company
	* @return the matching monthly tradings, or an empty list if no matches were found
	*/
	public static java.util.List<monthly.trading.model.MonthlyTrading> getMonthlyTradingsByUuidAndCompanyId(
		java.lang.String uuid, long companyId) {
		return getService().getMonthlyTradingsByUuidAndCompanyId(uuid, companyId);
	}

	/**
	* Returns a range of monthly tradings matching the UUID and company.
	*
	* @param uuid the UUID of the monthly tradings
	* @param companyId the primary key of the company
	* @param start the lower bound of the range of monthly tradings
	* @param end the upper bound of the range of monthly tradings (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the range of matching monthly tradings, or an empty list if no matches were found
	*/
	public static java.util.List<monthly.trading.model.MonthlyTrading> getMonthlyTradingsByUuidAndCompanyId(
		java.lang.String uuid, long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<monthly.trading.model.MonthlyTrading> orderByComparator) {
		return getService()
				   .getMonthlyTradingsByUuidAndCompanyId(uuid, companyId,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static monthly.trading.model.MonthlyTrading addMonthlyTrading(
		int year, int month, int volume) {
		return getService().addMonthlyTrading(year, month, volume);
	}

	/**
	* Adds the monthly trading to the database. Also notifies the appropriate model listeners.
	*
	* @param monthlyTrading the monthly trading
	* @return the monthly trading that was added
	*/
	public static monthly.trading.model.MonthlyTrading addMonthlyTrading(
		monthly.trading.model.MonthlyTrading monthlyTrading) {
		return getService().addMonthlyTrading(monthlyTrading);
	}

	/**
	* Creates a new monthly trading with the primary key. Does not add the monthly trading to the database.
	*
	* @param monthlyTradingId the primary key for the new monthly trading
	* @return the new monthly trading
	*/
	public static monthly.trading.model.MonthlyTrading createMonthlyTrading(
		long monthlyTradingId) {
		return getService().createMonthlyTrading(monthlyTradingId);
	}

	/**
	* Deletes the monthly trading with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param monthlyTradingId the primary key of the monthly trading
	* @return the monthly trading that was removed
	* @throws PortalException if a monthly trading with the primary key could not be found
	*/
	public static monthly.trading.model.MonthlyTrading deleteMonthlyTrading(
		long monthlyTradingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteMonthlyTrading(monthlyTradingId);
	}

	/**
	* Deletes the monthly trading from the database. Also notifies the appropriate model listeners.
	*
	* @param monthlyTrading the monthly trading
	* @return the monthly trading that was removed
	*/
	public static monthly.trading.model.MonthlyTrading deleteMonthlyTrading(
		monthly.trading.model.MonthlyTrading monthlyTrading) {
		return getService().deleteMonthlyTrading(monthlyTrading);
	}

	public static monthly.trading.model.MonthlyTrading fetchMonthlyTrading(
		long monthlyTradingId) {
		return getService().fetchMonthlyTrading(monthlyTradingId);
	}

	/**
	* Returns the monthly trading matching the UUID and group.
	*
	* @param uuid the monthly trading's UUID
	* @param groupId the primary key of the group
	* @return the matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	*/
	public static monthly.trading.model.MonthlyTrading fetchMonthlyTradingByUuidAndGroupId(
		java.lang.String uuid, long groupId) {
		return getService().fetchMonthlyTradingByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Returns the monthly trading with the primary key.
	*
	* @param monthlyTradingId the primary key of the monthly trading
	* @return the monthly trading
	* @throws PortalException if a monthly trading with the primary key could not be found
	*/
	public static monthly.trading.model.MonthlyTrading getMonthlyTrading(
		long monthlyTradingId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMonthlyTrading(monthlyTradingId);
	}

	/**
	* Returns the monthly trading matching the UUID and group.
	*
	* @param uuid the monthly trading's UUID
	* @param groupId the primary key of the group
	* @return the matching monthly trading
	* @throws PortalException if a matching monthly trading could not be found
	*/
	public static monthly.trading.model.MonthlyTrading getMonthlyTradingByUuidAndGroupId(
		java.lang.String uuid, long groupId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getMonthlyTradingByUuidAndGroupId(uuid, groupId);
	}

	/**
	* Updates the monthly trading in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param monthlyTrading the monthly trading
	* @return the monthly trading that was updated
	*/
	public static monthly.trading.model.MonthlyTrading updateMonthlyTrading(
		monthly.trading.model.MonthlyTrading monthlyTrading) {
		return getService().updateMonthlyTrading(monthlyTrading);
	}

	public static MonthlyTradingLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<MonthlyTradingLocalService, MonthlyTradingLocalService> _serviceTracker =
		ServiceTrackerFactory.open(MonthlyTradingLocalService.class);
}