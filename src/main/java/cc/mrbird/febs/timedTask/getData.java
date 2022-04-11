package cc.mrbird.febs.timedTask;

import cc.mrbird.febs.news.entity.BusinessNews;
import cc.mrbird.febs.news.entity.DailyNews;
import cc.mrbird.febs.news.entity.NightNews;
import cc.mrbird.febs.news.service.IBusinessNewsService;
import cc.mrbird.febs.news.service.IDailyNewsService;
import cc.mrbird.febs.news.service.INightNewsService;
import cc.mrbird.febs.utils.RequestUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.*;

@Configuration
@EnableScheduling
public class getData {
    private String pythonUrl = "http://127.0.0.1:5000";

    @Resource
    private IDailyNewsService iDailyNewsService;
    @Resource
    private INightNewsService iNightNewsService;
    @Resource
    private IBusinessNewsService iBusinessNewsService;
    public getData() {
    }

     @PostConstruct
//    0 15 10 ? * *
    @Scheduled(cron = "0 50 22 * * ?") //每天23:59执行
    public void myTask() throws Exception {
        JSONObject NightResult = RequestUtils.sendPostJson(pythonUrl + "/getNightData", "null");
        System.out.println(JSON.toJSONString(NightResult));

        JSONObject DailyResult = RequestUtils.sendPostJson(pythonUrl +"/getDailyData", "null");
        System.out.println(JSON.toJSONString(DailyResult));

        if(!DailyResult.getString("message").equals("error")){
            System.out.println("1");
            List<DailyNews> addList1 = new ArrayList<>();
            JSONArray jsonArray = DailyResult.getJSONArray("list");
            for(int i = 0; i < jsonArray.size(); i++ ){
                JSONObject data = jsonArray.getJSONObject(i);
                DailyNews dailyNews = JSONObject.toJavaObject((JSONObject)JSONObject.toJSON(data), DailyNews.class);
                addList1.add(dailyNews);
            }
//            System.out.println(addList1);
            iDailyNewsService.saveBatch(addList1);
        }
        if(!NightResult.getString("message").equals("error")){
            System.out.println("2");
            List<NightNews> addList2 = new ArrayList<>();
            JSONArray jsonArray2 = NightResult.getJSONArray("list");
            for(int i = 0; i < jsonArray2.size(); i++ ){
                JSONObject data = jsonArray2.getJSONObject(i);
                NightNews nightNews = JSONObject.toJavaObject((JSONObject)JSONObject.toJSON(data), NightNews.class);
                addList2.add(nightNews);
            }
//            System.out.println(addList2);
            iNightNewsService.saveBatch(addList2);
        }
    }

}