/*
 * @(#)Tree.java 2014-4-21 ����03:08:29 FSM
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
     * ����  data
     * @return data
     */
    public int[][] getData() {
        return data;
    }

    /**
     * ���� data
     * @param data data
     */
    public void setData(int[][] data) {
        this.data = data;
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
     * ����  outputData
     * @return outputData
     */
    public int[][] getOutputData() {
        return outputData;
    }

    /**
     * ���� outputData
     * @param outputData outputData
     */
    public void setOutputData(int[][] outputData) {
        this.outputData = outputData;
    }

    /**
     * ����  rootIndex
     * @return rootIndex
     */
    public int getRootIndex() {
        return rootIndex;
    }

    /**
     * ���� rootIndex
     * @param rootIndex rootIndex
     */
    public void setRootIndex(int rootIndex) {
        this.rootIndex = rootIndex;
    }

}
