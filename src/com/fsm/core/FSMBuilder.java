/*
 * @(#)FSMBuilder.java 2014-4-21 ÏÂÎç03:39:19 FSM
 */
package com.fsm.core;

import java.io.File;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.xml.sax.SAXException;

import com.fsm.model.FSM;
import com.fsm.model.Transition;

/**
 * FSMBuilder
 * @author wang
 * @version 1.0
 *
 */
public class FSMBuilder {
    public FSM build(String path) {
        SAXReader reader = new SAXReader();
        try {
            reader
                    .setFeature(
                        "http://apache.org/xml/features/nonvalidating/load-external-dtd",
                        false);
        } catch (SAXException e) {
            e.printStackTrace();
            return null;
        }
        Document doc = null;
        try {
            doc = reader.read(new File(path));
        } catch (DocumentException e) {
            e.printStackTrace();
            return null;
        }
        FSM fsm = new FSM();
        Element element = doc.getRootElement();
        buildInputs(fsm, element.element("inputs"));
        buildOutputs(fsm, element.element("outputs"));
        buildStates(fsm, element.element("states"));
        buildInitState(fsm, element.element("init_state"));
        buildTransition(fsm, element.element("transition"));
        return fsm;
    }

    private void buildInputs(FSM fsm, Element element) {
        for (String str : element.getTextTrim().split(",")) {
            fsm.getInputs().add(str);
        }
    }

    private void buildOutputs(FSM fsm, Element element) {
        for (String str : element.getTextTrim().split(",")) {
            fsm.getOutputs().add(str);
        }
    }

    private void buildStates(FSM fsm, Element element) {
        for (String str : element.getTextTrim().split(",")) {
            fsm.getStates().add(str);
        }
    }

    private void buildInitState(FSM fsm, Element element) {
        fsm.setInitState(element.getTextTrim());
    }

    private void buildTransition(FSM fsm, Element element) {
        String[] str = element.getTextTrim().split(",");
        for (int i = 0; i < str.length; i += 4) {
            Transition tran = new Transition();
            tran.setStart(str[i].trim());
            tran.setEnd(str[i + 1].trim());
            tran.setInput(str[i + 2].trim());
            tran.setOutput(str[i + 3].trim());
            fsm.getTransitions().add(tran);
        }
    }
}
