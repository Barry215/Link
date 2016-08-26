package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.model.result_model.RegisterResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.SkyShadow.dao.userMapper;
import cn.SkyShadow.model.result_model.LoginResult;
import cn.SkyShadow.model.user;
import cn.SkyShadow.service.UserCoreService;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserCoreServiceImpl implements UserCoreService {
    @Autowired
    private userMapper userMapper;

    public LoginResult getLoginResult(user user) {
        return userMapper.getLoginResult(user);
    }

    public RegisterResult getRegisterResult_NOEMAIL(user user) {
        return userMapper.getRegisterResult(user);
    }

    public RegisterResult getRegisterResult(user user) {
        return userMapper.getRegisterResult(user);
    }

    public user SelectUserByLogin(user user) {
        Long userId = userMapper.getLoginResult(user).getResultNum();
        if (userId != 0) {
            return userMapper.selectByPrimaryKey(userId);
        }
        return null;
    }

    public user selectUserBaseInfo(Long userId) {
        return userMapper.selectBaseInfo(userId);
    }

    public int ValidateEmail(Long userId, String Email) {
        return userMapper.validateEmail(Email, userId);
    }

    public int ValidatePhone(Long userId, String phone) {
        return userMapper.validatePhone(phone, userId);
    }

    public int ChangeValidateEmail(Long userId, String Email) {
        userMapper.unValidateEmail(userId);
        return userMapper.validateEmail(Email, userId);
    }

    public int ChangeValidatePhone(Long userId, String phone) {
        userMapper.unValidatePhone(userId);
        return userMapper.validatePhone(phone, userId);
    }

    public PasswordProtected getPasswordProtectByUserId(Long UserId) {
        return userMapper.getPasswordProtect(UserId);
    }

}
