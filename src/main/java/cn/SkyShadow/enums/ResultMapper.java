package cn.SkyShadow.enums;

import cn.SkyShadow.tp.service.Impl.ReadProperties;
import cn.SkyShadow.tp.service.ReadConfigFile;

/**
 * ENUM
 * Created by Richard on 16/9/19.
 */
public enum ResultMapper {
    SUCCESS(true,6666),
    User_UnLogin(1001),
    User_LoginING(1002),
    User_Login_State_Online(true,1004),
    User_Login_State_Offline(true,1005),
    User_Login_Fail(1006),
    User_ModifyPsd_WrongOldPsd(1007),
    User_ModifyPsd_Password_Format(1008),
    User_ResultMapper_Opened(1009),
    User_ResultMapper_Closed(1010),
    User_Register_UserName_Exit(1011),
    User_Register_UserName_Format(1012),
    Public_IMG_CODE_Error(2001),
    Public_Email_Format(2002),
    Public_Email_Exist(2003),
    Public_Email_Validated(2004),
    Public_No_PasswordProtectedKey(2005),
    Public_OverTime(2006),
    Public_Email_UnValidated(2007),
    Public_Email_OverLocking(2008),
    Public_Email_MessageSendFail(2009),
    Public_Email_Error_code(2010),
    Public_Phone_UnValidated(2011),
    Public_Phone_OverLocking(2012),
    Public_Phone_MessageSendFail(2013),
    Public_Phone_Error_code(2014),
    Public_ILLEGAL_LOCATION(2015),
    Public_Phone_Format(2016),
    Public_Phone_Exist(2017),
    Public_Phone_Validated(2018),
    Org_NULL_ORG(3001),
    Org_NULL_User_ID(3002),
    Org_FORMAT_NAME(3003),
    Org_ILLEGAL_NAME(3004),
    Org_ILLEGAL_PARENT(3005),
    Org_NULL_LOCATION(3006),
    DB_ERROR(10000)

    ;
    private boolean isSuccess;
    private int code;
    private String info;
    private String resultName;
    private ReadConfigFile readConfigFile = new ReadProperties();

    public String getResultName() {
        return resultName;
    }

    public void setResultName(String resultName) {
        this.resultName = resultName;
    }

    ResultMapper(boolean isSuccess, int code) {
        this.isSuccess = isSuccess;
        this.code = code;
        try {
            readConfigFile.setPath("/resultConfig/result.properties");
            this.info = (String) readConfigFile.getValue(code+"");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ResultMapper(int code) {
        this.isSuccess = false;
        this.code = code;
        try {
            readConfigFile.setPath("/resultConfig/result.properties");
            this.info = (String) readConfigFile.getValue(code+"");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isSuccess() {
        return isSuccess;
    }

    public int getCode() {
        return code;
    }

    public String getInfo() {
        return info;
    }

    public void setSuccess(boolean success) {
        isSuccess = success;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "ResultMapper{" +
                "isSuccess=" + isSuccess +
                ", code=" + code +
                ", info='" + info + '\'' +
                ", resultName='" + resultName + '\'' +
                '}';
    }
}
