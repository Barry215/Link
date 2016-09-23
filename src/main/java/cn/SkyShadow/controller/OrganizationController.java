package cn.SkyShadow.controller;

import cn.SkyShadow.basic_component.ExceptionHandler;
import cn.SkyShadow.basic_component.OperationInterceptor;
import cn.SkyShadow.dto.json.JsonResult;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.factory.JsonResultFactory;
import cn.SkyShadow.factory.OperaFactory;
import cn.SkyShadow.dto.opera.OperaObject;
import cn.SkyShadow.enums.MaxWrongNumEnum;
import cn.SkyShadow.enums.OperationByAuthorityEnum;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.Organization;
import cn.SkyShadow.model.User;
import cn.SkyShadow.service.CheckService;
import cn.SkyShadow.service.KaptchaService;
import cn.SkyShadow.service.OrgService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * 组织
 * Created by RichardW on 9/16/2016.
 */
@Transactional
@Controller
@RequestMapping("/org")
public class OrganizationController {
    private final OrgService orgService;
    private final ExceptionHandler exceptionHandle;
    private final KaptchaService kaptchaService;
    private final CheckService checkService;
    private final OperationInterceptor operationInterceptor;
    @Autowired
    public OrganizationController(OrgService orgService, ExceptionHandler exceptionHandle, KaptchaService kaptchaService, CheckService checkService, OperationInterceptor operationInterceptor) {
        this.orgService = orgService;
        this.exceptionHandle = exceptionHandle;
        this.kaptchaService = kaptchaService;
        this.checkService = checkService;
        this.operationInterceptor = operationInterceptor;
        exceptionHandle.setClass(this.getClass());
    }
    @RequestMapping(value = "/{name}/hasOrgName", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> HasOrgName(@PathVariable("name") String name){
        try {
            String result = orgService.HasOrgName(name);
            return  JsonResultFactory.CreateJsonResult_True(result);
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
    @RequestMapping(value = "/{code}/CreateOrganization", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> CreateOrganization(HttpSession session,@PathVariable("code") String code, @RequestBody Organization organization){
        try {
            if (!checkService.LoginState(session)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.User_UnLogin));
            }
            if (!kaptchaService.check(session,code, MaxWrongNumEnum.CREATE_ORG)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.Public_IMG_CODE_Error));
            }
            return  JsonResultFactory.CreateJsonResult_True(orgService.CreateNewOrg(organization));
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
    @RequestMapping(value = "/{code}/ModifyOrg", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> ModifyOrg(HttpSession session,@PathVariable("code") String code, @RequestBody Organization organization){
        try {
            if (kaptchaService.check(session,code,MaxWrongNumEnum.MODIFY_ORG)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.Public_IMG_CODE_Error));
            }
            User user = checkService.LoginSate(session);
            if (user==null){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.User_UnLogin));
            }
            OperationByAuthorityEnum op = OperationByAuthorityEnum.MODIFY_ORGANIZATION;
            Organization baseInfo = orgService.getBaseInfo(organization.getOrgId());
            OperaObject operaObject = OperaFactory.createByUserAndOrg(user,baseInfo);
            if (operationInterceptor.checkFull(operaObject,op)){
                return JsonResultFactory.CreateJsonResult_True(orgService.ModifyOrg(organization));
            }
            if (operationInterceptor.checkApply_AVAIl(operaObject,op)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.NoApply));
            }
            if (operationInterceptor.checkNULL(operaObject,op)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.NeedAuthority));
            }
            return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getExecution(ResultMapper.DB_ERROR));
        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
    /*@RequestMapping(value = "/{param}/method", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> method(String param){
        try {

        } catch (Exception e) {
            exceptionHandle.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }*/
}
