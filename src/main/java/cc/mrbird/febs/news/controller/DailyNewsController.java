package cc.mrbird.febs.news.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.news.entity.DailyNews;
import cc.mrbird.febs.news.service.IDailyNewsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author MrBird
 */
@Slf4j
@RestController
@RequestMapping("DailyNewsMapper")
@RequiredArgsConstructor
public class DailyNewsController extends BaseController {

    private final IDailyNewsService dailyNewsService;

    @GetMapping("list")
    @RequiresPermissions("dailyNews:view")
    public FebsResponse dailyNewsList(DailyNews dailyNews, QueryRequest request) {
        return new FebsResponse().success()
                .data(getDataTable(dailyNewsService.findDailyNews(dailyNews, request)));
    }
}
