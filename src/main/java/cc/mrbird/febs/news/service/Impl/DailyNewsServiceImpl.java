package cc.mrbird.febs.news.service.Impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.news.entity.DailyNews;
import cc.mrbird.febs.news.mapper.DailyNewsMapper;
import cc.mrbird.febs.news.service.IDailyNewsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author MrBird
 */
@Service("DailyNewsService")
public class DailyNewsServiceImpl extends ServiceImpl<DailyNewsMapper, DailyNews> implements IDailyNewsService {

    @Override
    public IPage<DailyNews> findDailyNews(DailyNews dailyNews, QueryRequest request) {
        QueryWrapper<DailyNews> queryWrapper = new QueryWrapper<>();

        Page<DailyNews> page = new Page<>(request.getPageNum(), request.getPageSize());
        return page(page, queryWrapper);
    }
}
