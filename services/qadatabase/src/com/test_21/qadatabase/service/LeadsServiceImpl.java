/*Copyright (c) 2016-2017 testing1.com All Rights Reserved.
 This software is the confidential and proprietary information of testing1.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing1.com*/

package com.test_21.qadatabase.service;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/





import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.wavemaker.runtime.data.dao.*;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;

import com.test_21.qadatabase.*;


/**
 * ServiceImpl object for domain model class Leads.
 * @see com.test_21.qadatabase.Leads
 */
@Service("qadatabase.LeadsService")
public class LeadsServiceImpl implements LeadsService {


    private static final Logger LOGGER = LoggerFactory.getLogger(LeadsServiceImpl.class);

    @Autowired
    @Qualifier("qadatabase.LeadsDao")
    private WMGenericDao<Leads, Integer> wmGenericDao;

    public void setWMGenericDao(WMGenericDao<Leads, Integer> wmGenericDao){
        this.wmGenericDao = wmGenericDao;
    }
     @Transactional(readOnly = true, value = "qadatabaseTransactionManager")
     public Page<Leads> findAssociatedValues(Object value, String entityName, String key,  Pageable pageable){
          LOGGER.debug("Fetching all associated");
          return this.wmGenericDao.getAssociatedObjects(value, entityName, key, pageable);
     }

    @Transactional(value = "qadatabaseTransactionManager")
    @Override
    public Leads create(Leads leads) {
        LOGGER.debug("Creating a new leads with information: {}" , leads);
        return this.wmGenericDao.create(leads);
    }

    @Transactional(rollbackFor = EntityNotFoundException.class, value = "qadatabaseTransactionManager")
    @Override
    public Leads delete(Integer leadsId) throws EntityNotFoundException {
        LOGGER.debug("Deleting leads with id: {}" , leadsId);
        Leads deleted = this.wmGenericDao.findById(leadsId);
        if (deleted == null) {
            LOGGER.debug("No leads found with id: {}" , leadsId);
            throw new EntityNotFoundException(String.valueOf(leadsId));
        }
        this.wmGenericDao.delete(deleted);
        return deleted;
    }

    @Transactional(readOnly = true, value = "qadatabaseTransactionManager")
    @Override
    public Page<Leads> findAll(QueryFilter[] queryFilters, Pageable pageable) {
        LOGGER.debug("Finding all leadss");
        return this.wmGenericDao.search(queryFilters, pageable);
    }
    
    @Transactional(readOnly = true, value = "qadatabaseTransactionManager")
    @Override
    public Page<Leads> findAll(Pageable pageable) {
        LOGGER.debug("Finding all leadss");
        return this.wmGenericDao.search(null, pageable);
    }

    @Transactional(readOnly = true, value = "qadatabaseTransactionManager")
    @Override
    public Leads findById(Integer id) throws EntityNotFoundException {
        LOGGER.debug("Finding leads by id: {}" , id);
        Leads leads=this.wmGenericDao.findById(id);
        if(leads==null){
            LOGGER.debug("No leads found with id: {}" , id);
            throw new EntityNotFoundException(String.valueOf(id));
        }
        return leads;
    }
    @Transactional(rollbackFor = EntityNotFoundException.class, value = "qadatabaseTransactionManager")
    @Override
    public Leads update(Leads updated) throws EntityNotFoundException {
        LOGGER.debug("Updating leads with information: {}" , updated);
        this.wmGenericDao.update(updated);

        Integer id = (Integer)updated.getId();

        return this.wmGenericDao.findById(id);
    }

    @Transactional(readOnly = true, value = "qadatabaseTransactionManager")
    @Override
    public long countAll() {
        return this.wmGenericDao.count();
    }
}

