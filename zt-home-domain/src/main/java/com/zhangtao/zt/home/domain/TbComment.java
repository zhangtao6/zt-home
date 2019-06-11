package com.zhangtao.zt.home.domain;

import com.zhangtao.zt.home.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * @author zhangtao
 * @Description: 评论实体类
 * @ProjectName zt-home
 * @date 2019/6/9 14:18
 */
@Data
public class TbComment extends BaseEntity {
    private Integer parentId;
    private Integer topicId;
    private String topicType;
    private String content;
    private Integer praise;
    private Integer replay;
    private Integer fromUid;
    private String fromUname;
}
