package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.CityMapper;
import cn.SkyShadow.dao.CountryMapper;
import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.SkyShadow.dao.UserMapper;
import cn.SkyShadow.model.City;
import cn.SkyShadow.model.Country;
import cn.SkyShadow.service.PublicService;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Transactional
@Service
public class PublicServiceImpl implements PublicService {

    private final UserMapper uMapper;
    private final CityMapper CityMapper;
    private final CountryMapper CountryMapper;


    public PublicServiceImpl(UserMapper uMapper, CityMapper CityMapper, CountryMapper CountryMapper) {
        this.uMapper = uMapper;
        this.CityMapper = CityMapper;
        this.CountryMapper = CountryMapper;
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

    public List<Country> getCountries() {
        return CountryMapper.select();
    }

    public List<City> get_ZH_Cities() {
        return CityMapper.select_zh();
    }

    public PasswordProtected getPasswordProtectByLoginName(String LoginName) {
        User u = uMapper.selectBaseInfoByLoginName(LoginName);
        if (u!=null){
            return  uMapper.getPasswordProtect(u.getUserId());
        }
        return null;
    }

    public int ChangePassword(Long userId, String password) {
        return uMapper.changePassword(userId,password);
    }

}
