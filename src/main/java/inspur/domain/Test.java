package inspur.domain;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @author langyonghe
 * @date 2020/11/14 11:03
 */
public class Test {
    public static void main(String[] args) {
        List<Map> maps = new ArrayList<>();
        Map map = new HashMap();
        AllowableValues allowableValues = new AllowableValues("t_test1", "t_test1",Arrays.asList("name1","age1"));
        map.put("allowableValue",allowableValues);

        Map map1 = new HashMap();
        AllowableValues allowableValues1 = new AllowableValues("t_test2", "t_test2",Arrays.asList("name2","age2"));
        map1.put("allowableValue",allowableValues1);

        maps.add(map);
        maps.add(map1);

        System.out.println(JSON.toJSONString(maps));

        Map mapColumn = new HashMap();
        mapColumn.put("table1", Arrays.asList("name1","age1"));
        mapColumn.put("table2", Arrays.asList("name2","age2"));
        System.out.println(JSON.toJSONString(mapColumn));


    }
}
class AllowableValues{

    private String name;
    private String displayName;
    private List<String> columns;

    public List<String> getColumns() {
        return columns;
    }

    public void setColumns(List<String> columns) {
        this.columns = columns;
    }

    public AllowableValues(String name, String displayName, List<String> columns) {
        this.name = name;
        this.displayName = displayName;
        this.columns = columns;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}