package org.drools;

import org.drools.pojo.Person;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;

/**
 * @author lijinzhang
 * @date 2019/10/22
 */
public class RulesAttributes {
	
	@Test
    public void testNoLoop() {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("isNoLoop");
        Person person = new Person();
        person.setName("张三");
        person.setAge(30);
        person.setClassName("一班");
        ks.insert(person);
        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        ks.dispose();
    }
	
	@Test
    public void testLockOnActive() {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("isLockNoActive");
        Person person = new Person();
        person.setName("张三");
        person.setAge(30);
        person.setClassName("一班");
        ks.insert(person);
        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        ks.dispose();
    }
	
	@Test
    public void testSalience() {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("isSalience");
        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        ks.dispose();
    }
	
	@Test
    public void testActivationGroup() {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("isActivationGroup");
        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        ks.dispose();
    }
}
