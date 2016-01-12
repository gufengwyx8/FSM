/*
 * @(#)FSM.java 2014-4-21 ����03:02:56 FSM
 */
package com.fsm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * FSM
 * @author wang
 * @version 1.0
 *
 */
public class FSM {
    private List<String> inputs = new ArrayList<String>();

    private List<String> outputs = new ArrayList<String>();

    private List<String> states = new ArrayList<String>();

    private String initState;

    private List<Transition> transitions = new ArrayList<Transition>();

    public String run(String input) {
        String output = "";
        String state = initState;
        for (char c : input.toCharArray()) {
            boolean isRun = false;
            for (Transition tran : transitions) {
                if (tran.getStart().equals(state)
                        && tran.getInput().equals(String.valueOf(c))) {
                    output += tran.getOutput();
                    state = tran.getEnd();
                    isRun = true;
                    break;
                }
            }
            if (!isRun) {
                return null;
            }
        }
        return output;
    }

    public String runState(String input) {
        String output = initState;
        String state = initState;
        for (char c : input.toCharArray()) {
            boolean isRun = false;
            for (Transition tran : transitions) {
                if (tran.getStart().equals(state)
                        && tran.getInput().equals(String.valueOf(c))) {
                    output += tran.getEnd();
                    state = tran.getEnd();
                    isRun = true;
                    break;
                }
            }
            if (!isRun) {
                return null;
            }
        }
        return output;
    }

    public String finalState(String input) {
        String output = initState;
        String state = initState;
        for (char c : input.toCharArray()) {
            boolean isRun = false;
            for (Transition tran : transitions) {
                if (tran.getStart().equals(state)
                        && tran.getInput().equals(String.valueOf(c))) {
                    output = tran.getEnd();
                    state = tran.getEnd();
                    isRun = true;
                    break;
                }
            }
            if (!isRun) {
                return null;
            }
        }
        return output;
    }

    /**
     * ����  inputs
     * @return inputs
     */
    public List<String> getInputs() {
        return inputs;
    }

    /**
     * ���� inputs
     * @param inputs inputs
     */
    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }

    /**
     * ����  outputs
     * @return outputs
     */
    public List<String> getOutputs() {
        return outputs;
    }

    /**
     * ���� outputs
     * @param outputs outputs
     */
    public void setOutputs(List<String> outputs) {
        this.outputs = outputs;
    }

    /**
     * ����  states
     * @return states
     */
    public List<String> getStates() {
        return states;
    }

    /**
     * ���� states
     * @param states states
     */
    public void setStates(List<String> states) {
        this.states = states;
    }

    /**
     * ����  initState
     * @return initState
     */
    public String getInitState() {
        return initState;
    }

    /**
     * ���� initState
     * @param initState initState
     */
    public void setInitState(String initState) {
        this.initState = initState;
    }

    /**
     * ����  transitions
     * @return transitions
     */
    public List<Transition> getTransitions() {
        return transitions;
    }

    /**
     * ���� transitions
     * @param transitions transitions
     */
    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

}
