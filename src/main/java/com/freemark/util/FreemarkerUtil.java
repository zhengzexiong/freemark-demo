package com.freemark.util;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

/**
 * @author zhaha
 * @Description 用来根据数据和建模型生成HTML页面的工具类
 * @create 2020-09-19 19:26
 */
public class FreemarkerUtil {
    public Template getTemplate(String name) {
        Template template = null;
        try {
            //通过Freemarker的Configuration读取响应的ftl
            Configuration configuration = new Configuration();
            //设定去哪里读取响应的ftl模板
            configuration.setClassForTemplateLoading(this.getClass(), "/templates");
            //在模板文件目录中寻找名称为demo的模板文件
            template = configuration.getTemplate(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return template;
    }

    /**
     * @param name
     * @param rootMap
     * @Description 控制台输出文件内容
     */
    public void print(String name, Map<String, Object> rootMap) {
        try {
            //通过Template类可以将模板文件输出相应的文件
            Template template = this.getTemplate(name);
            template.process(rootMap, new PrintWriter(System.out));
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * @param name
     * @param rootMap
     * @param outFile
     * @Description 将替换后的模板文件输出到文件
     */
    public void tempPrint(String name, Map<String, Object> rootMap, String outFile) {
        File file = new File("./html");
        FileWriter out = null;
        try {
            //输出路径
            out = new FileWriter(new File("D:\\javaz\\pro\\freemarker-demo\\src\\main\\resources\\html\\" + outFile));
            Template template = this.getTemplate(name);
            template.process(rootMap, out);
        } catch (TemplateException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != out) {
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
