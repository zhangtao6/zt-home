package com.zhangtao.zt.home.web.api.controller.v1;

import com.zhangtao.zt.home.domain.TbContent;
import com.zhangtao.zt.home.web.api.dto.TbContentDto;
import com.zhangtao.zt.home.web.api.service.TbContentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangtao
 * @Description: TODO
 * @ProjectName zt-home
 * @date 2019/6/12 21:21
 */
@RestController
@RequestMapping(value = "${api.path.v1}/content")
public class TbContentController {
    @Autowired
    private TbContentService tbContentService;

    @RequestMapping(value = "")
    public List<TbContentDto> list() {
        //要把List new出来 呆逼
        List<TbContentDto> tbContentDtos = new ArrayList<>();
        List<TbContent> tbContents = tbContentService.selectAll();
        for (TbContent tbContent :
                tbContents) {
            TbContentDto dto = new TbContentDto();
            BeanUtils.copyProperties(tbContent, dto);
            tbContentDtos.add(dto);
        }
        return tbContentDtos;
    }

    @RequestMapping(value = "{content_index}", method = RequestMethod.GET)
    public TbContentDto detail(@PathVariable(value = "content_index") Integer id) {
        TbContentDto tbContentDto = new TbContentDto();
        BeanUtils.copyProperties(tbContentService.selectTbContentById(id), tbContentDto);
        return tbContentDto;
    }
}
