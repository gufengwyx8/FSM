/*
 * @(#)FileUtil.java 2014-4-21 ÏÂÎç08:03:35 FSM
 */
package com.fsm.core;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * FileUtil
 * @author wang
 * @version 1.0
 *
 */
public class FileUtil {
    public static String readFile(String path) {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(path));
            String str;
            while ((str = br.readLine()) != null) {
                sb.append(str + "\n");
            }
        } catch (FileNotFoundException e1) {
            e1.printStackTrace();
        } catch (IOException e2) {
            e2.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                br = null;
            }
        }
        return sb.toString();
    }

    public static void writeFile(String path, String str) {
        BufferedWriter bw = null;
        try {
            bw = new BufferedWriter(new FileWriter(path));
            bw.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bw != null) {
                try {
                    bw.flush();
                    bw.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
