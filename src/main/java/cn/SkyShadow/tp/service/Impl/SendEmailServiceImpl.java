package cn.SkyShadow.tp.service.Impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import cn.SkyShadow.tp.service.SendEmailService;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SendEmailServiceImpl implements SendEmailService {
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	/**
	 * 临时使用
	 *///TODO
	public String SendValidateCode(String emailAddress) {
		Pattern pattern = Pattern.compile("^([a-zA-Z0-9_\\-.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$");
		Matcher matcher = pattern.matcher(emailAddress);
		if (!matcher.matches()) {
			return "EROOR!";
		}
		int validateCode = new Random().nextInt(899999) + 100000;
		logger.info("send ValidateCode "+ validateCode +" to email "+emailAddress +"successful");
		return validateCode +"";
	}

}
