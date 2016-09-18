package cn.SkyShadow.controller;

import cn.SkyShadow.basic_component.Impl.AjaxCommonComponent;
import cn.SkyShadow.dto.JsonResult;
import cn.SkyShadow.dto.factory.ExecutionFactory;
import cn.SkyShadow.dto.factory.JsonResultFactory;
import cn.SkyShadow.enums.MaxWrongNumEnum;
import cn.SkyShadow.enums.OrgCreateResultEnum;
import cn.SkyShadow.model.organization;
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
    @Autowired
    public OrganizationController(OrgService orgService, KaptchaService kaptchaService) {
        this.orgService = orgService;
        this.kaptchaService = kaptchaService;
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
            if (kaptchaService.check(session,code, MaxWrongNumEnum.CREATE_ORG)){
                return JsonResultFactory.CreateJsonResult_True(ExecutionFactory.getOrgCreateExecution_False(OrgCreateResultEnum.IMG_CODE));
            }
            return  JsonResultFactory.CreateJsonResult_True(orgService.CreateNewOrg(organization));
        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }
    /*@RequestMapping(value = "/{ABCD}/ABCD", method = RequestMethod.POST, produces = { "application/json;charset=UTF-8" })
    @ResponseBody
    public JsonResult<?> ABCD(String ABCD){
        try {

        } catch (Exception e) {
            ajaxCommonComponent.ExceptionHandle(e);
            return JsonResultFactory.CreateJsonResult_False(e);
        }
    }*/
}
