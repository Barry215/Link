package cn.SkyShadow.service;

import cn.SkyShadow.model.occupation;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;

import java.util.List;

public interface OccupationService {
	public int CreateNewOccupation(organization org, user u);
	
	public int ModifyOccupation(occupation o, user u);
	
	public List<occupation> GetOccupationList(organization o);
	
	public List<user> getUserList(occupation o);
}
