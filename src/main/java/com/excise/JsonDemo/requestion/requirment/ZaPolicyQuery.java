package com.excise.JsonDemo.requestion.requirment;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by mgq on 2015/11/13.
 */
public class ZaPolicyQuery {

    public void policyQuery(String name,String certType,String certNo){
        if (null==name || null==certType || null==certNo){
            return;
        }
        String requestId=generateRequestId();
        Map map=new HashMap();
        map.put("certType",certType);
        map.put("name",name);
        map.put("certNo",certNo);
        map.put("requestId",requestId);
    }
    //生成request_id,规则：LY+“-”+时间戳+五位随机数
    private String generateRequestId(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyyMMddHHmmss");
        String timestamp=simpleDateFormat.format(new Date());
        int fiveNumber=(int)(Math.random() * 9 + 1) * 10000;
        String requestId="LY-"+timestamp+fiveNumber;
        return requestId;
    }
}
