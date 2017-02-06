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

package monthly.trading.service.persistence.impl;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextThreadLocal;
import com.liferay.portal.kernel.service.persistence.CompanyProvider;
import com.liferay.portal.kernel.service.persistence.CompanyProviderWrapper;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.uuid.PortalUUIDUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import monthly.trading.exception.NoSuchMonthlyTradingException;

import monthly.trading.model.MonthlyTrading;
import monthly.trading.model.impl.MonthlyTradingImpl;
import monthly.trading.model.impl.MonthlyTradingModelImpl;

import monthly.trading.service.persistence.MonthlyTradingPersistence;

import java.io.Serializable;

import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/**
 * The persistence implementation for the monthly trading service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see MonthlyTradingPersistence
 * @see monthly.trading.service.persistence.MonthlyTradingUtil
 * @generated
 */
@ProviderType
public class MonthlyTradingPersistenceImpl extends BasePersistenceImpl<MonthlyTrading>
	implements MonthlyTradingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link MonthlyTradingUtil} to access the monthly trading persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = MonthlyTradingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid",
			new String[] {
				String.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid",
			new String[] { String.class.getName() },
			MonthlyTradingModelImpl.UUID_COLUMN_BITMASK |
			MonthlyTradingModelImpl.MONTH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid",
			new String[] { String.class.getName() });

	/**
	 * Returns all the monthly tradings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the matching monthly tradings
	 */
	@Override
	public List<MonthlyTrading> findByUuid(String uuid) {
		return findByUuid(uuid, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MonthlyTrading> findByUuid(String uuid, int start, int end) {
		return findByUuid(uuid, start, end, null);
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
	@Override
	public List<MonthlyTrading> findByUuid(String uuid, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return findByUuid(uuid, start, end, orderByComparator, true);
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
	@Override
	public List<MonthlyTrading> findByUuid(String uuid, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID;
			finderArgs = new Object[] { uuid, start, end, orderByComparator };
		}

		List<MonthlyTrading> list = null;

		if (retrieveFromCache) {
			list = (List<MonthlyTrading>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MonthlyTrading monthlyTrading : list) {
					if (!Objects.equals(uuid, monthlyTrading.getUuid())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MONTHLYTRADING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonthlyTradingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				if (!pagination) {
					list = (List<MonthlyTrading>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MonthlyTrading>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first monthly trading in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly trading
	 * @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading findByUuid_First(String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = fetchByUuid_First(uuid,
				orderByComparator);

		if (monthlyTrading != null) {
			return monthlyTrading;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonthlyTradingException(msg.toString());
	}

	/**
	 * Returns the first monthly trading in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading fetchByUuid_First(String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		List<MonthlyTrading> list = findByUuid(uuid, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last monthly trading in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly trading
	 * @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading findByUuid_Last(String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = fetchByUuid_Last(uuid, orderByComparator);

		if (monthlyTrading != null) {
			return monthlyTrading;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonthlyTradingException(msg.toString());
	}

	/**
	 * Returns the last monthly trading in the ordered set where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading fetchByUuid_Last(String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		int count = countByUuid(uuid);

		if (count == 0) {
			return null;
		}

		List<MonthlyTrading> list = findByUuid(uuid, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MonthlyTrading[] findByUuid_PrevAndNext(long monthlyTradingId,
		String uuid, OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = findByPrimaryKey(monthlyTradingId);

		Session session = null;

		try {
			session = openSession();

			MonthlyTrading[] array = new MonthlyTradingImpl[3];

			array[0] = getByUuid_PrevAndNext(session, monthlyTrading, uuid,
					orderByComparator, true);

			array[1] = monthlyTrading;

			array[2] = getByUuid_PrevAndNext(session, monthlyTrading, uuid,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MonthlyTrading getByUuid_PrevAndNext(Session session,
		MonthlyTrading monthlyTrading, String uuid,
		OrderByComparator<MonthlyTrading> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MONTHLYTRADING_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_UUID_2);
		}

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MonthlyTradingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monthlyTrading);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonthlyTrading> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monthly tradings where uuid = &#63; from the database.
	 *
	 * @param uuid the uuid
	 */
	@Override
	public void removeByUuid(String uuid) {
		for (MonthlyTrading monthlyTrading : findByUuid(uuid,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(monthlyTrading);
		}
	}

	/**
	 * Returns the number of monthly tradings where uuid = &#63;.
	 *
	 * @param uuid the uuid
	 * @return the number of matching monthly tradings
	 */
	@Override
	public int countByUuid(String uuid) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID;

		Object[] finderArgs = new Object[] { uuid };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MONTHLYTRADING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_UUID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_UUID_1 = "monthlyTrading.uuid IS NULL";
	private static final String _FINDER_COLUMN_UUID_UUID_2 = "monthlyTrading.uuid = ?";
	private static final String _FINDER_COLUMN_UUID_UUID_3 = "(monthlyTrading.uuid IS NULL OR monthlyTrading.uuid = '')";
	public static final FinderPath FINDER_PATH_FETCH_BY_UUID_G = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class, FINDER_CLASS_NAME_ENTITY,
			"fetchByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() },
			MonthlyTradingModelImpl.UUID_COLUMN_BITMASK |
			MonthlyTradingModelImpl.GROUPID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_G = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUUID_G",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns the monthly trading where uuid = &#63; and groupId = &#63; or throws a {@link NoSuchMonthlyTradingException} if it could not be found.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching monthly trading
	 * @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading findByUUID_G(String uuid, long groupId)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = fetchByUUID_G(uuid, groupId);

		if (monthlyTrading == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("uuid=");
			msg.append(uuid);

			msg.append(", groupId=");
			msg.append(groupId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchMonthlyTradingException(msg.toString());
		}

		return monthlyTrading;
	}

	/**
	 * Returns the monthly trading where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading fetchByUUID_G(String uuid, long groupId) {
		return fetchByUUID_G(uuid, groupId, true);
	}

	/**
	 * Returns the monthly trading where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading fetchByUUID_G(String uuid, long groupId,
		boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { uuid, groupId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_UUID_G,
					finderArgs, this);
		}

		if (result instanceof MonthlyTrading) {
			MonthlyTrading monthlyTrading = (MonthlyTrading)result;

			if (!Objects.equals(uuid, monthlyTrading.getUuid()) ||
					(groupId != monthlyTrading.getGroupId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_MONTHLYTRADING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				List<MonthlyTrading> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
						finderArgs, list);
				}
				else {
					MonthlyTrading monthlyTrading = list.get(0);

					result = monthlyTrading;

					cacheResult(monthlyTrading);

					if ((monthlyTrading.getUuid() == null) ||
							!monthlyTrading.getUuid().equals(uuid) ||
							(monthlyTrading.getGroupId() != groupId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
							finderArgs, monthlyTrading);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (MonthlyTrading)result;
		}
	}

	/**
	 * Removes the monthly trading where uuid = &#63; and groupId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the monthly trading that was removed
	 */
	@Override
	public MonthlyTrading removeByUUID_G(String uuid, long groupId)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = findByUUID_G(uuid, groupId);

		return remove(monthlyTrading);
	}

	/**
	 * Returns the number of monthly tradings where uuid = &#63; and groupId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param groupId the group ID
	 * @return the number of matching monthly tradings
	 */
	@Override
	public int countByUUID_G(String uuid, long groupId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_G;

		Object[] finderArgs = new Object[] { uuid, groupId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MONTHLYTRADING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_G_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_G_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_G_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(groupId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_G_UUID_1 = "monthlyTrading.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_2 = "monthlyTrading.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_G_UUID_3 = "(monthlyTrading.uuid IS NULL OR monthlyTrading.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_G_GROUPID_2 = "monthlyTrading.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByUuid_C",
			new String[] {
				String.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C =
		new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() },
			MonthlyTradingModelImpl.UUID_COLUMN_BITMASK |
			MonthlyTradingModelImpl.COMPANYID_COLUMN_BITMASK |
			MonthlyTradingModelImpl.MONTH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UUID_C = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUuid_C",
			new String[] { String.class.getName(), Long.class.getName() });

	/**
	 * Returns all the monthly tradings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the matching monthly tradings
	 */
	@Override
	public List<MonthlyTrading> findByUuid_C(String uuid, long companyId) {
		return findByUuid_C(uuid, companyId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<MonthlyTrading> findByUuid_C(String uuid, long companyId,
		int start, int end) {
		return findByUuid_C(uuid, companyId, start, end, null);
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
	@Override
	public List<MonthlyTrading> findByUuid_C(String uuid, long companyId,
		int start, int end, OrderByComparator<MonthlyTrading> orderByComparator) {
		return findByUuid_C(uuid, companyId, start, end, orderByComparator, true);
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
	@Override
	public List<MonthlyTrading> findByUuid_C(String uuid, long companyId,
		int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] { uuid, companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UUID_C;
			finderArgs = new Object[] {
					uuid, companyId,
					
					start, end, orderByComparator
				};
		}

		List<MonthlyTrading> list = null;

		if (retrieveFromCache) {
			list = (List<MonthlyTrading>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MonthlyTrading monthlyTrading : list) {
					if (!Objects.equals(uuid, monthlyTrading.getUuid()) ||
							(companyId != monthlyTrading.getCompanyId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_MONTHLYTRADING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonthlyTradingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				if (!pagination) {
					list = (List<MonthlyTrading>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MonthlyTrading>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public MonthlyTrading findByUuid_C_First(String uuid, long companyId,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = fetchByUuid_C_First(uuid, companyId,
				orderByComparator);

		if (monthlyTrading != null) {
			return monthlyTrading;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonthlyTradingException(msg.toString());
	}

	/**
	 * Returns the first monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading fetchByUuid_C_First(String uuid, long companyId,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		List<MonthlyTrading> list = findByUuid_C(uuid, companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MonthlyTrading findByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = fetchByUuid_C_Last(uuid, companyId,
				orderByComparator);

		if (monthlyTrading != null) {
			return monthlyTrading;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("uuid=");
		msg.append(uuid);

		msg.append(", companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonthlyTradingException(msg.toString());
	}

	/**
	 * Returns the last monthly trading in the ordered set where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading fetchByUuid_C_Last(String uuid, long companyId,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		int count = countByUuid_C(uuid, companyId);

		if (count == 0) {
			return null;
		}

		List<MonthlyTrading> list = findByUuid_C(uuid, companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MonthlyTrading[] findByUuid_C_PrevAndNext(long monthlyTradingId,
		String uuid, long companyId,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = findByPrimaryKey(monthlyTradingId);

		Session session = null;

		try {
			session = openSession();

			MonthlyTrading[] array = new MonthlyTradingImpl[3];

			array[0] = getByUuid_C_PrevAndNext(session, monthlyTrading, uuid,
					companyId, orderByComparator, true);

			array[1] = monthlyTrading;

			array[2] = getByUuid_C_PrevAndNext(session, monthlyTrading, uuid,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MonthlyTrading getByUuid_C_PrevAndNext(Session session,
		MonthlyTrading monthlyTrading, String uuid, long companyId,
		OrderByComparator<MonthlyTrading> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(5 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(4);
		}

		query.append(_SQL_SELECT_MONTHLYTRADING_WHERE);

		boolean bindUuid = false;

		if (uuid == null) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_1);
		}
		else if (uuid.equals(StringPool.BLANK)) {
			query.append(_FINDER_COLUMN_UUID_C_UUID_3);
		}
		else {
			bindUuid = true;

			query.append(_FINDER_COLUMN_UUID_C_UUID_2);
		}

		query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MonthlyTradingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindUuid) {
			qPos.add(uuid);
		}

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monthlyTrading);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonthlyTrading> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monthly tradings where uuid = &#63; and companyId = &#63; from the database.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 */
	@Override
	public void removeByUuid_C(String uuid, long companyId) {
		for (MonthlyTrading monthlyTrading : findByUuid_C(uuid, companyId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(monthlyTrading);
		}
	}

	/**
	 * Returns the number of monthly tradings where uuid = &#63; and companyId = &#63;.
	 *
	 * @param uuid the uuid
	 * @param companyId the company ID
	 * @return the number of matching monthly tradings
	 */
	@Override
	public int countByUuid_C(String uuid, long companyId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UUID_C;

		Object[] finderArgs = new Object[] { uuid, companyId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_MONTHLYTRADING_WHERE);

			boolean bindUuid = false;

			if (uuid == null) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_1);
			}
			else if (uuid.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_UUID_C_UUID_3);
			}
			else {
				bindUuid = true;

				query.append(_FINDER_COLUMN_UUID_C_UUID_2);
			}

			query.append(_FINDER_COLUMN_UUID_C_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindUuid) {
					qPos.add(uuid);
				}

				qPos.add(companyId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_UUID_C_UUID_1 = "monthlyTrading.uuid IS NULL AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_2 = "monthlyTrading.uuid = ? AND ";
	private static final String _FINDER_COLUMN_UUID_C_UUID_3 = "(monthlyTrading.uuid IS NULL OR monthlyTrading.uuid = '') AND ";
	private static final String _FINDER_COLUMN_UUID_C_COMPANYID_2 = "monthlyTrading.companyId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByYear",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED,
			MonthlyTradingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] { Integer.class.getName() },
			MonthlyTradingModelImpl.YEAR_COLUMN_BITMASK |
			MonthlyTradingModelImpl.MONTH_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the monthly tradings where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching monthly tradings
	 */
	@Override
	public List<MonthlyTrading> findByYear(int year) {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MonthlyTrading> findByYear(int year, int start, int end) {
		return findByYear(year, start, end, null);
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
	@Override
	public List<MonthlyTrading> findByYear(int year, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return findByYear(year, start, end, orderByComparator, true);
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
	@Override
	public List<MonthlyTrading> findByYear(int year, int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year, start, end, orderByComparator };
		}

		List<MonthlyTrading> list = null;

		if (retrieveFromCache) {
			list = (List<MonthlyTrading>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (MonthlyTrading monthlyTrading : list) {
					if ((year != monthlyTrading.getYear())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_MONTHLYTRADING_WHERE);

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(MonthlyTradingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				if (!pagination) {
					list = (List<MonthlyTrading>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MonthlyTrading>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Returns the first monthly trading in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly trading
	 * @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading findByYear_First(int year,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = fetchByYear_First(year,
				orderByComparator);

		if (monthlyTrading != null) {
			return monthlyTrading;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonthlyTradingException(msg.toString());
	}

	/**
	 * Returns the first monthly trading in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading fetchByYear_First(int year,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		List<MonthlyTrading> list = findByYear(year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last monthly trading in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly trading
	 * @throws NoSuchMonthlyTradingException if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading findByYear_Last(int year,
		OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = fetchByYear_Last(year, orderByComparator);

		if (monthlyTrading != null) {
			return monthlyTrading;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchMonthlyTradingException(msg.toString());
	}

	/**
	 * Returns the last monthly trading in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching monthly trading, or <code>null</code> if a matching monthly trading could not be found
	 */
	@Override
	public MonthlyTrading fetchByYear_Last(int year,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		int count = countByYear(year);

		if (count == 0) {
			return null;
		}

		List<MonthlyTrading> list = findByYear(year, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public MonthlyTrading[] findByYear_PrevAndNext(long monthlyTradingId,
		int year, OrderByComparator<MonthlyTrading> orderByComparator)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = findByPrimaryKey(monthlyTradingId);

		Session session = null;

		try {
			session = openSession();

			MonthlyTrading[] array = new MonthlyTradingImpl[3];

			array[0] = getByYear_PrevAndNext(session, monthlyTrading, year,
					orderByComparator, true);

			array[1] = monthlyTrading;

			array[2] = getByYear_PrevAndNext(session, monthlyTrading, year,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected MonthlyTrading getByYear_PrevAndNext(Session session,
		MonthlyTrading monthlyTrading, int year,
		OrderByComparator<MonthlyTrading> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_MONTHLYTRADING_WHERE);

		query.append(_FINDER_COLUMN_YEAR_YEAR_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(MonthlyTradingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(monthlyTrading);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<MonthlyTrading> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the monthly tradings where year = &#63; from the database.
	 *
	 * @param year the year
	 */
	@Override
	public void removeByYear(int year) {
		for (MonthlyTrading monthlyTrading : findByYear(year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(monthlyTrading);
		}
	}

	/**
	 * Returns the number of monthly tradings where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching monthly tradings
	 */
	@Override
	public int countByYear(int year) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YEAR;

		Object[] finderArgs = new Object[] { year };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_MONTHLYTRADING_WHERE);

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_YEAR_YEAR_2 = "monthlyTrading.year = ?";

	public MonthlyTradingPersistenceImpl() {
		setModelClass(MonthlyTrading.class);
	}

	/**
	 * Caches the monthly trading in the entity cache if it is enabled.
	 *
	 * @param monthlyTrading the monthly trading
	 */
	@Override
	public void cacheResult(MonthlyTrading monthlyTrading) {
		entityCache.putResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingImpl.class, monthlyTrading.getPrimaryKey(),
			monthlyTrading);

		finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G,
			new Object[] { monthlyTrading.getUuid(), monthlyTrading.getGroupId() },
			monthlyTrading);

		monthlyTrading.resetOriginalValues();
	}

	/**
	 * Caches the monthly tradings in the entity cache if it is enabled.
	 *
	 * @param monthlyTradings the monthly tradings
	 */
	@Override
	public void cacheResult(List<MonthlyTrading> monthlyTradings) {
		for (MonthlyTrading monthlyTrading : monthlyTradings) {
			if (entityCache.getResult(
						MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
						MonthlyTradingImpl.class, monthlyTrading.getPrimaryKey()) == null) {
				cacheResult(monthlyTrading);
			}
			else {
				monthlyTrading.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all monthly tradings.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(MonthlyTradingImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the monthly trading.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(MonthlyTrading monthlyTrading) {
		entityCache.removeResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingImpl.class, monthlyTrading.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((MonthlyTradingModelImpl)monthlyTrading);
	}

	@Override
	public void clearCache(List<MonthlyTrading> monthlyTradings) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (MonthlyTrading monthlyTrading : monthlyTradings) {
			entityCache.removeResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
				MonthlyTradingImpl.class, monthlyTrading.getPrimaryKey());

			clearUniqueFindersCache((MonthlyTradingModelImpl)monthlyTrading);
		}
	}

	protected void cacheUniqueFindersCache(
		MonthlyTradingModelImpl monthlyTradingModelImpl, boolean isNew) {
		if (isNew) {
			Object[] args = new Object[] {
					monthlyTradingModelImpl.getUuid(),
					monthlyTradingModelImpl.getGroupId()
				};

			finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
				Long.valueOf(1));
			finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
				monthlyTradingModelImpl);
		}
		else {
			if ((monthlyTradingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monthlyTradingModelImpl.getUuid(),
						monthlyTradingModelImpl.getGroupId()
					};

				finderCache.putResult(FINDER_PATH_COUNT_BY_UUID_G, args,
					Long.valueOf(1));
				finderCache.putResult(FINDER_PATH_FETCH_BY_UUID_G, args,
					monthlyTradingModelImpl);
			}
		}
	}

	protected void clearUniqueFindersCache(
		MonthlyTradingModelImpl monthlyTradingModelImpl) {
		Object[] args = new Object[] {
				monthlyTradingModelImpl.getUuid(),
				monthlyTradingModelImpl.getGroupId()
			};

		finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
		finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);

		if ((monthlyTradingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_UUID_G.getColumnBitmask()) != 0) {
			args = new Object[] {
					monthlyTradingModelImpl.getOriginalUuid(),
					monthlyTradingModelImpl.getOriginalGroupId()
				};

			finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_G, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_UUID_G, args);
		}
	}

	/**
	 * Creates a new monthly trading with the primary key. Does not add the monthly trading to the database.
	 *
	 * @param monthlyTradingId the primary key for the new monthly trading
	 * @return the new monthly trading
	 */
	@Override
	public MonthlyTrading create(long monthlyTradingId) {
		MonthlyTrading monthlyTrading = new MonthlyTradingImpl();

		monthlyTrading.setNew(true);
		monthlyTrading.setPrimaryKey(monthlyTradingId);

		String uuid = PortalUUIDUtil.generate();

		monthlyTrading.setUuid(uuid);

		monthlyTrading.setCompanyId(companyProvider.getCompanyId());

		return monthlyTrading;
	}

	/**
	 * Removes the monthly trading with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param monthlyTradingId the primary key of the monthly trading
	 * @return the monthly trading that was removed
	 * @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	 */
	@Override
	public MonthlyTrading remove(long monthlyTradingId)
		throws NoSuchMonthlyTradingException {
		return remove((Serializable)monthlyTradingId);
	}

	/**
	 * Removes the monthly trading with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the monthly trading
	 * @return the monthly trading that was removed
	 * @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	 */
	@Override
	public MonthlyTrading remove(Serializable primaryKey)
		throws NoSuchMonthlyTradingException {
		Session session = null;

		try {
			session = openSession();

			MonthlyTrading monthlyTrading = (MonthlyTrading)session.get(MonthlyTradingImpl.class,
					primaryKey);

			if (monthlyTrading == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchMonthlyTradingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(monthlyTrading);
		}
		catch (NoSuchMonthlyTradingException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected MonthlyTrading removeImpl(MonthlyTrading monthlyTrading) {
		monthlyTrading = toUnwrappedModel(monthlyTrading);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(monthlyTrading)) {
				monthlyTrading = (MonthlyTrading)session.get(MonthlyTradingImpl.class,
						monthlyTrading.getPrimaryKeyObj());
			}

			if (monthlyTrading != null) {
				session.delete(monthlyTrading);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (monthlyTrading != null) {
			clearCache(monthlyTrading);
		}

		return monthlyTrading;
	}

	@Override
	public MonthlyTrading updateImpl(MonthlyTrading monthlyTrading) {
		monthlyTrading = toUnwrappedModel(monthlyTrading);

		boolean isNew = monthlyTrading.isNew();

		MonthlyTradingModelImpl monthlyTradingModelImpl = (MonthlyTradingModelImpl)monthlyTrading;

		if (Validator.isNull(monthlyTrading.getUuid())) {
			String uuid = PortalUUIDUtil.generate();

			monthlyTrading.setUuid(uuid);
		}

		ServiceContext serviceContext = ServiceContextThreadLocal.getServiceContext();

		Date now = new Date();

		if (isNew && (monthlyTrading.getCreateDate() == null)) {
			if (serviceContext == null) {
				monthlyTrading.setCreateDate(now);
			}
			else {
				monthlyTrading.setCreateDate(serviceContext.getCreateDate(now));
			}
		}

		if (!monthlyTradingModelImpl.hasSetModifiedDate()) {
			if (serviceContext == null) {
				monthlyTrading.setModifiedDate(now);
			}
			else {
				monthlyTrading.setModifiedDate(serviceContext.getModifiedDate(
						now));
			}
		}

		Session session = null;

		try {
			session = openSession();

			if (monthlyTrading.isNew()) {
				session.save(monthlyTrading);

				monthlyTrading.setNew(false);
			}
			else {
				monthlyTrading = (MonthlyTrading)session.merge(monthlyTrading);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !MonthlyTradingModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((monthlyTradingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monthlyTradingModelImpl.getOriginalUuid()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);

				args = new Object[] { monthlyTradingModelImpl.getUuid() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID,
					args);
			}

			if ((monthlyTradingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monthlyTradingModelImpl.getOriginalUuid(),
						monthlyTradingModelImpl.getOriginalCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);

				args = new Object[] {
						monthlyTradingModelImpl.getUuid(),
						monthlyTradingModelImpl.getCompanyId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_UUID_C, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UUID_C,
					args);
			}

			if ((monthlyTradingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						monthlyTradingModelImpl.getOriginalYear()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);

				args = new Object[] { monthlyTradingModelImpl.getYear() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);
			}
		}

		entityCache.putResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
			MonthlyTradingImpl.class, monthlyTrading.getPrimaryKey(),
			monthlyTrading, false);

		clearUniqueFindersCache(monthlyTradingModelImpl);
		cacheUniqueFindersCache(monthlyTradingModelImpl, isNew);

		monthlyTrading.resetOriginalValues();

		return monthlyTrading;
	}

	protected MonthlyTrading toUnwrappedModel(MonthlyTrading monthlyTrading) {
		if (monthlyTrading instanceof MonthlyTradingImpl) {
			return monthlyTrading;
		}

		MonthlyTradingImpl monthlyTradingImpl = new MonthlyTradingImpl();

		monthlyTradingImpl.setNew(monthlyTrading.isNew());
		monthlyTradingImpl.setPrimaryKey(monthlyTrading.getPrimaryKey());

		monthlyTradingImpl.setUuid(monthlyTrading.getUuid());
		monthlyTradingImpl.setMonthlyTradingId(monthlyTrading.getMonthlyTradingId());
		monthlyTradingImpl.setGroupId(monthlyTrading.getGroupId());
		monthlyTradingImpl.setCompanyId(monthlyTrading.getCompanyId());
		monthlyTradingImpl.setUserId(monthlyTrading.getUserId());
		monthlyTradingImpl.setUserName(monthlyTrading.getUserName());
		monthlyTradingImpl.setCreateDate(monthlyTrading.getCreateDate());
		monthlyTradingImpl.setModifiedDate(monthlyTrading.getModifiedDate());
		monthlyTradingImpl.setYear(monthlyTrading.getYear());
		monthlyTradingImpl.setMonth(monthlyTrading.getMonth());
		monthlyTradingImpl.setVolume(monthlyTrading.getVolume());

		return monthlyTradingImpl;
	}

	/**
	 * Returns the monthly trading with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the monthly trading
	 * @return the monthly trading
	 * @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	 */
	@Override
	public MonthlyTrading findByPrimaryKey(Serializable primaryKey)
		throws NoSuchMonthlyTradingException {
		MonthlyTrading monthlyTrading = fetchByPrimaryKey(primaryKey);

		if (monthlyTrading == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchMonthlyTradingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return monthlyTrading;
	}

	/**
	 * Returns the monthly trading with the primary key or throws a {@link NoSuchMonthlyTradingException} if it could not be found.
	 *
	 * @param monthlyTradingId the primary key of the monthly trading
	 * @return the monthly trading
	 * @throws NoSuchMonthlyTradingException if a monthly trading with the primary key could not be found
	 */
	@Override
	public MonthlyTrading findByPrimaryKey(long monthlyTradingId)
		throws NoSuchMonthlyTradingException {
		return findByPrimaryKey((Serializable)monthlyTradingId);
	}

	/**
	 * Returns the monthly trading with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the monthly trading
	 * @return the monthly trading, or <code>null</code> if a monthly trading with the primary key could not be found
	 */
	@Override
	public MonthlyTrading fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
				MonthlyTradingImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		MonthlyTrading monthlyTrading = (MonthlyTrading)serializable;

		if (monthlyTrading == null) {
			Session session = null;

			try {
				session = openSession();

				monthlyTrading = (MonthlyTrading)session.get(MonthlyTradingImpl.class,
						primaryKey);

				if (monthlyTrading != null) {
					cacheResult(monthlyTrading);
				}
				else {
					entityCache.putResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
						MonthlyTradingImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
					MonthlyTradingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return monthlyTrading;
	}

	/**
	 * Returns the monthly trading with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param monthlyTradingId the primary key of the monthly trading
	 * @return the monthly trading, or <code>null</code> if a monthly trading with the primary key could not be found
	 */
	@Override
	public MonthlyTrading fetchByPrimaryKey(long monthlyTradingId) {
		return fetchByPrimaryKey((Serializable)monthlyTradingId);
	}

	@Override
	public Map<Serializable, MonthlyTrading> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, MonthlyTrading> map = new HashMap<Serializable, MonthlyTrading>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			MonthlyTrading monthlyTrading = fetchByPrimaryKey(primaryKey);

			if (monthlyTrading != null) {
				map.put(primaryKey, monthlyTrading);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
					MonthlyTradingImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (MonthlyTrading)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_MONTHLYTRADING_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append(String.valueOf(primaryKey));

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (MonthlyTrading monthlyTrading : (List<MonthlyTrading>)q.list()) {
				map.put(monthlyTrading.getPrimaryKeyObj(), monthlyTrading);

				cacheResult(monthlyTrading);

				uncachedPrimaryKeys.remove(monthlyTrading.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(MonthlyTradingModelImpl.ENTITY_CACHE_ENABLED,
					MonthlyTradingImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the monthly tradings.
	 *
	 * @return the monthly tradings
	 */
	@Override
	public List<MonthlyTrading> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<MonthlyTrading> findAll(int start, int end) {
		return findAll(start, end, null);
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
	@Override
	public List<MonthlyTrading> findAll(int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
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
	@Override
	public List<MonthlyTrading> findAll(int start, int end,
		OrderByComparator<MonthlyTrading> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<MonthlyTrading> list = null;

		if (retrieveFromCache) {
			list = (List<MonthlyTrading>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_MONTHLYTRADING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_MONTHLYTRADING;

				if (pagination) {
					sql = sql.concat(MonthlyTradingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<MonthlyTrading>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<MonthlyTrading>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the monthly tradings from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (MonthlyTrading monthlyTrading : findAll()) {
			remove(monthlyTrading);
		}
	}

	/**
	 * Returns the number of monthly tradings.
	 *
	 * @return the number of monthly tradings
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_MONTHLYTRADING);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return MonthlyTradingModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the monthly trading persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(MonthlyTradingImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = CompanyProviderWrapper.class)
	protected CompanyProvider companyProvider;
	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_MONTHLYTRADING = "SELECT monthlyTrading FROM MonthlyTrading monthlyTrading";
	private static final String _SQL_SELECT_MONTHLYTRADING_WHERE_PKS_IN = "SELECT monthlyTrading FROM MonthlyTrading monthlyTrading WHERE monthlyTradingId IN (";
	private static final String _SQL_SELECT_MONTHLYTRADING_WHERE = "SELECT monthlyTrading FROM MonthlyTrading monthlyTrading WHERE ";
	private static final String _SQL_COUNT_MONTHLYTRADING = "SELECT COUNT(monthlyTrading) FROM MonthlyTrading monthlyTrading";
	private static final String _SQL_COUNT_MONTHLYTRADING_WHERE = "SELECT COUNT(monthlyTrading) FROM MonthlyTrading monthlyTrading WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "monthlyTrading.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No MonthlyTrading exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No MonthlyTrading exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(MonthlyTradingPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"uuid"
			});
}