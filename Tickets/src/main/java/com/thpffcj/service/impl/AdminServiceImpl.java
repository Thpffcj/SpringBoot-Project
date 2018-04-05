package com.thpffcj.service.impl;

import com.thpffcj.base.ShowStatus;
import com.thpffcj.base.VenueStatus;
import com.thpffcj.entity.Member;
import com.thpffcj.entity.Show;
import com.thpffcj.entity.Venue;
import com.thpffcj.entity.VenueFinance;
import com.thpffcj.service.*;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.MemberDto;
import com.thpffcj.web.dto.SettleAccountDto;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.dto.VenueFinanceDto;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thpffcj on 2018/3/5.
 */
@Service
public class AdminServiceImpl implements AdminService {

    public static final double RADIO = 0.9;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VenueService venueService;

    @Autowired
    private VenueFinanceService venueFinanceService;

    @Autowired
    private MemberService memberService;

    @Autowired
    private ShowService showService;

    /**
     * 查找待审核的场馆
     * @return
     */
    @Override
    public ServiceMultiResult<VenueDto> getAllOpenApplication() {
        List<Venue> venues = venueService.getVenueByStatus(VenueStatus.NOT_AUDITED.getValue());
        List<VenueDto> result = new ArrayList<>();
        venues.forEach(venue -> {
            VenueDto venueDto = modelMapper.map(venue, VenueDto.class);
            result.add(venueDto);
        });
        return new ServiceMultiResult<>(result.size(), result);
    }

    /**
     * 查看修改信息待审核的场馆
     * @return
     */
    @Override
    public ServiceMultiResult<VenueDto> getAllModifyApplication() {
        List<Venue> venues = venueService.getVenueByStatus(VenueStatus.MODIFY.getValue());
        List<VenueDto> result = new ArrayList<>();
        venues.forEach(venue -> {
            VenueDto venueDto = modelMapper.map(venue, VenueDto.class);
            result.add(venueDto);
        });
        return new ServiceMultiResult<>(result.size(), result);
    }

    /**
     * 审核场馆
     * @param isApprove
     * @param venueId
     * @return
     */
    @Override
    public ServiceResult auditingVenue(boolean isApprove, Long venueId) {
        if (isApprove) {
            venueService.updateVenueStatus(venueId, VenueStatus.PASSES.getValue());
        } else {
            venueService.updateVenueStatus(venueId, VenueStatus.DENY.getValue());
        }
        return ServiceResult.success();
    }

    /**
     * 找到未结算演出
     * @return
     */
    @Override
    public ServiceMultiResult<SettleAccountDto> settleAccounts() {
        List<SettleAccountDto> result = new ArrayList<>();
        List<Show> shows = showService.getUnsettlementShow();
        shows.forEach(show -> {
            SettleAccountDto settleAccountDto = new SettleAccountDto();
            settleAccountDto.setVenueName(venueService.getVenueByVenueId(show.getVenueId()).getName());
            settleAccountDto.setShowName(show.getName());
            settleAccountDto.setPerformanceTime(show.getPerformanceTime());
            settleAccountDto.setTotalBenefit(show.getBenefit());
            settleAccountDto.setRatio(RADIO);
            settleAccountDto.setSettlementAmount(show.getBenefit() * RADIO);
            settleAccountDto.setStatus(show.getStatus());
            result.add(settleAccountDto);
        });
        return  new ServiceMultiResult<>(result.size(), result);
    }

    /**
     * 对演出进行结算
     * @param isApprove
     * @param showName
     * @return
     */
    @Override
    public ServiceResult settlement(boolean isApprove, String showName) {
        Long showId = showService.getShowByShowName(showName).getId();
        if (isApprove) {
            showService.updateShowStatus(showId, ShowStatus.SETTLEMENT.getValue());
        } else {
            showService.updateShowStatus(showId, ShowStatus.UNSETTLEMENT.getValue());
        }
        return ServiceResult.success();
    }

    /**
     * 场馆统计信息
     * @return
     */
    @Override
    public ServiceMultiResult<VenueFinanceDto> venueStatistics() {
        List<VenueFinance> venueFinances = venueFinanceService.listVenueFinance();

        List<VenueFinanceDto> result = new ArrayList<>();
        venueFinances.forEach(venueFinance -> {
            VenueFinanceDto venueFinanceDto = modelMapper.map(venueFinance, VenueFinanceDto.class);
            // TODO
//            String venueName = venueService.getVenueByVenueId(venueFinanceDto.getVenueId()).getName();
            String venueName = "测试";
            venueFinanceDto.setVenueName(venueName);
            result.add(venueFinanceDto);
        });
        return new ServiceMultiResult<>(result.size(), result);
    }

    /**
     * 会员统计信息
     * @return
     */
    @Override
    public ServiceMultiResult<MemberDto> memberStatistics() {
        List<Member> members = memberService.listMember();

        List<MemberDto> result = new ArrayList<>();
        members.forEach(member -> {
            MemberDto memberDto = modelMapper.map(member, MemberDto.class);
            result.add(memberDto);
        });
        return new ServiceMultiResult<>(result.size(), result);
    }
}
