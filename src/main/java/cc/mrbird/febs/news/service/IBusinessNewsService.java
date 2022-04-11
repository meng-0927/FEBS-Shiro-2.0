package cc.mrbird.febs.news.service;

import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.news.entity.BusinessNews;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author MrBird
 */
public interface IBusinessNewsService extends IService<BusinessNews> {

    /**
     * 获取登录日志分页信息
     *
     * @param loginLog 传参
     * @param request  request
     * @return IPage<BusinessNews>
     */
    IPage<BusinessNews> findBusinessNews(BusinessNews dailyNews, QueryRequest request);

  
  
}
