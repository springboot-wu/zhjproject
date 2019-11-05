package com.zhj.model;


import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class Jurisdiction implements Serializable {
    private static final long serialVersionUID = -3323429015676959985L;
    private Integer id;  //主键

    private Integer pid;//父id

    private String text;//名称

    private String url;//路径

    private Map<String, Object> attributes = new HashMap<String, Object>(); // 添加到节点的自定义属性

    private List<Jurisdiction> children;; //子节点数据

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text == null ? null : text.trim();
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
    }

    public List<Jurisdiction> getChildren() {
        return children;
    }
    public void setChildren(List<Jurisdiction> children) {
        this.children = children;
    }

    @Override
    public String toString() {
        return "Jurisdiction{" +
                "id=" + id +
                ", pid=" + pid +
                ", text='" + text + '\'' +
                ", url='" + url + '\'' +
                ", attributes=" + attributes +
                ", children=" + children +
                '}';
    }
}