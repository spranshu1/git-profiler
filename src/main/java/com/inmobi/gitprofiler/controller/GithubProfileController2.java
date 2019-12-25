package com.inmobi.gitprofiler.controller;

import java.io.IOException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inmobi.gitprofiler.model.GithubProfile;
import com.inmobi.gitprofiler.service.ProfileSearchService;

/**
 * @author pranshu.shrivastava
 *
 */
@RestController
public class GithubProfileController2 {
	
	private static final Logger LOG = LoggerFactory.getLogger(GithubProfileController2.class);
	
	@Autowired
	private ProfileSearchService searchService;
	
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String search() throws IOException { 	
       
        return "index";
    }
    
    

}
