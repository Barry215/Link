package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.model.user;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.SkyShadow.dao.cityMapper;
import cn.SkyShadow.dao.countryMapper;
import cn.SkyShadow.dao.userMapper;
import cn.SkyShadow.model.city;
import cn.SkyShadow.model.country;
import cn.SkyShadow.service.PublicService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class PublicServiceImpl implements PublicService {

    private final userMapper uMapper;
    private final cityMapper cityMapper;
    private final countryMapper countryMapper;

    @Autowired(required = false)
    public PublicServiceImpl(userMapper uMapper, cityMapper cityMapper, countryMapper countryMapper) {
        this.uMapper = uMapper;
        this.cityMapper = cityMapper;
        this.countryMapper = countryMapper;
    }

    public String HasPhone(String Phone) {
        return uMapper.HasPhone(Phone);
    }

    public String HasUsername(String username) {
        return uMapper.HasUserName(username);
    }

    public String HasEmail(String email) {
        return uMapper.HasEmail(email);
    }

    public List<country> getCountries() {
        return countryMapper.select();
    }

    public List<city> get_ZH_Cities() {
        return cityMapper.select_zh();
    }

    public PasswordProtected getPasswordProtectByLoginName(String LoginName) {
        user u = uMapper.selectBaseInfoByLoginName(LoginName);
        if (u!=null){
            return  uMapper.getPasswordProtect(u.getUserId());
        }
        return null;
    }

    public int ChangePasword(Long userId, String password) {
        return uMapper.changePassword(userId,password);
    }

}
