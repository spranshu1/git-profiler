/**
 * These materials are confidential and proprietary to Intellect Design Arena Ltd. and no part of these
 * materials should be reproduced, published, transmitted or distributed in any form or by any means,
 * electronic, mechanical, photocopying, recording or otherwise, or stored in any information storage or
 * retrieval system of any nature nor should the materials be disclosed to third parties or used in any
 * other manner for which this is not authorized, without the prior express written authorization of
 * Intellect Design Arena Ltd.
 *
 * Copyright 2017 Intellect Design Arena Limited. All rights reserved.
 *
 * @author pranshu.shrivastava
 * @date Dec 25, 2019
 */
package com.inmobi.gitprofiler.service;

import java.util.List;

import com.inmobi.gitprofiler.model.GithubProfile;

public interface ProfileHistoryService {
	
	List<GithubProfile> getSearchHistory();
	
	GithubProfile getProfileHistory(int profileId);
	
	void saveOrUpdate(GithubProfile profile);
	
	void saveOrUpdate(List<GithubProfile> profiles);
	
	void delete(int profileId);

}
