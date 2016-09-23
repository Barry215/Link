package cn.SkyShadow.tp.service.Impl;
import org.springframework.stereotype.Service;
import cn.SkyShadow.tp.service.SendPhoneService;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class SendPhoneServiceImpl implements SendPhoneService {
	public String SendValidateCode(String Phone) {
		Pattern pattern = Pattern
				.compile("^((13[0-9])|(15[^4,\\D])|(18[0-9]))\\d{8}$");
		Matcher matcher = pattern.matcher(Phone.substring(3));
		if (!matcher.matches()) {
			return "ERROR!";
		}
		int validateCode = new Random().nextInt(899999) + 100000;
		return validateCode + "";
	}

}
