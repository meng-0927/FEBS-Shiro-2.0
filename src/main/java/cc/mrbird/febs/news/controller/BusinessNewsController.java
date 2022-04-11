package cc.mrbird.febs.news.controller;

import cc.mrbird.febs.common.controller.BaseController;
import cc.mrbird.febs.common.entity.FebsResponse;
import cc.mrbird.febs.common.entity.QueryRequest;
import cc.mrbird.febs.news.entity.BusinessNews;
import cc.mrbird.febs.news.service.IBusinessNewsService;
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
@RequestMapping("BusinessNews")
@RequiredArgsConstructor
public class BusinessNewsController extends BaseController {

    private final IBusinessNewsService businessNewsService;

    @GetMapping("list")
    @RequiresPermissions("shangBao:view")
    public FebsResponse businessNewsList(BusinessNews businessNews, QueryRequest request) {
        return new FebsResponse().success()
                .data(getDataTable(businessNewsService.findBusinessNews(businessNews, request)));
    }
}
