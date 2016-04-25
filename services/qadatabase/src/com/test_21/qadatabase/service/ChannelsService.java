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
 * Service object for domain model class Channels.
 * @see com.test_21.qadatabase.Channels
 */

public interface ChannelsService {
   /**
	 * Creates a new channels.
	 * 
	 * @param created
	 *            The information of the created channels.
	 * @return The created channels.
	 */
	public Channels create(Channels created);

	/**
	 * Deletes a channels.
	 * 
	 * @param channelsId
	 *            The id of the deleted channels.
	 * @return The deleted channels.
	 * @throws EntityNotFoundException
	 *             if no channels is found with the given id.
	 */
	public Channels delete(Integer channelsId) throws EntityNotFoundException;

	/**
	 * Finds all channelss.
	 * 
	 * @return A list of channelss.
	 */
	public Page<Channels> findAll(QueryFilter[] queryFilters, Pageable pageable);
	
	public Page<Channels> findAll(Pageable pageable);
	
	/**
	 * Finds channels by id.
	 * 
	 * @param id
	 *            The id of the wanted channels.
	 * @return The found channels. If no channels is found, this method returns
	 *         null.
	 */
	public Channels findById(Integer id) throws
	 EntityNotFoundException;
	/**
	 * Updates the information of a channels.
	 * 
	 * @param updated
	 *            The information of the updated channels.
	 * @return The updated channels.
	 * @throws EntityNotFoundException
	 *             if no channels is found with given id.
	 */
	public Channels update(Channels updated) throws EntityNotFoundException;

	/**
	 * Retrieve the total count of the channelss in the repository.
	 * 
	 * @param None
	 *            .
	 * @return The count of the channels.
	 */

	public long countAll();


    public Page<Channels> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable);


}

