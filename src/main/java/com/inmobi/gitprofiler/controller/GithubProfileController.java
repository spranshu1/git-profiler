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
import com.inmobi.gitprofiler.service.ProfileHistoryService;
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

	@Autowired
	private ProfileHistoryService profileSearchHistory;

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public String search(@RequestParam(value = "q", required = false) String gitHandle, Model model)
			throws IOException {
		// Search profiles
		LOG.info("Searching profiles for : {}", gitHandle);
		final List<GithubProfile> searchResults = searchService.getProfiles(gitHandle);
		model.addAttribute("search", searchResults);

		// Save search history
		LOG.info("Saving search results...");
		profileSearchHistory.saveOrUpdate(searchResults);
		model.addAttribute("history", profileSearchHistory.getSearchHistory());

		return "index";
	}

	@RequestMapping(value = "/delete", method = RequestMethod.POST)
	public String deleteHistory(@RequestParam(value = "id", required = true) int id, Model model) {
		//Delete record from DB
		LOG.info("Deleting record with id : {}", id);
		profileSearchHistory.delete(id);
		
		//Load fresh history
		model.addAttribute("history", profileSearchHistory.getSearchHistory());
		
		return "index";
	}

}
