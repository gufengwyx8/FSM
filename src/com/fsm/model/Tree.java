/*
 * @(#)Tree.java 2014-4-21 下午03:08:29 FSM
 */
package com.fsm.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Tree
 * @author wang
 * @version 1.0
 *
 */
public class Tree {
    private List<String> inputs = new ArrayList<String>();

    private List<String> outputs = new ArrayList<String>();

    private List<String> states = new ArrayList<String>();

    private int[][] data = null;

    private int[][] outputData = null;
    
    private int rootIndex;

    /**
     * @param inputs
     * @param states
     * @param data
     */
    public Tree(List<String> inputs, List<String> outputs, List<String> states) {
        this.inputs = inputs;
        this.outputs = outputs;
        this.states = states;
        data = new int[states.size()][inputs.size()];
        outputData = new int[states.size()][inputs.size()];
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                data[i][j] = -1;
            }
        }
        for (int i = 0; i < outputData.length; i++) {
            for (int j = 0; j < outputData[i].length; j++) {
                outputData[i][j] = -1;
            }
        }
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
     * 返回  data
     * @return data
     */
    public int[][] getData() {
        return data;
    }

    /**
     * 设置 data
     * @param data data
     */
    public void setData(int[][] data) {
        this.data = data;
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
     * 返回  outputData
     * @return outputData
     */
    public int[][] getOutputData() {
        return outputData;
    }

    /**
     * 设置 outputData
     * @param outputData outputData
     */
    public void setOutputData(int[][] outputData) {
        this.outputData = outputData;
    }

    /**
     * 返回  rootIndex
     * @return rootIndex
     */
    public int getRootIndex() {
        return rootIndex;
    }

    /**
     * 设置 rootIndex
     * @param rootIndex rootIndex
     */
    public void setRootIndex(int rootIndex) {
        this.rootIndex = rootIndex;
    }

}
