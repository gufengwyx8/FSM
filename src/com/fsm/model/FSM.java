/*
 * @(#)FSM.java 2014-4-21 下午03:02:56 FSM
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
     * 返回  inputs
     * @return inputs
     */
    public List<String> getInputs() {
        return inputs;
    }

    /**
     * 设置 inputs
     * @param inputs inputs
     */
    public void setInputs(List<String> inputs) {
        this.inputs = inputs;
    }

    /**
     * 返回  outputs
     * @return outputs
     */
    public List<String> getOutputs() {
        return outputs;
    }

    /**
     * 设置 outputs
     * @param outputs outputs
     */
    public void setOutputs(List<String> outputs) {
        this.outputs = outputs;
    }

    /**
     * 返回  states
     * @return states
     */
    public List<String> getStates() {
        return states;
    }

    /**
     * 设置 states
     * @param states states
     */
    public void setStates(List<String> states) {
        this.states = states;
    }

    /**
     * 返回  initState
     * @return initState
     */
    public String getInitState() {
        return initState;
    }

    /**
     * 设置 initState
     * @param initState initState
     */
    public void setInitState(String initState) {
        this.initState = initState;
    }

    /**
     * 返回  transitions
     * @return transitions
     */
    public List<Transition> getTransitions() {
        return transitions;
    }

    /**
     * 设置 transitions
     * @param transitions transitions
     */
    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }

}
