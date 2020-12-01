package com.pp.log.utils;

import java.io.*;
import java.util.ArrayList;

/**
 * @program: suntion-auth
 * @Description: 异常信息转换
 * @Author: Shen.Sun  suntion@yeah.net
 * @create: 2020-12-01 18:18
 **/
public class ThrowableInformation {
    /**
     * @Description:将Throwable对象的错误堆栈内容形成字符串<br>
     * @param throwable
     *            异常对象
     * @return
     * @author mahh
     * @since：2014-9-30 下午02:32:51
     */
    public static String[] getThrowableStrRep(Throwable throwable) {
        if (throwable == null) {
            return new String[0];
        }
        StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        throwable.printStackTrace(pw);
        pw.flush();
        LineNumberReader reader = new LineNumberReader(new StringReader(
                sw.toString()));
        ArrayList lines = new ArrayList();
        try {
            String line = reader.readLine();
            while (line != null) {
                lines.add(line);
                line = reader.readLine();
            }
        } catch (IOException ex) {
            lines.add(ex.toString());
        }
        String[] rep = new String[lines.size()];
        lines.toArray(rep);
        return rep;
    }

    // 测试代码
    public static void main(String[] args) {
        RuntimeException e1 = new RuntimeException("aaa");
        RuntimeException e2 = new RuntimeException("e2", e1);
        RuntimeException e3 = new RuntimeException(e2);
        String[] errorStrArray = getThrowableStrRep(e3);
        for (int i = 0; i < errorStrArray.length; i++) {
            System.out.println(errorStrArray[i]);
        }
    }

}
