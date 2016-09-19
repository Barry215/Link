package cn.SkyShadow.controller;

import cn.SkyShadow.basic_component.Impl.AjaxCommonComponent;
import cn.SkyShadow.basic_component.OperationInterceptor;
import cn.SkyShadow.dto.JsonResult;
import cn.SkyShadow.dto.factory.ExecutionFactory;
import cn.SkyShadow.dto.factory.JsonResultFactory;
import cn.SkyShadow.dto.factory.OperaFactory;
import cn.SkyShadow.dto.opera.OperaObject;
import cn.SkyShadow.enums.MaxWrongNumEnum;
import cn.SkyShadow.enums.OperationByAuthorityEnum;
import cn.SkyShadow.enums.OrgCreateResultEnum;
import cn.SkyShadow.model.organization;
import cn.SkyShadow.model.user;
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
    private final AjaxCommonComponent ajaxCommonComponent;
    private final KaptchaService kaptchaService;
    private final CheckService checkService;
    private final OperationInterceptor operationInterceptor;
    @Autowired
    public OrganizationController(OrgService orgService, KaptchaService kaptchaService, CheckService checkService, OperationInterceptor operationInterceptor) {
        this.orgService = orgService;
        this.kaptchaService = kaptchaService;
        this.checkService = checkService;
        this.operationInterceptor = operationInterceptor;
        this.ajaxCommonComponent = new AjaxCommonComponent(this.getClass());
    }
    @RequestMapping(value = "/{name}/hasOrgName", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> HasOrgName(@PathVariable("name") String name){
        try {
            String result = orgService.HasOrgName(name);
            return  JsonResultFactory.CreateJsonResult_True(result);
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
    @RequestMapping(value = "/{code}/CreateOrganization", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> CreateOrganization(HttpSession session,@PathVariable("code") String code, @RequestBody organization organization){
        try {
            if (!checkService.LoginState(session)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.NO_LOGIN));
            }
            if (kaptchaService.check(session,code, MaxWrongNumEnum.CREATE_ORG)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.IMG_CODE));
            }
            return  JsonResultFactory.CreateJsonResult_True(orgService.CreateNewOrg(organization));
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
    @RequestMapping(value = "/{code}/ModifyOrg", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> ModifyOrg(HttpSession session,@PathVariable("code") String code, @RequestBody organization organization){
        try {
            if (kaptchaService.check(session,code,MaxWrongNumEnum.MODIFY_ORG)){

            }
            user user = checkService.LoginSate(session);
            if (user==null){

            }
            OperationByAuthorityEnum op = OperationByAuthorityEnum.MODIFY_ORGANIZATION;
            organization baseinfo = orgService.getBaseInfo(organization.getOrgId());
            OperaObject operaObject = OperaFactory.createByUserAndOrg(user,baseinfo);
            if (operationInterceptor.checkFull(operaObject,op)){

            }
            if (operationInterceptor.checkApply_AVAIl(operaObject,op)){

            }
            if (operationInterceptor.checkNULL(operaObject,op)){

            }
            return null;
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
    /*@RequestMapping(value = "/{ABCD}/ABCD", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> ABCD(String ABCD){
        try {

        } catch (exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }*/
}
