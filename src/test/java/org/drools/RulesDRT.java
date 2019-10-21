package org.drools;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;

import org.drools.pojo.Person;
import org.drools.template.ObjectDataCompiler;
import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

public class RulesDRT {
    @Test
    public void testIsDRT() {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("isDrt");
        Person person = new Person();
        person.setName("张三");
        person.setAge(50);
        ks.insert(person);
        int count = ks.fireAllRules();
        System.out.println("总执行了" + count + "条规则");
        System.out.println(person.getClassName());
        ks.dispose();
    }

    @Test
    public void testIsDRTAPI() {
        ObjectDataCompiler converter = new ObjectDataCompiler();
        // 赋值给模板属性
        Person person = new Person();
        person.setAge(50);
        person.setClassName("一班");
        Collection<Person> cfl = new ArrayList<>();
        // h每add一次，就代码一条规则
        cfl.add(person);
        InputStream dis = null;
        try {
            dis = ResourceFactory.newClassPathResource("rules/isDrt/Cheese.drt", RulesDRT.class).getInputStream();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String drl = converter.compile(cfl, dis);
        System.out.println(drl);
        KieHelper helper = new KieHelper();
        helper.addContent(drl, ResourceType.DRL);
        KieSession ksession = helper.build().newKieSession();
        Person ps = new Person();
        ps.setAge(50);
        person.setName("张三");
        ksession.insert(ps);
        int i = ksession.fireAllRules();
        System.out.println(ps.getClassName() + "	" + i + "次");
        ksession.dispose();
    }
}
