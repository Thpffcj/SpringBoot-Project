package cn.edu.nju.controller;

import cn.edu.nju.domain.Blog;
import cn.edu.nju.repository.BlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Thpffcj on 2017/10/23.
 */
@RestController
@RequestMapping("/blogs")
public class BlogController {

    @Autowired
    private BlogRepository blogRepository;

    @GetMapping
    public String listBlogs(@RequestParam(value="order",required=false,defaultValue="new") String order,
                            @RequestParam(value="keyword",required=false,defaultValue="" ) String keyword) {
        System.out.println("order:" +order + ";keyword:" +keyword );
        return "redirect:/index?order="+order+"&keyword="+keyword;
    }
}
