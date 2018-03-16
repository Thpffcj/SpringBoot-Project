package com.thpffcj.web.controller;

import com.thpffcj.base.ApiResponse;
import com.thpffcj.service.OrderService;
import com.thpffcj.service.VenueService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.web.dto.OrderDto;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.form.ShowForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Created by Thpffcj on 2018/1/30.
 */
@Controller
@RequestMapping("/venue")
public class VenueController {

    @Autowired
    private VenueService venueService;

    @Autowired
    private OrderService orderService;

    /**
     * 欢迎页
     * @return
     */
    @GetMapping("/welcome")
    public String welcomePage() {
        return "venue/welcome";
    }

    /**
     * 后台管理中心
     * @return
     */
    @GetMapping("/center")
    public String venueCenterPage() {
        return "venue/center";
    }

    @GetMapping("/info")
    public String info(Model model, HttpSession httpSession) {

        Long id = (Long) httpSession.getAttribute("memberId");
        id = 1000000L;
        VenueDto venueDto = venueService.getVenueDtoByVenueId(id).getResult();

        model.addAttribute("venue", venueDto);

//        if (hotelService.isApplyingForEditing(id)) {
//            model.addAttribute("edit", true);
//        }
//        if (hotelService.isApplyingForOpen(id)) {
//            model.addAttribute("open", true);
//        }

        return "venue/info";
    }

    /**
     * 新增演出功能页
     * @return
     */
    @GetMapping("/add/show")
    public String addHousePage() {
        return "venue/show-add";
    }

    /**
     * 添加演出
     * @param showForm
     * @return
     */
    @PostMapping("/add/show")
    @ResponseBody
    public ApiResponse addHouse(@ModelAttribute("form-show-add") ShowForm showForm) {
        return null;
    }

    @GetMapping("/check")
    public String checkPage() {
        return "venue/check-ticket";
    }

    /**
     * 检票
     * @param memberId
     * @param showId
     * @return
     */
    @PostMapping("/check")
    @ResponseBody
    public ApiResponse checkTicket(@RequestParam(value = "memberId") String memberId,
                                   @RequestParam(value = "showId") String showId) {
        return null;
    }

    @RequestMapping("/statistics")
    public String statistics(HttpSession session, Model model) {
//        Long venueId = session.getAttribute();
        Long venueId = 1000000L;
        ServiceMultiResult<OrderDto> bookOrderDto = orderService.getAllVenueBookOrder(venueId);
        ServiceMultiResult<OrderDto> refundOrderDto = orderService.getAllVenueRefundOrder(venueId);
        model.addAttribute("bookOrders" , bookOrderDto.getResult());
        model.addAttribute("refundOrders" , refundOrderDto.getResult());
        return "venue/statistics";
    }

}
