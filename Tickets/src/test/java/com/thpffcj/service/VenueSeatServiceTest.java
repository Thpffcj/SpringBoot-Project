package com.thpffcj.service;

import com.thpffcj.BaseTest;
import com.thpffcj.web.form.VenueSeatForm;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public class VenueSeatServiceTest extends BaseTest {

    @Autowired
    private VenueSeatService venueSeatService;

    @Test
    public void addSeat() {
        VenueSeatForm venueSeatForm = new VenueSeatForm();
        venueSeatForm.setName("测试");
        venueSeatForm.setNumber(100);
        venueSeatForm.setPrice(998);
        venueSeatService.addSeat(venueSeatForm);
    }
}