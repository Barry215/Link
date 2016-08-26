package cn.SkyShadow.service;

import cn.SkyShadow.model.mail;
import cn.SkyShadow.model.mailbox;
import cn.SkyShadow.model.user;

import java.util.List;

public interface MailService {
	public int SendMail(mail m);
	public List<mail> GetNewMailList(user u, mailbox mailbox);
	
	public List<mail> GetNewMailListAuto(user u);
	
	public int Delete1Mail(user u, mail m);
	
	public int Delete2Mail(user u, mail m);
	
}
