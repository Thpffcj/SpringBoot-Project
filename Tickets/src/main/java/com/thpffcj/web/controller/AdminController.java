package com.thpffcj.web.controller;

import com.thpffcj.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Thpffcj on 2018/3/5.
 */
@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 审核页面
     * @return
     */
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("opens", adminService.getAllOpenApplication().getResult());
        model.addAttribute("edits" , adminService.getAllModifyApplication().getResult());
        return "admin/index";
    }

    /**
     * 结算页面
     * @param model
     * @return
     */
    @GetMapping(value = "/settlements")
    public String settlements(Model model) {
//        model.addAttribute("settlements", adminService.settleAccounts());

        return "manager/settlement";
    }

}
