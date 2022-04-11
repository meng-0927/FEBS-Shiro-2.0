package cc.mrbird.febs.news.controller;

import cc.mrbird.febs.common.entity.FebsConstant;
import cc.mrbird.febs.common.utils.FebsUtil;
import cc.mrbird.febs.monitor.helper.FebsActuatorHelper;
import lombok.RequiredArgsConstructor;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author MrBird
 */
@Controller("newsView")
@RequestMapping(FebsConstant.VIEW_PREFIX + "news")
@RequiredArgsConstructor
public class ViewController {

    private final FebsActuatorHelper actuatorHelper;

    @GetMapping("dailyNews")
    @RequiresPermissions("dailyNews:view")
    public String daily() {
        return FebsUtil.view("news/dailyNews");
    }

    @GetMapping("nightNews")
    @RequiresPermissions("nightNews:view")
    public String night() {
        return FebsUtil.view("news/nightNews");
    }

    @GetMapping("shangBao")
    @RequiresPermissions("shangBao:view")
    public String Business() {
        return FebsUtil.view("news/shangBao");
    }
}
