package com.study.information_push.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.study.information_push.core.BaseDao;
import com.study.information_push.core.LayuiPageParam;
import com.study.information_push.dao.first.PushConfigDao;
import com.study.information_push.entity.first.PushConfig;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

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

    public PageInfo<PushConfig> seletAll(LayuiPageParam pageParam){
        PageHelper.startPage(pageParam.getPage(),pageParam.getLimit());
        List<PushConfig> list = pushConfigDao.selectAll();
        return new PageInfo<PushConfig>(list);
    }
}
