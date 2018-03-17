package com.thpffcj.web.controller;

import com.thpffcj.base.ApiResponse;
import com.thpffcj.entity.Show;
import com.thpffcj.service.MemberService;
import com.thpffcj.service.OrderService;
import com.thpffcj.service.ShowService;
import com.thpffcj.service.VenueService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.MemberDto;
import com.thpffcj.web.dto.OrderDto;
import com.thpffcj.web.dto.ShowDto;
import com.thpffcj.web.dto.VenueDto;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * Created by Thpffcj on 2018/1/30.
 */
@Controller
@RequestMapping("/member")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @Autowired
    private ShowService showService;

    @Autowired
    private VenueService venueService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/login")
    public String loginPage() {
        return "member/login";
    }

    @PostMapping("/do_login")
    @ResponseBody
    public ApiResponse login(@RequestParam(value = "mail") String mail,
                             @RequestParam(value = "password") String password,
                             HttpSession session) {
        ServiceResult<MemberDto> result = memberService.login(mail, password);
        if (result.isSuccess()) {
            session.setAttribute("memberId", result.getResult().getId());
            return ApiResponse.ofSuccess(result.getResult());
        } else {
            return ApiResponse.ofMessage(HttpStatus.SC_BAD_REQUEST, result.getMessage());
        }
    }

    /**
     * 查看个人信息
     * @param session
     * @param model
     * @return
     */
    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("memberId");
        model.addAttribute("member", memberService.getMemberProfile(id).getResult());
        return "member/profile";
    }

    /**
     * 修改个人信息
     * @param name
     * @param password
     * @return
     */
    @PostMapping("/edit")
    @ResponseBody
    public ApiResponse edit(HttpSession session,
                            @RequestParam(value = "name") String name,
                            @RequestParam(value = "password") String password){
        Long id = (Long) session.getAttribute("memberId");
//        System.out.println("*****************");
//        System.out.println(id + " " + name + " " + password);
        ServiceResult<MemberDto> result = memberService.edit(id, name, password);
        return ApiResponse.ofSuccess(result.getResult());
    }

    /**
     * 会员资格取消
     * @param session
     * @return
     */
    @PostMapping("/delete")
    @ResponseBody
    public String delete(HttpSession session, @RequestParam(value = "password") String password) {
        Long id = (Long) session.getAttribute("memberId");
        memberService.stopMember(id);
        return "member/login";
    }


    /**
     * 演出列表
     * @param model
     * @param page
     * @return
     */
    @GetMapping("/index")
    public String index(Model model, @RequestParam(value = "page", defaultValue = "0") int page) {
        model.addAttribute("shows", showService.getShowsByPage(page).getResult());
        model.addAttribute("current", page);
        return "member/index";
    }

    /**
     * 演出详情
     * @param model
     * @param showId
     * @return
     */
    @GetMapping("/detail")
    public String detail(Model model, Long showId) {
        ShowDto showDto = showService.getShowDtoByShowId(showId).getResult();
        VenueDto venueDto = venueService.getVenueDtoByVenueId(showDto.getVenueId()).getResult();

        model.addAttribute("show", showDto);
        model.addAttribute("venue", venueDto);
        return "member/show-detail";
    }

    /**
     * 查看本人统计信息
     * @param session
     * @param model
     * @return
     */
    @RequestMapping("/statistics")
    public String statistics(HttpSession session, Model model) {
        Long id = (Long) session.getAttribute("memberId");
        ServiceMultiResult<OrderDto> bookOrderDto = orderService.getAllBookOrder(id);
        ServiceMultiResult<OrderDto> checkOrderDto = orderService.getAllCheckOrder(id);
        ServiceMultiResult<OrderDto> refundOrderDto = orderService.getAllRefundOrder(id);
        model.addAttribute("bookOrders" , bookOrderDto.getResult());
        model.addAttribute("checkOrders" , checkOrderDto.getResult());
        model.addAttribute("refundOrders" , refundOrderDto.getResult());
        return "member/statistics";
    }
}
