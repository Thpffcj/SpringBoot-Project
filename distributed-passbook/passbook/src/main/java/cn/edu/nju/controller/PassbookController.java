package cn.edu.nju.controller;

import cn.edu.nju.log.LogConstants;
import cn.edu.nju.log.LogGenerator;
import cn.edu.nju.service.IFeedbackService;
import cn.edu.nju.service.IGainPassTemplateService;
import cn.edu.nju.service.IInventoryService;
import cn.edu.nju.service.IUserPassService;
import cn.edu.nju.vo.Feedback;
import cn.edu.nju.vo.GainPassTemplateRequest;
import cn.edu.nju.vo.Pass;
import cn.edu.nju.vo.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * Passbook Rest Controller
 * Created by thpffcj on 2019-05-12.
 */
@Slf4j
@RestController
@RequestMapping("/passbook")
public class PassbookController {

    // 用户优惠券服务
    private final IUserPassService userPassService;

    // 优惠券库存服务
    private final IInventoryService iInventoryService;

    // 领取优惠券服务
    private final IGainPassTemplateService gainPassTemplateService;

    // 反馈服务
    private final IFeedbackService feedbackService;

    // HttpServletRequest
    private final HttpServletRequest httpServletRequest;

    @Autowired
    public PassbookController(IUserPassService userPassService, IInventoryService iInventoryService, IGainPassTemplateService gainPassTemplateService, IFeedbackService feedbackService, HttpServletRequest httpServletRequest) {
        this.userPassService = userPassService;
        this.iInventoryService = iInventoryService;
        this.feedbackService = feedbackService;
        this.gainPassTemplateService = gainPassTemplateService;
        this.httpServletRequest = httpServletRequest;
    }

    /**
     * 获取用户个人的优惠券信息
     * @param userId 用户 id
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/userpassinfo")
    Response userPassInfo(Long userId) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                userId, LogConstants.ActionName.USER_PASS_INFO,
                null
        );
        return userPassService.getUserPassInfo(userId);
    }

    /**
     * 获取用户使用了的优惠券信息
     * @param userId 用户id
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/userusedpassinfo")
    Response userUsedPassInfo(Long userId) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                userId, LogConstants.ActionName.USER_USED_PASS_INFO,
                null
        );
        return userPassService.getUserUsedPassInfo(userId);
    }

    /**
     * 用户使用优惠券
     * @param pass {@link Pass}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/userusepass")
    Response userUsePass(Pass pass) {

        LogGenerator.genLog(
                httpServletRequest,
                pass.getUserId(), LogConstants.ActionName.USER_PASS_INFO,
                pass
        );
        return userPassService.UserUsePass(pass);
    }

    /**
     * 获取库存信息
     * @param userId 用户 id
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/inventoryinfo")
    Response inventoryInfo(Long userId) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                userId, LogConstants.ActionName.INVENTORY_INFO,
                null
        );
        return iInventoryService.getInventoryInfo(userId);
    }

    /**
     * 用户领取优惠券
     * @param request {@link GainPassTemplateRequest}
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @PostMapping("/gainpasstemplate")
    Response gainPassTemplate(@RequestBody GainPassTemplateRequest request) throws Exception {

        LogGenerator.genLog(
                httpServletRequest,
                request.getUserId(), LogConstants.ActionName.GAIN_PASS_TEMPLATE,
                request
        );
        return gainPassTemplateService.gainPassTemplate(request);
    }

    /**
     * 用户创建评论
     * @param feedback {@link Feedback}
     * @return {@link Response}
     */
    @ResponseBody
    @PostMapping("/createfeedback")
    Response createFeedback(@RequestBody Feedback feedback) {
        LogGenerator.genLog(
                httpServletRequest,
                feedback.getUserId(), LogConstants.ActionName.CREATE_FEEDBACK,
                feedback
        );
        return feedbackService.createFeedback(feedback);
    }

    /**
     * 用户获取评论信息
     * @param userId 用户 id
     * @return {@link Response}
     */
    @ResponseBody
    @GetMapping("/getfeedback")
    Response getFeedback(Long userId) {

        LogGenerator.genLog(
                httpServletRequest,
                userId, LogConstants.ActionName.GET_FEEDBACK,
                null
        );
        return feedbackService.getFeedback(userId);
    }

    /**
     * 异常演示接口
     * @return {@link Response}
     * @throws Exception
     */
    @ResponseBody
    @GetMapping("/exception")
    Response exception() throws Exception {
        throw new Exception("Welcome everyone");
    }
}
