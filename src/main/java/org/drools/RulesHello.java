package org.drools;

import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RulesHello {
	
	public static void main(String[] args) {
		KieServices kss = KieServices.Factory.get();
		KieContainer kc = kss.getKieClasspathContainer();
		KieSession ks = kc.newKieSession("testhelloworld");
		int count = ks.fireAllRules();
		System.out.print("总执行了" + count + "条规则");
		ks.dispose();
	}
}
