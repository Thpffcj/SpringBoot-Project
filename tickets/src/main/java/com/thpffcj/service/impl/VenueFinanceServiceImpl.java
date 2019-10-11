package com.thpffcj.service.impl;

import com.thpffcj.entity.VenueFinance;
import com.thpffcj.repository.VenueFinanceRepository;
import com.thpffcj.service.VenueFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Thpffcj on 2018/3/5.
 */
@Service
public class VenueFinanceServiceImpl implements VenueFinanceService {

    @Autowired
    private VenueFinanceRepository venueFinanceRepository;

    /**
     * 列出所有场馆财务状态
     *
     * @return
     */
    @Override
    public List<VenueFinance> listVenueFinance() {
        return (List<VenueFinance>) venueFinanceRepository.findAll();
    }
}
