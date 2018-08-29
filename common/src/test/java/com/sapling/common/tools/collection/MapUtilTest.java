package com.sapling.common.tools.collection;

import com.sapling.common.api.base.BaseRequest;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * @author weizhou
 * @version v1.0
 * @date 2018/6/20
 * @since v1.0
 */
public class MapUtilTest {

    @Test
    public void objectToMap() {
        BaseRequest request = new BaseRequest();
        request.setRequestId("test");
        request.setRequestTime(12345678l);
        Map one = new HashMap();
        Map map = MapUtil.objectToMap(request);

        System.out.println(map);
        System.out.println(one);
//        Assert.assertFalse(MapUtil.compare(map,one));
    }

    @Test
    public void mapToObject() {
        MapTestData testData = new MapTestData("test","message");
        System.out.println(MapUtil.objectToMap(testData));
        System.out.println(MapUtil.objectToMap(testData,true));
        System.out.println(MapUtil.objectToMap(testData,false, Arrays.asList(new String[]{"code"})));
        System.out.println(MapUtil.objectToMap(testData,true, Arrays.asList(new String[]{"code"})));

    }

    public class MapTestData{

        public MapTestData(){

        }

        public MapTestData(String code,String message){
            this.code = code;
            this.message = message;
        }
        private String code;
        private String message;


        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }

        public Integer getAge (){
            return 1234;
        }
    }
}