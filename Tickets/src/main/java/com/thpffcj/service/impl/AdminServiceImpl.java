package com.thpffcj.service.impl;

import com.thpffcj.base.VenueStatus;
import com.thpffcj.entity.Member;
import com.thpffcj.entity.Venue;
import com.thpffcj.entity.VenueFinance;
import com.thpffcj.service.AdminService;
import com.thpffcj.service.MemberService;
import com.thpffcj.service.VenueFinanceService;
import com.thpffcj.service.VenueService;
import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.MemberDto;
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

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private VenueService venueService;

    @Autowired
    private VenueFinanceService venueFinanceService;

    @Autowired
    private MemberService memberService;

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
     * @param venueId
     * @return
     */
    @Override
    public ServiceResult<VenueDto> auditingVenue(Long venueId) {
        venueService.updateVenueStatus(venueId, VenueStatus.PASSES.getValue());
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
            String venueName = venueService.getVenueByVenueId(venueFinanceDto.getVenueId()).getName();
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
