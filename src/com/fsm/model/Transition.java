/*
 * @(#)Transition.java 2014-4-21 下午03:05:13 FSM
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
     * 返回  start
     * @return start
     */
    public String getStart() {
        return start;
    }

    /**
     * 设置 start
     * @param start start
     */
    public void setStart(String start) {
        this.start = start;
    }

    /**
     * 返回  end
     * @return end
     */
    public String getEnd() {
        return end;
    }

    /**
     * 设置 end
     * @param end end
     */
    public void setEnd(String end) {
        this.end = end;
    }

    /**
     * 返回  input
     * @return input
     */
    public String getInput() {
        return input;
    }

    /**
     * 设置 input
     * @param input input
     */
    public void setInput(String input) {
        this.input = input;
    }

    /**
     * 返回  output
     * @return output
     */
    public String getOutput() {
        return output;
    }

    /**
     * 设置 output
     * @param output output
     */
    public void setOutput(String output) {
        this.output = output;
    }

}
