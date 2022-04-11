package cc.mrbird.febs.news.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.news.entity.NightNews;
import cc.mrbird.febs.news.service.INightNewsService;
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
@RequestMapping("NightNewsMapper")
@RequiredArgsConstructor
public class NightNewsController extends BaseController {

    private final INightNewsService nightNewsService;

    @GetMapping("list")
    @RequiresPermissions("nightNews:view")
    public FebsResponse nightNewsList(NightNews nightNews, QueryRequest request) {
        return new FebsResponse().success()
                .data(getDataTable(nightNewsService.findNightNews(nightNews, request)));
    }
}
