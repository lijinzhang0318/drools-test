package org.drools;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

import org.drools.decisiontable.InputType;
import org.drools.decisiontable.SpreadsheetCompiler;
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
	public void testIsXls() {
		KieServices kss = KieServices.Factory.get();
		KieContainer kc = kss.getKieClasspathContainer();
		KieSession ks = kc.newKieSession("isXls");
		int count = ks.fireAllRules();
		System.out.print("总执行了" + count + "条规则");
		ks.dispose();
	}
	
	@Test
	public void printTableXls1() {
		printDrl("C:\\Users\\lijinzhang\\git\\drools-demo\\src\\main\\resources\\table\\tableXls1.xls");
	}
	
	private void printDrl(String url) {
		try{
			File file = new File(url);
			InputStream is = new FileInputStream(file);
			SpreadsheetCompiler converter = new SpreadsheetCompiler();
			String drl = converter.compile(is, InputType.XLS);
			System.out.print(drl);
		} catch(Exception e) {
			
		}
	}
}
