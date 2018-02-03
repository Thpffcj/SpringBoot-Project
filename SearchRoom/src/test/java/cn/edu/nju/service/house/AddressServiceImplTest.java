package cn.edu.nju.service.house;

import cn.edu.nju.ApplicationTests;
import cn.edu.nju.service.ServiceResult;
import cn.edu.nju.service.search.BaiduMapLocation;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

/**
 * Created by Thpffcj on 2018/1/31.
 */
public class AddressServiceImplTest extends ApplicationTests {

    @Autowired
    private IAddressService addressService;

    @Test
    public void getBaiduMapLocation() {

        String city = "北京";
        String address = "北京市昌平区巩华家园1号楼2单元";
        ServiceResult<BaiduMapLocation> serviceResult = addressService.getBaiduMapLocation(city, address);

        Assert.assertTrue(serviceResult.isSuccess());

        Assert.assertTrue(serviceResult.getResult().getLongitude() > 0 );
        Assert.assertTrue(serviceResult.getResult().getLatitude() > 0 );
    }
}