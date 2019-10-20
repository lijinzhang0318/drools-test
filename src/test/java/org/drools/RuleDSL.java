package org.drools;

import org.drools.pojo.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

public class RuleDSL {

	@Test
	public void testIsDSL() {
		KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("isDSL");
        Person person=new Person();
        person.setName("张三");
        person.setAge(20);
        ks.insert(person);
        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        System.out.println(person.getClassName());
        ks.dispose();
	}
}
