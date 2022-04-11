package cc.mrbird.febs.news.service.Impl;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.news.entity.NightNews;
import cc.mrbird.febs.news.mapper.NightNewsMapper;
import cc.mrbird.febs.news.service.INightNewsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @author MrBird
 */
@Service("NightNewsService")
public class NightNewsServiceImpl extends ServiceImpl<NightNewsMapper, NightNews> implements INightNewsService {

    @Override
    public IPage<NightNews> findNightNews(NightNews nightNews, QueryRequest request) {
        QueryWrapper<NightNews> queryWrapper = new QueryWrapper<>();

        Page<NightNews> page = new Page<>(request.getPageNum(), request.getPageSize());
        return page(page, queryWrapper);
    }
}
