package com.study.information_push.service;

import com.study.information_push.core.BaseDao;
import com.study.information_push.dao.PushConfigDao;
import com.study.information_push.entity.PushConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author sdy
 * @date 2019/4/19 9:49
 */
@Service
public class PushConfigService extends BaseService<PushConfig>{
    @Resource
    private PushConfigDao pushConfigDao;
    @Override
    protected BaseDao<PushConfig> getDao() {
        return pushConfigDao;
    }
}
