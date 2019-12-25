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

import com.inmobi.gitprofiler.model.GithubProfile;
import com.inmobi.gitprofiler.service.ProfileSearchService;

/**
 * @author pranshu.shrivastava
 *
 */
@Controller
public class GithubProfileController {
	
	private static final Logger LOG = LoggerFactory.getLogger(GithubProfileController.class);
	
	@Autowired
	private ProfileSearchService searchService;
	
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String search(@RequestParam(value = "search", required = false) String gitHandle, Model model) throws IOException { 	
        LOG.info("Searching profiles for : {}",gitHandle);
    	final List<GithubProfile> searchResults = searchService.getProfiles(gitHandle);
        model.addAttribute("search", searchResults);
                
        return "index";
    }
    
    

}
