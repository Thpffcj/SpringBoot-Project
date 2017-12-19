package site.web.site.controller;

import groupon.deal.service.DealCategoryService;
import groupon.deal.service.DealService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Thpffcj on 2017/10/12.
 */
@Controller
public class IndexController {

    @Autowired
    private DealService dealService;

    @Autowired
    private DealCategoryService categoryService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {

        // 1.分类
        // 2.首页商品
        // 3.每个大分类下显示8个商品

        return "index";
    }
}
