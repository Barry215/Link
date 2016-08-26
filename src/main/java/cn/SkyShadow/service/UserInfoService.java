package cn.SkyShadow.service;

import cn.SkyShadow.model.country;
import cn.SkyShadow.model.location;
import cn.SkyShadow.model.user;
import cn.SkyShadow.model.user_school;

public interface UserInfoService{
	/*
	 * 
	 */
	location getUserLocation(user u);
	/*
	 * 
	 */
	int MofifyUser_School(user_school us);
	
	int ModifyBornLocation(user u, location l);
	
	int ModifyLiveLocation(user u, location l);
	
	int ModifyNational(user u, country c);
}
