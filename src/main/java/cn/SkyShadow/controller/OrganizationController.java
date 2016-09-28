package cn.SkyShadow.controller;

import cn.SkyShadow.basic_component.ExceptionHandler;
import cn.SkyShadow.dto.json.JsonResult;
import cn.SkyShadow.factory.ExecutionFactory;
import cn.SkyShadow.factory.JsonResultFactory;
import cn.SkyShadow.enums.MaxWrongNumEnum;
import cn.SkyShadow.enums.ResultMapper;
import cn.SkyShadow.model.Organization;
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

    @Autowired
    public OrganizationController(OrgService orgService, ExceptionHandler exceptionHandle, KaptchaService kaptchaService, CheckService checkService) {
        this.orgService = orgService;
        this.exceptionHandle = exceptionHandle;
        this.kaptchaService = kaptchaService;
        this.checkService = checkService;
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
    @RequestMapping(value = "/{orgId}/getBaseInfo", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> method(@PathVariable("orgId") Long orgId){
        try {
            return JsonResultFactory.CreateJsonResult_True(orgService.getBaseInfo(orgId));
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
