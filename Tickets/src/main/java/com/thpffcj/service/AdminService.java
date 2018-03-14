package com.thpffcj.service;

import com.thpffcj.service.result.ServiceMultiResult;
import com.thpffcj.service.result.ServiceResult;
import com.thpffcj.web.dto.MemberDto;
import com.thpffcj.web.dto.SettleAccountDto;
import com.thpffcj.web.dto.VenueDto;
import com.thpffcj.web.dto.VenueFinanceDto;

/**
 * Created by Thpffcj on 2018/3/5.
 */
public interface AdminService {

    /**
     * 列出待审核场馆
     * @return
     */
    ServiceMultiResult<VenueDto> getAllOpenApplication();

    /**
     * 列出修改场馆信息的申请
     * @return
     */
    ServiceMultiResult<VenueDto> getAllModifyApplication();

    /**
     * 审核场馆
     * @param venueId
     * @return
     */
    ServiceResult auditingVenue(Long venueId);

    /**
     * 结算
     * @return
     */
    ServiceMultiResult<SettleAccountDto> settleAccounts();

    /**
     * 场馆统计信息
     * @return
     */
    ServiceMultiResult<VenueFinanceDto> venueStatistics();

    ServiceMultiResult<MemberDto> memberStatistics();
}
