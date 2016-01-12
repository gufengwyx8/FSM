/*
 * @(#)Transition.java 2014-4-21 ����03:05:13 FSM
 */
package com.fsm.model;

/**
 * Transition
 * @author wang
 * @version 1.0
 *
 */
public class Transition {
    private String start;

    private String end;

    private String input;

    private String output;

    /**
     * ����  start
     * @return start
     */
    public String getStart() {
        return start;
    }

    /**
     * ���� start
     * @param start start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * ����  end
     * @return end
     */
    public String getEnd() {
        return end;
    }

    /**
     * ���� end
     * @param end end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * ����  input
     * @return input
     */
    public String getInput() {
        return input;
    }

    /**
     * ���� input
     * @param input input
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * ����  output
     * @return output
     */
    public String getOutput() {
        return output;
    }

    /**
     * ���� output
     * @param output output
     */
    public void setOutput(String output) {
        this.output = output;
    }

}
