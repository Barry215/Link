package cn.SkyShadow.service;

import cn.SkyShadow.dto.excution.Excution;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;

import java.util.List;

public interface OrgService {
	/*
	 */
	public Excution CreateNewOrg(user user, organization org);
	
	public Excution  ModifyOrg(user u, organization o);
	
	public List<organization> SearchOrg(String str);
}
