package com.excise.JsonDemo;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.junit.Test;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

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
        System.out.println($01);
        Object obj = JSON.toJSON($01);
        String str = obj.toString();
        JSONObject jsonObject = JSONObject.parseObject(str);
        //JSONObject.
        System.out.println(obj.toString());
        System.out.println(jsonObject.toString());
        Set set=$01.keySet();
        Iterator iterator=set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
