package com.thpffcj.service;

import com.thpffcj.BaseTest;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.form.VenueForm;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/3/2.
 */
public class VenueServiceTest extends BaseTest {

    @Autowired
    private VenueService venueService;

    @Test
    public void save() {
        VenueForm venueForm = new VenueForm();
        venueForm.setId(1000000L);
        venueForm.setPassword("123456");
        venueForm.setName("测试");
        venueForm.setAddress("测试");
        venueForm.setDescription("测试");
        ServiceResult<VenueDto> serviceResult = venueService.save(venueForm);
        Assert.assertEquals("测试", serviceResult.getResult().getAddress());
    }
}