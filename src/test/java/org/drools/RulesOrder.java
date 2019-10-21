package org.drools;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.runtime.KieSession;

/**
 * @author lijinzhang
 * @date 2019/10/18
 */
public class RulesOrder {
    
    @Test
    public void testOrder() {
        KieSession ks = KieServices.Factory.get().getKieClasspathContainer().newKieSession("isOrder");
        ks.insert(new String("1"));
        int count = ks.fireAllRules();
        System.out.print("总执行了" + count + "条规则");
        ks.dispose();
    }
    
    
}