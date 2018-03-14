package com.thpffcj.web.controller;

import com.thpffcj.base.ApiResponse;
import com.thpffcj.service.AdminService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.web.dto.VenueFinanceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

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
        model.addAttribute("settlements", adminService.settleAccounts().getResult());
        return "admin/settle-account";
    }

    /**
     * 查看Tickets统计信息
     * @return
     */
    @GetMapping("/statistics")
    public String statistics() {
        return "admin/statistics";
    }

    @GetMapping("/venueShowTimes")
    @ResponseBody
    public ApiResponse getVenueShowTimes() {
        Map<String, Object> result = new HashMap<>();
        ServiceMultiResult<VenueFinanceDto> serviceMultiResult  = adminService.venueStatistics();
        serviceMultiResult.getResult().forEach(venueFinanceDto -> {
            result.put(String.valueOf(venueFinanceDto.getVenueId()), venueFinanceDto.getShowNumber());
        });
        return ApiResponse.ofSuccess(result);
    }

    @GetMapping("/venueShowIncome")
    @ResponseBody
    public ApiResponse getVenueShowIncome() {
        Map<String, Object> result = new HashMap<>();
        ServiceMultiResult<VenueFinanceDto> serviceMultiResult  = adminService.venueStatistics();
        serviceMultiResult.getResult().forEach(venueFinanceDto -> {
            result.put(String.valueOf(venueFinanceDto.getVenueId()), venueFinanceDto.getTotalBenefit());
        });
        return ApiResponse.ofSuccess(result);
    }

}
