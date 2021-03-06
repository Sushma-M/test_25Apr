/*Copyright (c) 2016-2017 testing1.com All Rights Reserved.
 This software is the confidential and proprietary information of testing1.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing1.com*/

package com.test_21.qadatabase.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/




import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_21.qadatabase.*;

/**
 * Service object for domain model class Table18.
 * @see com.test_21.qadatabase.Table18
 */

public interface Table18Service {
   /**
	 * Creates a new table18.
	 * 
	 * @param created
	 *            The information of the created table18.
	 * @return The created table18.
	 */
	public Table18 create(Table18 created);

	/**
	 * Deletes a table18.
	 * 
	 * @param table18Id
	 *            The id of the deleted table18.
	 * @return The deleted table18.
	 * @throws EntityNotFoundException
	 *             if no table18 is found with the given id.
	 */
	public Table18 delete(Integer table18Id) throws EntityNotFoundException;

	/**
	 * Finds all table18s.
	 * 
	 * @return A list of table18s.
	 */
	public Page<Table18> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Table18> findAll(Pageable pageable);
	
	/**
	 * Finds table18 by id.
	 * 
	 * @param id
	 *            The id of the wanted table18.
	 * @return The found table18. If no table18 is found, this method returns
	 *         null.
	 */
	public Table18 findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a table18.
	 * 
	 * @param updated
	 *            The information of the updated table18.
	 * @return The updated table18.
	 * @throws EntityNotFoundException
	 *             if no table18 is found with given id.
	 */
	public Table18 update(Table18 updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the table18s in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the table18.
	 */

	public long countAll();


    public Page<Table18> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

