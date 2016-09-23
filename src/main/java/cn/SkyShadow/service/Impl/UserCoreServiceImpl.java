package cn.SkyShadow.service.Impl;

import cn.SkyShadow.dao.UserMapper;
import cn.SkyShadow.dto.user.PasswordProtected;
import cn.SkyShadow.dto.user.RegisterResult;
import cn.SkyShadow.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import cn.SkyShadow.dto.user.LoginResult;
import cn.SkyShadow.service.UserCoreService;
import org.springframework.transaction.annotation.Transactional;


@Transactional
@Service
public class UserCoreServiceImpl implements UserCoreService {
    private final UserMapper UserMapper;

    @Autowired(required = false)
    public UserCoreServiceImpl(UserMapper UserMapper) {
        this.UserMapper = UserMapper;
    }

    public LoginResult getLoginResult(User user) {
        return UserMapper.getLoginResult(user);
    }

    public RegisterResult getRegisterResult_NOEMAIL(User user) {
        return UserMapper.getRegisterResult(user);
    }

    public RegisterResult getRegisterResult(User user) {
        return UserMapper.getRegisterResult(user);
    }

    public User SelectUserByLogin(User user) {
        Long userId = UserMapper.getLoginResult(user).getResultNum();
        if (userId != 0) {
            return UserMapper.selectByPrimaryKey(userId);
        }
        return null;
    }

    public User selectUserBaseInfo(Long userId) {
        return UserMapper.selectBaseInfo(userId);
    }

    public int ValidateEmail(Long userId, String Email) {
        return UserMapper.validateEmail(Email, userId);
    }

    public int ValidatePhone(Long userId, String phone) {
        return UserMapper.validatePhone(phone, userId);
    }

    public int ChangeValidateEmail(Long userId, String Email) {
        UserMapper.unValidateEmail(userId);
        return UserMapper.validateEmail(Email, userId);
    }

    public int ChangeValidatePhone(Long userId, String phone) {
        UserMapper.unValidatePhone(userId);
        return UserMapper.validatePhone(phone, userId);
    }

    public PasswordProtected getPasswordProtectByUserId(Long UserId) {
        return UserMapper.getPasswordProtect(UserId);
    }

    public int OpenOrClosePasswordChangeValidate(Long userId) {
        return UserMapper.OpenOrClosePasswordChangeValidate(userId);
    }

    public int ChangePassword(Long userId, String password) {
        return UserMapper.changePassword(userId,password);
    }

}
