package cc.mrbird.febs.news.service.Impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.news.entity.BusinessNews;
import cc.mrbird.febs.news.mapper.BusinessNewsMapper;
import cc.mrbird.febs.news.service.IBusinessNewsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author MrBird
 */
@Service("BusinessNewsService")
public class BusinessNewsServiceImpl extends ServiceImpl<BusinessNewsMapper, BusinessNews> implements IBusinessNewsService {

    @Override
    public IPage<BusinessNews> findBusinessNews(BusinessNews businessNews, QueryRequest request) {
        QueryWrapper<BusinessNews> queryWrapper = new QueryWrapper<>();

        Page<BusinessNews> page = new Page<>(request.getPageNum(), request.getPageSize());
        return page(page, queryWrapper);
    }
}
