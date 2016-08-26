package cn.SkyShadow.service;

import cn.SkyShadow.model.*;

import java.util.List;

public interface SessionService {
	public List<session> CreateNewSessionList(user createUser,
                                              List<usergroup> ugs);

	public session CreateNewSession(user createUser, usergroup ug);

	public int RenewalSession(session s, int second);

	public int SendMessageSession(message m);

	public List<message> GetNewMessageList(user u);

	public int RemoveSession(session s);
	
	public int AddExprList(List<expr> exprs);
	
	public int AddExpr(expr e);
	
	public int UpdateImage(imagine img);
	
	public int UpdateVideo(video v);
	
	public int UpdateVoice(voice v);
	
	public int UpdateFile(file f);
}
