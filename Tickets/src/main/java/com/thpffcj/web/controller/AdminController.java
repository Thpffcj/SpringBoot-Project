package com.thpffcj.web.controller;

import com.thpffcj.base.ApiResponse;
import com.thpffcj.service.AdminService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.VenueFinanceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
     *
     * @return
     */
    @GetMapping("/index")
    public String index(Model model) {
        model.addAttribute("opens", adminService.getAllOpenApplication().getResult());
        model.addAttribute("edits", adminService.getAllModifyApplication().getResult());
        return "admin/index";
    }

    /**
     * 通过或拒绝场馆申请
     *
     * @param isApprove
     * @param venueId
     * @return
     */
    @PostMapping("/approve")
    @ResponseBody
    public ApiResponse approve(boolean isApprove, Long venueId) {
        ServiceResult serviceResult = adminService.auditingVenue(isApprove, venueId);
        return ApiResponse.ofSuccess(serviceResult);
    }

    /**
     * 结算页面
     *
     * @param model
     * @return
     */
    @GetMapping(value = "/settlements")
    public String settlements(Model model) {
        model.addAttribute("settlements", adminService.settleAccounts().getResult());
        return "admin/settle-account";
    }

    /**
     * 对演出进行结算
     *
     * @param isApprove
     * @param showName
     * @return
     */
    @PostMapping("/settlements")
    @ResponseBody
    public ApiResponse settlementShow(boolean isApprove, String showName) {
        ServiceResult serviceResult = adminService.settlement(isApprove, showName);
        return ApiResponse.ofSuccess(serviceResult);
    }

    /**
     * 查看Tickets统计信息
     *
     * @return
     */
    @GetMapping("/statistics")
    public String statistics() {
        return "admin/statistics";
    }

    /**
     * 场馆演出次数统计
     *
     * @return
     */
    @GetMapping("/venueShowTimes")
    @ResponseBody
    public ApiResponse getVenueShowTimes() {
        Map<String, Object> result = new HashMap<>();
        ServiceMultiResult<VenueFinanceDto> serviceMultiResult = adminService.venueStatistics();
        serviceMultiResult.getResult().forEach(venueFinanceDto -> {
            result.put(String.valueOf(venueFinanceDto.getVenueId()), venueFinanceDto.getShowNumber());
        });
        return ApiResponse.ofSuccess(result);
    }

    /**
     * 场馆演出收入统计
     *
     * @return
     */
    @GetMapping("/venueShowIncome")
    @ResponseBody
    public ApiResponse getVenueShowIncome() {
        Map<String, Object> result = new HashMap<>();
        ServiceMultiResult<VenueFinanceDto> serviceMultiResult = adminService.venueStatistics();
        serviceMultiResult.getResult().forEach(venueFinanceDto -> {
            result.put(String.valueOf(venueFinanceDto.getVenueId()), venueFinanceDto.getTotalBenefit());
        });
        return ApiResponse.ofSuccess(result);
    }

    /**
     * 会员等级分布统计
     *
     * @return
     */
    @GetMapping("/memberLevel")
    @ResponseBody
    public ApiResponse getMemberLevel() {
        Map<String, Object> result = new HashMap<>();
        result.put("等级1", 50);
        result.put("等级2", 56);
        result.put("等级3", 39);
        result.put("等级4", 12);
        return ApiResponse.ofSuccess(result);
    }

}
