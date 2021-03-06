package MyUtil;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static MyUtil.MyUtilEasy.addStr;

public class MyUtilForAcc {
    private static final List<String> DATATYPE = new ArrayList<String>() {{
        add("CHAR");
        add("VARCHAR");
        add("BIT");
        add("FLOAT");
        add("INT");
    }};

    public static List<String> getRandom(String dataType, int strLen) {
        int len = 0;
        if (dataType.contains("(")) {
            len = Integer.parseInt(dataType.substring(dataType.indexOf("(") + 1, dataType.indexOf(")")));
            dataType = dataType.substring(0, dataType.indexOf("("));
        }
        if (!DATATYPE.contains(dataType)) {
            return null;
        }
        List<String> ls = new ArrayList<>();
        if ("CHAR".equals(dataType)) {
            for (int i = 0; i < strLen; i++) {
                ls.add(MyUtilEasy.getRandomString(len));
            }
        }
        if ("VARCHAR".equals(dataType)) {
            for (int i = 0; i < strLen; i++) {
                Random random = new Random();
                ls.add(MyUtilEasy.getRandomString(random.nextInt(len)));
            }
        }
        if ("BIT".equals(dataType)) {
            for (int i = 0; i < strLen; i++) {
                Random random = new Random();
                ls.add(String.valueOf(random.nextInt(2)));
            }
        }
        if ("FLOAT".equals(dataType)) {
            for (int i = 0; i < strLen; i++) {
                Random random = new Random();
                ls.add(String.valueOf(random.nextFloat()));
            }
        }
        if ("INT".equals(dataType)) {
            for (int i = 0; i < strLen; i++) {
                Random random = new Random();
                ls.add(String.valueOf(random.nextInt(10000)));
            }
        }
        return ls;
    }

    public static String insertValue(Statement st, String tableName, String val) throws SQLException {
        String[] s = val.split(",");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length; i++) {
            if (i != 0)
                sb.append(",").append(addStr(s[i].split(" ")[0]));
            else
                sb.append(addStr(s[i].split(" ")[0]));
        }
        StringBuilder sql1 = new StringBuilder();
        sql1.append("INSERT INTO ").append(tableName).append("\n VALUES(");
        sql1.append(sb.toString()).append(");").append("\n");
        // FindBugs你真牛，该方法以字符串的形式来调用SQLstatement的execute方法，它似乎是动态生成SQL语句的方法。这会更容易受到SQL注入攻击。
        st.execute(sql1.toString());
        return sql1.toString();
    }
}
