package com.stranger.service;

import com.stranger.base.BaseService;
import com.stranger.dao.InumbersDao;
import com.stranger.domain.Numbers;
import org.springframework.stereotype.Service;

@Service
public class NumberService extends BaseService<InumbersDao, Numbers> {
}
