package com.zhj.entity;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ZhjPopedom {

    private Integer mid;			//权限Code（主键ID）
    private Integer pid;			//父级权限code，如果已经是根节点则为0
    private String name;		//权限名称
    private String level;		// level 树
    private Integer seq;		// 排序
    private String url;			//权限在系统中执行访问地址的URL
    private String icon;		//如果是菜单，则为显示图片的URL
    private String target;		//如果是菜单，链接执行的Frame区域名称
    private boolean isParent;	//是否是父节点，父节点为true，子节点为false
    private boolean isMenu;		//是否是系统菜单结构
//=====================================
    private String flag; // 1 有权限   2 无权限



}
