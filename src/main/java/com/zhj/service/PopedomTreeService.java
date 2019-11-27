package com.zhj.service;


import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.zhj.dao.PopedomDao;
import com.zhj.entity.ZhjPopedom;
import com.zhj.entity.ZhjPopedomTree;
import com.zhj.util.LevelUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class PopedomTreeService {

    @Autowired
    private PopedomDao popedomDao;

    /**
     *  根据 当前角色获取权限
     * @param roleId
     * @return
     */
    public List<ZhjPopedomTree> findPopedomListByRoleID(Integer roleId){
        List<ZhjPopedom> popedomList = this.findPopedomList();
        // 根据用户的角色roleId 查询 当前角色 的权限集合
        List<ZhjPopedom> list = popedomDao.findPopedomCollectionByRoleId(roleId);
        StringBuffer buffer = new StringBuffer("");
        if(list != null && list.size() >0){
            for (ZhjPopedom popedom:list){
                buffer.append(popedom.getMid()).append("@");
            }
            buffer.deleteCharAt(buffer.length()-1);
        }
        //存放权限的字符串集合
        String popedom = buffer.toString();
      if(popedomList != null && popedomList.size() > 0){
          for (ZhjPopedom popedom1: popedomList){
              //获取的每个权限和当前角色具有的权限匹配，设置flag=1
              if(popedom.contains(popedom1.getMid().toString())){
                   popedom1.setFlag("1");
              }
              else {
                  popedom1.setFlag("2");
              }
          }
      }
        //将 list  转为树形 。
        List<ZhjPopedomTree>  list1 = Lists.newArrayList();
        for (ZhjPopedom po: popedomList) {
            list1.add(ZhjPopedomTree.adapt(po));
        }
        return popedomListToTree(list1);

      //  return popedomList;
    }
     // 获取所有的  权限集合
    private List<ZhjPopedom> findPopedomList() {

         return  popedomDao.findPopedomList();
    }

    // 查询所有的权限 列表
    public List<ZhjPopedomTree>  findAllPopedomList(){
        List<ZhjPopedom> list= popedomDao.findPopedomList();

        List<ZhjPopedomTree>  popedomList = Lists.newArrayList();
        for (ZhjPopedom popedom: list) {
            popedomList.add(ZhjPopedomTree.adapt(popedom));
        }
        return popedomListToTree(popedomList);
    }



    //
    public List<ZhjPopedomTree> popedomListToTree(List<ZhjPopedomTree>  popedomList){
        if (CollectionUtils.isEmpty(popedomList)) {
            return Lists.newArrayList();
        }
        // level -> [aclmodule1, aclmodule2, ...] Map<String, List<Object>>
        Multimap<String, ZhjPopedomTree> levelPopedomMap = ArrayListMultimap.create();
        List<ZhjPopedomTree> rootList = Lists.newArrayList();
        for (ZhjPopedomTree zpt: popedomList ) {
            levelPopedomMap.put(zpt.getLevel(),zpt);
            if (LevelUtil.ROOT.equals(zpt.getLevel())) {
                rootList.add(zpt);
            }
        }
        // 按照seq从小到大排序
        Collections.sort(rootList, new Comparator<ZhjPopedomTree>() {
            public int compare(ZhjPopedomTree o1, ZhjPopedomTree o2) {
                return o1.getSeq() - o2.getSeq();
            }
        });
        // 递归生成树
        transformpopedomTree(rootList, LevelUtil.ROOT, levelPopedomMap);
        return rootList;
    }
    // level:0, 0, all 0->0.1,0.2
    // level:0.1
    // level:0.2
    public void transformpopedomTree(List<ZhjPopedomTree> popedomLevelList, String level, Multimap<String, ZhjPopedomTree> levelDeptMap) {
        for (int i = 0; i < popedomLevelList.size(); i++) {
            // 遍历该层的每个元素
            ZhjPopedomTree zhjPopedomTree = popedomLevelList.get(i);
            // 处理当前层级的数据
            String nextLevel = LevelUtil.calculateLevel(level, zhjPopedomTree.getMid());
            // 处理下一层
            List<ZhjPopedomTree> popedomList = (List<ZhjPopedomTree>) levelDeptMap.get(nextLevel);
            if (CollectionUtils.isNotEmpty(popedomList)) {
                // 排序
                Collections.sort(popedomList, popedomSeqComparator);

                zhjPopedomTree.setPopedomChildList(popedomList);
                // 进入到下一层处理
                transformpopedomTree(popedomList, nextLevel, levelDeptMap);
            }
        }

    }
    public Comparator<ZhjPopedomTree> popedomSeqComparator = new Comparator<ZhjPopedomTree>() {
        public int compare(ZhjPopedomTree o1, ZhjPopedomTree o2) {
            return o1.getSeq() - o2.getSeq();
        }
    };

    /**
     * 保存角色 权限中间表
     * @param roleId
     * @param podIdList
     * @return
     */
    public boolean saveRolePopedom(Integer roleId, List<Integer> podIdList) {
        try {
            int i =  popedomDao.saveRolePopedom(roleId,podIdList);
            return i > 0;
        } catch (Exception e) {
           // e.printStackTrace();
            log.error("保存角色权限异常:"+e.getMessage());
        }
        return false;
    }



}
