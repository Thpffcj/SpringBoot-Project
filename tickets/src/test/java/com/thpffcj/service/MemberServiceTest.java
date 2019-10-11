package com.thpffcj.service;

import com.thpffcj.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/3/4.
 */
public class MemberServiceTest extends BaseTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void seatReservation() {
    }

    @Test
    public void edit() {
        memberService.edit(1L, "thpffcj", "123");
    }
}