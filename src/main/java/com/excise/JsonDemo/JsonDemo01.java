package com.excise.JsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import utils.DateUtils;

import java.util.*;

/**
 * Created by mgq on 2015/11/5.
 */
public class JsonDemo01 {

    @Test
    public void mapToJson(){
        Map $01=new HashMap();

        Map $02=new HashMap();

        Map $03=new HashMap();

        $01.put("out01","a");

        $02.put("in01","b");

        $03.put("in001","c");

        $02.put("inin",$03);

        $01.put("in", $02);
        //JSONObject mapToJsonm=JSONObject.
       // System.out.println(mapToJsonm);
        System.out.println("map===="+$01);
        Object obj = JSON.toJSON($01);
        System.out.println("map---->json===="+obj.toString());
        String str = obj.toString();
        JSONObject jsonObject = JSONObject.parseObject(str);
        Map map=JSONObject.parseObject(jsonObject.toString(),Map.class);
        System.out.println("json--->map====="+map);
        //JSONObject.
        System.out.println("json---->string==="+jsonObject.toString());
        Set set=$01.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println("iterator-->map==="+iterator.next());
        }
    }

    @Test
    public void jsonToMap(){
        //最外层
        JSONObject params0 = new JSONObject();
        //head
        JSONObject params1 = new JSONObject();
        params1.put("REQUEST_ID","requsetId");
        params1.put("TRAN_CODE","01");
        params1.put("SIGN","SDAFASDGGSDFGSD");
        params0.put("HEAD",params1);

        //data
        //JSONObject params8 = new JSONObject();
        //feeList
        JSONObject params = new JSONObject();
        params.put("zs_id","5646723496");
        params.put("zs_name","发生的");
        params.put("yy_id","01");
        params.put("diagnosis","0gaga1");
        params.put("bill_no","01");
        params.put("enter_date","2015/08/20");
        params.put("out_date","2015/09/20");
        params.put("total_amt","20");
        params.put("liab_flag","sdaf");
        params.put("acci_date","2015/08/20");
        params.put("is_in_period","y");
        params.put("is_ease_pain","n");
        params.put("total_exempt_fee","45");
        params.put("this_bn_fee","65");

        JSONObject params2 = new JSONObject();
        params2.put("item","投保人");
        params2.put("exempt_flag","18221811952");
        params2.put("exempt_code","123456");
        params2.put("item_fee","423");

        JSONObject params3 = new JSONObject();
        params3.put("item","投保人");
        params3.put("exempt_flag","18221811952");
        params3.put("exempt_code", "123456");
        params3.put("item_fee", "3421");

        List list1=new ArrayList();
        list1.add(params2);
        list1.add(params3);
        params.put("fee_list", list1);

        //params8.put("DATA",params);

        //certList
        JSONObject params4=new JSONObject();
        params4.put("certno", "分担号1");
        params4.put("kq_flag","18221811952");
        params4.put("ry_flag", "1234562");
        params4.put("wg_flag", "2015/08/20");
        params4.put("qk_flag", new Date());

        JSONObject params5=new JSONObject();
        params5.put("certno","分担号2");
        params5.put("kq_flag","18221811952");
        params5.put("ry_flag","1234562");
        params5.put("wg_flag","2015/08/20");
        params5.put("qk_flag", new Date());

        List list2=new ArrayList();
        list2.add(params4);
        list2.add(params5);
        params.put("cert_list", list2);

        params0.put("DATA",params);
        System.out.println("json====="+params.toString());
        Map<String,Map<String,Map>> map=JSONObject.parseObject(params0.toString(),Map.class);
        System.out.println("json--->map==="+map);

    }
    @Test
    public void testUtils(){
        System.out.println(DateUtils.getCurrent());
        String ss=DateUtils.tranferDate(new Date(), "yyyy-MM-dd HH:mm:ss");
        System.out.println(ss);
    }
}
