package cc.mrbird.febs.news.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.news.entity.NightNews;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author MrBird
 */
public interface INightNewsService extends IService<NightNews> {

    /**
     * 获取登录日志分页信息
     *
     * @param loginLog 传参
     * @param request  request
     * @return IPage<NightNews>
     */
    IPage<NightNews> findNightNews(NightNews nightNews, QueryRequest request);

  
  
}
