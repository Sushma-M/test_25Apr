/*Copyright (c) 2016-2017 testing1.com All Rights Reserved.
 This software is the confidential and proprietary information of testing1.com You shall not disclose such Confidential Information and shall use it only in accordance
 with the terms of the source code license agreement you entered into with testing1.com*/
package com.test_21.qadatabase.controller;

/*This is a Studio Managed File. DO NOT EDIT THIS FILE. Your changes may be reverted by Studio.*/
import com.test_21.qadatabase.service.LocationsService;
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
 * Controller object for domain model class Locations.
 * @see com.test_21.qadatabase.Locations
 */
@RestController(value = "Qadatabase.LocationsController")
@RequestMapping("/qadatabase/Locations")
@Api(description = "Exposes APIs to work with Locations resource.", value = "LocationsController")
public class LocationsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(LocationsController.class);

    @Autowired
    @Qualifier("qadatabase.LocationsService")
    private LocationsService locationsService;

    @RequestMapping(value = "/search", method = RequestMethod.POST)
    @ApiOperation(value = "Returns the list of Locations instances matching the search criteria.")
    public Page<Locations> findLocationss(Pageable pageable, @RequestBody QueryFilter[] queryFilters) {
        LOGGER.debug("Rendering Locationss list");
        return locationsService.findAll(queryFilters, pageable);
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ApiOperation(value = "Returns the list of Locations instances.")
    public Page<Locations> getLocationss(Pageable pageable) {
        LOGGER.debug("Rendering Locationss list");
        return locationsService.findAll(pageable);
    }

    /**
	 * This setter method should only be used by unit tests
	 * 
	 * @param service
	 */
    protected void setLocationsService(LocationsService service) {
        this.locationsService = service;
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Creates a new Locations instance.")
    public Locations createLocations(@RequestBody Locations instance) {
        LOGGER.debug("Create Locations with information: {}", instance);
        instance = locationsService.create(instance);
        LOGGER.debug("Created Locations with information: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/count", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the total count of Locations instances.")
    public Long countAllLocationss() {
        LOGGER.debug("counting Locationss");
        Long count = locationsService.countAll();
        return count;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Returns the Locations instance associated with the given id.")
    public Locations getLocations(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Getting Locations with id: {}", id);
        Locations instance = locationsService.findById(id);
        LOGGER.debug("Locations details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Updates the Locations instance associated with the given id.")
    public Locations editLocations(@PathVariable(value = "id") Integer id, @RequestBody Locations instance) throws EntityNotFoundException {
        LOGGER.debug("Editing Locations with id: {}", instance.getId());
        instance.setId(id);
        instance = locationsService.update(instance);
        LOGGER.debug("Locations details with id: {}", instance);
        return instance;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @WMAccessVisibility(value = AccessSpecifier.APP_ONLY)
    @ApiOperation(value = "Deletes the Locations instance associated with the given id.")
    public boolean deleteLocations(@PathVariable(value = "id") Integer id) throws EntityNotFoundException {
        LOGGER.debug("Deleting Locations with id: {}", id);
        Locations deleted = locationsService.delete(id);
        return deleted != null;
    }
}
