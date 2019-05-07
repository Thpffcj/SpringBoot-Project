package cn.edu.nju.biz.service;

import cn.edu.nju.biz.mapper.HouseMapper;
import cn.edu.nju.common.model.*;
import cn.edu.nju.common.page.PageData;
import cn.edu.nju.common.page.PageParams;
import cn.edu.nju.common.utils.BeanHelper;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by Thpffcj on 2018/5/5.
 */
@Service
public class HouseService {

    @Autowired
    private FileService fileService;

    @Autowired
    private AgencyService agencyService;

    @Autowired
    private MailService mailService;

    @Autowired
    private HouseMapper houseMapper;

    @Value("${file.prefix}")
    private String imgPrefix;

    /**
     * 1.查询小区
     * 2.添加图片服务器地址前缀
     * 3.构建分页结果
     *
     * @param query
     * @param pageParams
     */
    public PageData<House> queryHouse(House query, PageParams pageParams) {
        List<House> houses = Lists.newArrayList();
        if (!Strings.isNullOrEmpty(query.getName())) {
            Community community = new Community();
            community.setName(query.getName());
            List<Community> communities = houseMapper.selectCommunity(community);
            if (!communities.isEmpty()) {
                query.setCommunityId(communities.get(0).getId());
            }
        }
        houses = queryAndSetImg(query, pageParams);//添加图片服务器地址前缀
        Long count = houseMapper.selectPageCount(query);
        return PageData.buildPage(houses, count, pageParams.getPageSize(), pageParams.getPageNum());
    }

    public List<House> queryAndSetImg(House query, PageParams pageParams) {
        List<House> houses = houseMapper.selectPageHouses(query, pageParams);
        houses.forEach(h -> {
            h.setFirstImg(imgPrefix + h.getFirstImg());
//            System.out.println(h.getFirstImg());
            h.setImageList(h.getImageList().stream().map(img -> imgPrefix + img).collect(Collectors.toList()));
            h.setFloorPlanList(h.getFloorPlanList().stream().map(img -> imgPrefix + img).collect(Collectors.toList()));
        });
        return houses;
    }

    public House queryOneHouse(Long id) {
        House query = new House();
        query.setId(id);
        List<House> houses = queryAndSetImg(query, PageParams.build(1, 1));
        if (!houses.isEmpty()) {
            return houses.get(0);
        }
        return null;
    }

    public HouseUser getHouseUser(Long houseId) {
        HouseUser houseUser =  houseMapper.selectSaleHouseUser(houseId);
        return houseUser;
    }

    public void addUserMsg(UserMsg userMsg) {
        BeanHelper.onInsert(userMsg);
        houseMapper.insertUserMsg(userMsg);
        User agent = agencyService.getAgentDetail(userMsg.getAgentId());
        mailService.sendMail("来自用户" + userMsg.getEmail() + "的留言", userMsg.getMsg(), agent.getEmail());
    }
}