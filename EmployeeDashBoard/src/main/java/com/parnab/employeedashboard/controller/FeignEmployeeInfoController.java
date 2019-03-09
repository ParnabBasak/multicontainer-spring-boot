package com.parnab.employeedashboard.controller;

import java.util.Collection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.parnab.employeedashboard.domain.model.EmployeeInfo;

@RefreshScope
@RestController
public class FeignEmployeeInfoController {
	@Autowired
	EmployeeServiceProxy proxyService;

	@RequestMapping(value = "/dashboard/feign/{myself}", method= RequestMethod.GET)
	public EmployeeInfo findme(@PathVariable Long myself) {
		return proxyService.findById(myself);
	}

	@RequestMapping(value = "/dashboard/feign/peers", method= RequestMethod.GET)
	public Collection<EmployeeInfo> findPeers() {
		return proxyService.findAll();
	}
}
