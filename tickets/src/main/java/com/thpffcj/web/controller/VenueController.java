package com.thpffcj.web.controller;

import com.thpffcj.base.ApiResponse;
import com.thpffcj.entity.Venue;
import com.thpffcj.service.MemberService;
import com.thpffcj.service.OrderService;
import com.thpffcj.service.ShowService;
import com.thpffcj.service.VenueService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.OrderDto;
import com.thpffcj.web.dto.ShowDto;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.form.ShowForm;
import com.thpffcj.web.form.VenueForm;
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

    @Autowired
    private ShowService showService;

    @Autowired
    private MemberService memberService;

    /**
     * 欢迎页
     *
     * @return
     */
    @GetMapping("/welcome")
    public String welcomePage() {
        return "venue/welcome";
    }

    /**
     * 后台管理中心
     *
     * @return
     */
    @GetMapping("/center")
    public String venueCenterPage(HttpSession httpSession) {
        Long managerId = (Long) httpSession.getAttribute("memberId");
        Long venueId = venueService.getVenueByManagerId(managerId).getId();
        httpSession.setAttribute("venueId", venueId);
        return "venue/center";
    }

    /**
     * 场馆主界面
     *
     * @param model
     * @param httpSession
     * @return
     */
    @GetMapping("/info")
    public String info(Model model, HttpSession httpSession) {
        Long venueId = (Long) httpSession.getAttribute("venueId");
        if (venueId == null) {
            venueId = 1000000L;
        }
        VenueDto venueDto = venueService.getVenueDtoByVenueId(venueId).getResult();
        model.addAttribute("venue", venueDto);
        return "venue/info";
    }

    /**
     * 新增演出功能页
     *
     * @return
     */
    @GetMapping("/add/show")
    public String addShowPage() {
        return "venue/show-add";
    }

    /**
     * 添加演出
     *
     * @param showForm
     * @return
     */
    @PostMapping("/add/show")
    @ResponseBody
    public ApiResponse addShow(HttpSession session,
                               @ModelAttribute("form-show-add") ShowForm showForm) {
        Long venueId = (Long) session.getAttribute("venueId");
        ServiceResult<ShowDto> result = showService.releasePlan(venueId, showForm);
        return ApiResponse.ofSuccess(result);
    }

    /**
     * 新增场馆
     *
     * @return
     */
    @GetMapping("/add/venue")
    public String addVenuePage() {
        return "venue/venue-add";
    }

    /**
     * 添加场馆
     *
     * @return
     */
    @PostMapping("/add/venue")
    @ResponseBody
    public ApiResponse addVenue(@ModelAttribute("form-venue-add") VenueForm venueForm) {
        ServiceResult<VenueDto> result = venueService.save(venueForm);
        return ApiResponse.ofSuccess(result);
    }

    /**
     * 修改场馆信息
     *
     * @return
     */
    @PostMapping("/edit")
    public String editVenue(HttpSession session, Model model,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "address") String address,
                            @RequestParam(value = "description") String description) {
        Long venueId = (Long) session.getAttribute("venueId");
        ServiceResult<VenueDto> result = venueService.edit(venueId, name, address, description);
        VenueDto venueDto = venueService.getVenueDtoByVenueId(venueId).getResult();
        model.addAttribute("venue", venueDto);
        return "venue/info";
    }

    /**
     * 检票页面
     *
     * @return
     */
    @GetMapping("/check")
    public String checkPage() {
        return "venue/check-ticket";
    }

    /**
     * 检票
     *
     * @param orderId
     * @return
     */
    @PostMapping("/check")
    @ResponseBody
    public ApiResponse checkTicket(@RequestParam(value = "orderId") Long orderId) {
        ServiceResult<OrderDto> result = venueService.checkOrder(orderId);
        return ApiResponse.ofSuccess(result);
    }

    /**
     * 现场购票
     *
     * @return
     */
    @GetMapping("/buy")
    public String buyTicketPage() {
        return "venue/buy-ticket";
    }

    @PostMapping("/buy")
    @ResponseBody
    public ApiResponse buyTicket(@RequestParam(value = "showId") Long showId,
                                 @RequestParam(value = "memberId") Long memberId,
                                 @RequestParam(value = "type") String type,
                                 @RequestParam(value = "number") int number) {
        if (type.equals("不选座")) {
            type = "看台";
        }
        ServiceResult<OrderDto> result = memberService.seatReservation(memberId, showId, type, number);
        return ApiResponse.ofSuccess(result.getResult());
    }

    /**
     * 查看场馆订票退票情况
     *
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/statistics")
    public String statistics(HttpSession session, Model model) {
        Long venueId = (Long) session.getAttribute("venueId");
        if (venueId == null) {
            venueId = 1000000L;
        }
        ServiceMultiResult<OrderDto> bookOrderDto = orderService.getAllVenueBookOrder(venueId);
        ServiceMultiResult<OrderDto> refundOrderDto = orderService.getAllVenueRefundOrder(venueId);
        model.addAttribute("bookOrders", bookOrderDto.getResult());
        model.addAttribute("refundOrders", refundOrderDto.getResult());
        return "venue/statistics";
    }
}
