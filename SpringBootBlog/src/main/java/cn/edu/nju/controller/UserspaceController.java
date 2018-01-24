package cn.edu.nju.controller;

import org.springframework.web.bind.annotation.*;

/**
 * Created by Thpffcj on 2017/10/24.
 */
@RestController
@RequestMapping("/u")
public class UserspaceController {

    @GetMapping("/{username}")
    public String userSpace(@PathVariable("username") String username) {
        System.out.println("username" + username);
        return "u";
    }

    @GetMapping("/{username}/blogs")
    public String listBlogsByOrder(@PathVariable("username") String username,
                                   @RequestParam(value = "order", required = false, defaultValue = "new") String order,
                                   @RequestParam(value = "category", required = false) Long category,
                                   @RequestParam(value = "keyword", required = false) String keyword) {

        if (category != null) {

            System.out.print("category:" + category);
            System.out.print("selflink:" + "redirect:/u/" + username + "/blogs?category=" + category);
            return "/u";

        } else if (keyword != null && keyword.isEmpty() == false) {

            System.out.print("keyword:" + keyword);
            System.out.print("selflink:" + "redirect:/u/" + username + "/blogs?keyword=" + keyword);
            return "/u";
        }

        System.out.print("order:" + order);
        System.out.print("selflink:" + "redirect:/u/" + username + "/blogs?order=" + order);
        return "/u";
    }

    @GetMapping("/{username}/blogs/{id}")
    public String listBlogsByOrder(@PathVariable("id") Long id) {

        System.out.print("blogId:" + id);
        return "/blog";
    }


    @GetMapping("/{username}/blogs/edit")
    public String editBlog() {

        return "/blogedit";
    }
}
