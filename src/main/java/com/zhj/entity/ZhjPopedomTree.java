package com.zhj.entity;

import com.google.common.collect.Lists;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.beans.BeanUtils;

import java.util.List;

@Getter
@Setter
@ToString
public class ZhjPopedomTree extends  ZhjPopedom {

    private List<ZhjPopedomTree>  popedomChildList = Lists.newArrayList();

    public static ZhjPopedomTree adapt(ZhjPopedom zhjPopedom) {
        ZhjPopedomTree dto = new ZhjPopedomTree();
        BeanUtils.copyProperties(zhjPopedom, dto);
        return dto;
    }
}
