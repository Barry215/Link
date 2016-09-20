package cn.SkyShadow.enums;

import cn.SkyShadow.tp.service.Impl.ReadProperties;
import cn.SkyShadow.tp.service.Impl.ReadXml;
import cn.SkyShadow.tp.service.ReadConfigFile;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 * ENUM
 * Created by Richard on 16/9/19.
 */
public enum ResultMapper {
    SUCCESS(),
    User_UnLogin(),
    User_LoginING(),
    User_Login_State_Online(),
    User_Login_State_Offline(),
    User_Login_Fail(),
    User_ModifyPsd_WrongOldPsd(),
    User_ModifyPsd_Password_Format(),
    User_ResultMapper_Opened(),
    User_ResultMapper_Closed(),
    User_Register_UserName_Exit(),
    User_Register_UserName_Format(),
    Public_IMG_CODE_Error(),
    Public_Email_Format(),
    Public_Email_Exist(),
    Public_Email_Validated(),
    Public_No_PasswordProtectedKey(),
    Public_OverTime(),
    Public_Email_UnValidated(),
    Public_Email_OverLocking(),
    Public_Email_MessageSendFail(),
    Public_Email_Error_code(),
    Public_Phone_UnValidated(),
    Public_Phone_OverLocking(),
    Public_Phone_MessageSendFail(),
    Public_Phone_Error_code(),
    Public_ILLEGAL_LOCATION(),
    Public_Phone_Format(),
    Public_Phone_Exist(),
    Public_Phone_Validated(),
    Org_NULL_ORG(),
    Org_NULL_User_ID(),
    Org_FORMAT_NAME(),
    Org_ILLEGAL_NAME(),
    Org_ILLEGAL_PARENT(),
    Org_NULL_LOCATION(),
    DB_ERROR()

    ;
    private boolean isSuccess;
    private int code;
    private String info;
    private String resultName;
    private ReadConfigFile readConfigFile = new ReadXml();

    public String getResultName() {
        return resultName;
    }


    ResultMapper() {
        read();
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
    private void read(){
        try {
            this.resultName = this.name();
            readConfigFile.setPath("/resultConfig/result.xml");
            Node node = (Node) readConfigFile.getValue(this.name());
            NodeList childNode = node.getChildNodes();
            for (int j = 0;j<childNode.getLength();j++){
                Node node1 = childNode.item(j);
                if (node1.getNodeType()==Node.ELEMENT_NODE){
                    if (node1.getFirstChild().getNodeName().equals("code")){
                        this.code = Integer.parseInt(node1.getFirstChild().getNodeValue());
                    }
                    if (node1.getFirstChild().getNodeName().equals("info")){
                        this.info = node1.getFirstChild().getNodeValue();
                    }
                    if (node1.getFirstChild().getNodeName().equals("isSuccess")){
                        this.isSuccess = node1.getFirstChild().getNodeValue().toUpperCase().equals("TRUE");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
