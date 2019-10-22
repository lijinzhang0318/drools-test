package org.drools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
import org.drools.pojo.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author lijinzhang
 * @date 2019/10/15
 */
public class RulesTable {
	
	@Test
    public void testisXls() {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("isXls");
        Person person=new Person();
        person.setName("张三");
        person.setAge(35);
        ks.insert(person);
        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        ks.dispose();
    }

    @Test
    public void  verificationDT() throws FileNotFoundException {
        File file = new File(
                "C:\\Users\\lijinzhang\\git\\drools-test\\src\\main\\resources\\rules\\isXls\\tableXls.xls");
        InputStream is = new FileInputStream(file);
        SpreadsheetCompiler converter = new SpreadsheetCompiler();
        String drl = converter.compile(is, InputType.XLS);
        System.out.println(drl);
    }

    @Test
    public void  verificationDT2() throws FileNotFoundException {
        File file = new File(
                "C:\\Users\\lijinzhang\\git\\drools-test\\src\\main\\resources\\rules\\isXls\\tableXlsS.xls");
        InputStream is = new FileInputStream(file);
        SpreadsheetCompiler converter = new SpreadsheetCompiler();
        String drl = converter.compile(is, InputType.XLS);
        System.out.println(drl);
    }
   
}
