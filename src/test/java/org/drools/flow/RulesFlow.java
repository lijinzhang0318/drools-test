package org.drools.flow;

import org.junit.Test;
import org.kie.api.KieServices;
import org.kie.api.io.Resource;
import org.kie.api.io.ResourceType;
import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.kie.internal.io.ResourceFactory;
import org.kie.internal.utils.KieHelper;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class RulesFlow {
	
    @Test
    public void testIsFlow() {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("isFlow");
        ks.startProcess("No1_drools");//流程启动
        ks.dispose();
    }

    @Test
    public void testIsFlowAPI() throws IOException {
        Resource bpmn = ResourceFactory.newClassPathResource("rules/isFlow/ruleFlow.bpmn", RulesFlow.class);
        Resource drl = ResourceFactory.newClassPathResource("rules/isFlow/ruleFlow.drl", RulesFlow.class);
        KieHelper helper = new KieHelper();
        helper.addResource(bpmn, ResourceType.BPMN2);
        helper.addResource(drl, ResourceType.DRL);
        KieSession ksession = helper.build().newKieSession();
        ksession.startProcess("No1_drools");
        ksession.dispose();
    }

    @Test
    public void flowNameSame() {
        KieServices kss = KieServices.Factory.get();
        KieContainer kc = kss.getKieClasspathContainer();
        KieSession ks = kc.newKieSession("flowNameSame");
        ks.startProcess("flowNameSame");//流程启动
        ks.dispose();
    }

    @Test
    public void flowNameSames() throws IOException {
        Resource bpmn = ResourceFactory.newClassPathResource("rules/isFlow/flowNameSame/flowNameSames.bpmn", RulesFlow.class);
        Resource drl = ResourceFactory.newClassPathResource("rules/isFlow/flowNameSame/flowNameSame.drl", RulesFlow.class);
        KieHelper helper = new KieHelper();
        helper.addResource(bpmn, ResourceType.BPMN2);
        helper.addResource(drl, ResourceType.DRL);
        KieSession ksession = helper.build().newKieSession();
        ksession.startProcess("flowNameSame");
        ksession.dispose();
    }


    @Test
    public void flowNameNotSame() throws IOException {
        Resource bpmn = ResourceFactory.newClassPathResource("rules/isFlow/flowNameNotSame/flowNameNotSame.bpmn", RulesFlow.class);
        Resource drl = ResourceFactory.newClassPathResource("rules/isFlow/flowNameNotSame/flowNameNotSame.drl", RulesFlow.class);
        KieHelper helper = new KieHelper();
        helper.addResource(bpmn, ResourceType.BPMN2);
        helper.addResource(drl, ResourceType.DRL);
        KieSession ksession = helper.build().newKieSession();
        ksession.startProcess("flowNameNotSame");
        ksession.dispose();
    }

    @Test
    public void flowToJavaNo1() throws IOException {
        Resource bpmn = ResourceFactory.newClassPathResource("rules/isFlow/flowJava/flowToJava.bpmn", RulesFlow.class);
        Resource drl = ResourceFactory.newClassPathResource("rules/isFlow/flowJava/flowToJava.drl", RulesFlow.class);
        KieHelper helper = new KieHelper();
        helper.addResource(bpmn, ResourceType.BPMN2);
        helper.addResource(drl, ResourceType.DRL);
        KieSession ksession = helper.build().newKieSession();
        ksession.startProcess("flowToJava");
        ksession.dispose();
    }

    @Test
    public void flowToJavaNo2() throws IOException {
        Resource bpmn = ResourceFactory.newClassPathResource("rules/isFlow/flowJava/flowToJavaVal.bpmn", RulesFlow.class);
        Resource drl = ResourceFactory.newClassPathResource("rules/isFlow/flowJava/flowToJava.drl", RulesFlow.class);
        KieHelper helper = new KieHelper();
        helper.addResource(bpmn, ResourceType.BPMN2);
        helper.addResource(drl, ResourceType.DRL);
        KieSession ksession = helper.build().newKieSession();
        Map<String, Object> map = new HashMap<>();
        map.put("value", "张三");
        ksession.startProcess("flowToJavaVal", map);
        ksession.dispose();
    }

    @Test
    public void flowGateway() throws IOException {
        Resource bpmn = ResourceFactory.newClassPathResource("rules/isFlow/Gateway/separation.bpmn", RulesFlow.class);
        KieHelper helper = new KieHelper();
        helper.addResource(bpmn, ResourceType.BPMN2);
        KieSession ksession = helper.build().newKieSession();
        ksession.startProcess("gateway");
        ksession.dispose();
    }
}