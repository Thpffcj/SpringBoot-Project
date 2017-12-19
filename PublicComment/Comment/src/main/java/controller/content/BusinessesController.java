package controller.content;

import constant.DicTypeConst;
import constant.PageCodeEnum;
import dto.BusinessDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import service.BusinessService;
import service.DicService;

import javax.annotation.Resource;

/**
 * Created by Thpffcj on 2017/9/25.
 */
@Controller
@RequestMapping("/businesses")
public class BusinessesController {

    @Resource
    private DicService dicService;

    @Resource
    private BusinessService businessService;

    /**
     * 商户列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public String search(BusinessDto dto) {
        return "/content/businessList";
    }

    /**
     * 删除商户
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String remove(@PathVariable("id") Long id) {
        System.out.println(id);
        return "/content/businessList";
    }

    /**
     * 商户新增页初始化
     */
    @RequestMapping(value = "/addPage", method = RequestMethod.GET)
    public String addInit(Model model) {
        return "/content/businessAdd";
    }

    /**
     * 商户新增
     */
    @RequestMapping(method = RequestMethod.POST)
    public String add(BusinessDto dto,RedirectAttributes attr) {
        if(businessService.add(dto)) {
            attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_SUCCESS);
            return "redirect:/businesses";
        } else {
            attr.addAttribute(PageCodeEnum.KEY, PageCodeEnum.ADD_FAIL);
            return "redirect:/businesses/addPage";
        }
    }

    /**
     * 商户修改页初始化
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String modifyInit(Model model, @PathVariable("id") Long id) {
        model.addAttribute("cityList", dicService.getListByType(DicTypeConst.CITY));
        model.addAttribute("categoryList", dicService.getListByType(DicTypeConst.CATEGORY));
        model.addAttribute("modifyObj", businessService.getById(id));
        return "/content/businessModify";
    }

    /**
     * 商户修改
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public String modify(@PathVariable("id") Long id, BusinessDto dto) {
        System.out.println(id);
        return "/content/businessModify";
    }
}
