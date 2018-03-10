package com.thpffcj.web.controller;

import com.thpffcj.base.ApiResponse;
import com.thpffcj.entity.Show;
import com.thpffcj.service.MemberService;
import com.thpffcj.service.ShowService;
import com.thpffcj.service.VenueService;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.MemberDto;
import com.thpffcj.web.dto.ShowDto;
import com.thpffcj.web.dto.VenueDto;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
            return ApiResponse.ofSuccess("");
        } else {
            return ApiResponse.ofMessage(HttpStatus.SC_BAD_REQUEST, result.getMessage());
        }
    }

    @GetMapping("/center")
    public String centerPage() {
        return "member/center";
    }

    @GetMapping("/profile")
    public String profile(HttpSession session, Model model) {
        Long id = 1L;
        model.addAttribute("member", memberService.getMemberProfile(id).getResult());
        return "member/profile";
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
}
