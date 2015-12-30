package com.majian.apple.ibu.model;

import java.util.List;

/**
 * Created by Apple on 15-9-1.
 */
public class LoginResponseModel {


    /**
     * sessionId : b928f64e-16a2-419e-8402-0f92e0cc46b8
     * siUsrFlag : 0
     * parentmenuList : [{"isList":0,"flag":"1","menuid":64,"menuname":"销售机会"},{"isList":0,"flag":"1","menuid":8,"menuname":"项目备案"},{"isList":0,"flag":"1","menuid":65,"menuname":"我的申请"},{"isList":0,"flag":"1","menuid":66,"menuname":"我的审批"},{"isList":0,"flag":"1","menuid":95,"menuname":"项目核准"},{"isList":0,"flag":"1","menuid":125,"menuname":"我的商品"},{"isList":0,"flag":"1","menuid":168,"menuname":"订单管理"},{"isList":0,"flag":"1","menuid":57,"menuname":"回款管理"},{"isList":0,"flag":"1","menuid":100,"menuname":"收入预测"},{"isList":0,"flag":"1","menuid":79,"menuname":"销售目标"},{"isList":1,"flag":"1","menuid":99,"menuname":"销售分析","childmenuname":[{"flag":1,"menuid":105,"menuname":"十大客户"},{"flag":1,"menuid":106,"menuname":"部门合同对比"},{"flag":1,"menuid":107,"menuname":"实际计划对比"},{"flag":1,"menuid":137,"menuname":"单品销售分析"},{"flag":1,"menuid":138,"menuname":"月度销售排名分析"}]},{"isList":0,"flag":"1","menuid":58,"menuname":"我的工作台"},{"isList":0,"flag":"1","menuid":60,"menuname":"我的日程"},{"isList":0,"flag":"1","menuid":6,"menuname":"我的客户"},{"isList":0,"flag":"1","menuid":26,"menuname":"我的联系人"},{"isList":0,"flag":"1","menuid":108,"menuname":"我的待办"},{"isList":0,"flag":"1","menuid":169,"menuname":"工作流程"}]
     * rolenames : 部门经理
     * code : 100
     * tip : 执行成功
     */

    public String sessionId;
    public String siUsrFlag;
    public String rolenames;
    public String code;
    public String tip;
    public List<ParentmenuListEntity> parentmenuList;

    public static class ParentmenuListEntity {
        /**
         * isList : 0
         * flag : 1
         * menuid : 64
         * menuname : 销售机会
         */

        public int isList;
        public String flag;
        public int menuid;
        public String menuname;
    }
}
