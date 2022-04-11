package cc.mrbird.febs.news.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author MrBird
 */
@Slf4j
@Data
@TableName("nightnews")
public class NightNews implements Serializable {

    private static final long serialVersionUID = 921991157363932095L;


    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;


    @TableField("get_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date getTime;



    @TableField("news_time")
    private String newsTime;


    @TableField("section")
    private String section;


    @TableField("reporter")
    private String reporter;

    @TableField("title")
    private String title;


    @TableField("content")
    private String content;

    @TableField("add_photo")
    private String addPhoto;
}
