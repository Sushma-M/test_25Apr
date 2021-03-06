/*Copyright (c) 2016-2017 testing1.com All Rights Reserved.
 This software is the confidential and proprietary information of testing1.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing1.com*/
package com.test_21.qadatabase.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_21.qadatabase.service.Table5Service;
import java.io.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.hibernate.TypeMismatchException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import com.wavemaker.runtime.data.exception.EntityNotFoundException;
import com.wavemaker.runtime.data.expression.QueryFilter;
import com.wavemaker.runtime.util.WMMultipartUtils;
import com.wavemaker.runtime.util.WMRuntimeUtils;
import com.wavemaker.runtime.file.model.DownloadResponse;
import com.wordnik.swagger.annotations.*;
import com.test_21.qadatabase.*;
import com.test_21.qadatabase.service.*;
import com.wavemaker.tools.api.core.annotations.WMAccessVisibility;
import com.wavemaker.tools.api.core.models.AccessSpecifier;

/**
 * Controller object for domain model class Table5.
 * @see com.test_21.qadatabase.Table5
 */
@RestController(value = "Qadatabase.Table5Controller")
@RequestMapping("/qadatabase/Table5")
@Api(description = "Exposes APIs to work with Table5 resource.", value = "Table5Controller")
public class Table5Controller {

    private static final Logger LOGGER = LoggerFactory.getLogger(Table5Controller.class);

    @Autowired
    @Qualifier("qadatabase.Table5Service")
    private Table5Service table5Service;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Table5 instances matching the search criteria.")
    public Page<Table5> findTable5s(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Table5s list");
        return table5Service.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Table5 instances.")
    public Page<Table5> getTable5s(Pageable pageable) {
        LOGGER.debug("Rendering Table5s list");
        return table5Service.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setTable5Service(Table5Service service) {
        this.table5Service = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Table5 instance.")
    public Table5 createTable5(@RequestBody Table5 instance) {
        LOGGER.debug("Create Table5 with information: {}", instance);
        instance = table5Service.create(instance);
        LOGGER.debug("Created Table5 with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Table5 instances.")
    public Long countAllTable5s() {
        LOGGER.debug("counting Table5s");
        Long count = table5Service.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Table5 instance associated with the given id.")
    public Table5 getTable5(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Table5 with id: {}", id);
        Table5 instance = table5Service.findById(id);
        LOGGER.debug("Table5 details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Table5 instance associated with the given id.")
    public Table5 editTable5(@PathVariable(value = "id") Integer id, @RequestBody Table5 instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Table5 with id: {}", instance.getId());
        instance.setId(id);
        instance = table5Service.update(instance);
        LOGGER.debug("Table5 details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Table5 instance associated with the given id.")
    public boolean deleteTable5(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Table5 with id: {}", id);
        Table5 deleted = table5Service.delete(id);
        return deleted != null;
    }
}
