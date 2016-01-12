/*
 * @(#)Test.java 2014-4-21 下午07:10:57 FSM
 */
package com.fsm.core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Set;

import com.fsm.model.FSM;

/**
 * Test
 * @author wang
 * @version 1.0
 *
 */
public class Test {

    public String output(FSM fsm, Set<String> tSet) {
        StringBuilder sb = new StringBuilder(
                "<?xml version=\"1.0\" encoding=\"utf-8\"?>\n");
        sb.append("<scheme>\n");
        List<String> tList = new ArrayList<String>(tSet);
        Collections.sort(tList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                return o1.compareTo(o2);
            }
        });
        for (int i = 0; i < tList.size(); i++) {
            sb.append("\t<sequence id=\"" + i + "\">\n");
            sb.append("\t\t<inputs>" + tList.get(i).replaceAll("\\w", "$0,")
                    + "</inputs>\n");
            sb.append("\t\t<states>"
                    + fsm.runState(tList.get(i)).replaceAll("\\d", "$0,")
                    + "</states>\n");
            sb.append("\t\t<outputs>"
                    + fsm.run(tList.get(i)).replaceAll("\\d", "$0,")
                    + "</outputs>\n");
            sb.append("\t</sequence>\n");
        }
        sb.append("</scheme>\n");
        return sb.toString();
    }

    public String test(FSM fsm, FSM testFsm, Set<String> tSet) {
        List<String> tList = new ArrayList<String>(tSet);
        Collections.sort(tList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() != o2.length()) {
                    return o1.length() - o2.length();
                }
                return o1.compareTo(o2);
            }
        });
        String result = "";
        for (String input : tList) {
            String output1 = fsm.run(input);
            String output2 = testFsm.run(input);
            if (output2 == null) {
                result += "输入为" + input + "时，转换错误\n";
            } else if (!output1.equals(output2)) {
                result += "输入为" + input + "时，正确输出为" + output1 + "，测试输出为"
                        + output2 + "，操作错误\n";
            }
        }
        if (result.equals("")) {
            result = "正确";
        }
        return result;
    }
}
