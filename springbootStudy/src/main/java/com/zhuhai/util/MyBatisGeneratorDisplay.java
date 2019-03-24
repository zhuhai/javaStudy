package com.zhuhai.util;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

;

/**
 * Created with IntelliJ IDEA
 * Date: 2019/3/24
 * Time: 20:02
 *
 * @author: hai
 */
public class MyBatisGeneratorDisplay {

    public static void main(String[] args) throws Exception {

        boolean overWrite = true;
        File configFile = new File("MybatisGenerator.xml");
        List<String> warinings = new ArrayList<>();
        ConfigurationParser cp = new ConfigurationParser(warinings);
        Configuration configuration = cp.parseConfiguration(configFile);
        DefaultShellCallback callback = new DefaultShellCallback(overWrite);
        MyBatisGenerator myBatisGenerator = new MyBatisGenerator(configuration, callback, warinings);
        myBatisGenerator.generate(null);

    }
}
