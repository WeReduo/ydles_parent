package com.ydles.canal.listener;

import com.alibaba.otter.canal.protocol.CanalEntry;
import com.xpand.starter.canal.annotation.CanalEventListener;
import com.xpand.starter.canal.annotation.ListenPoint;

import java.util.List;

/**
 * @Created by IT李老师
 * 公主号 “IT李哥交朋友”
 * 个人微 itlils
 */
@CanalEventListener //这个类是canal的监听类
public class BusinessListener {
    /**
     *
     * @param eventType 改变 insert update delete
     * @param rowData
     */
    @ListenPoint(schema = "ydles_business",table = "tb_ad")
    public void adUpdate(CanalEntry.EventType eventType,CanalEntry.RowData rowData){
        System.out.println("EventType:"+eventType);

        //改变之前 这一行数据
        List<CanalEntry.Column> beforeColumnsList = rowData.getBeforeColumnsList();
        for (CanalEntry.Column column : beforeColumnsList) {
            System.out.println("改变之前，列名字："+column.getName()+"列值："+column.getValue());
        }

        System.out.println("======================================");

        //改变之后 这一行数据
        rowData.getAfterColumnsList().forEach(c->System.out.println("改变之后，列名字："+c.getName()+"列值："+c.getValue()));

    }

}