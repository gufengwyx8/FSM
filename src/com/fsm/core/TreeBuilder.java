/*
 * @(#)TreeBuilder.java 2014-4-21 ÏÂÎç03:07:31 FSM
 */
package com.fsm.core;

import com.fsm.model.FSM;
import com.fsm.model.Transition;
import com.fsm.model.Tree;

/**
 * TreeBuilder
 * @author wang
 * @version 1.0
 *
 */
public class TreeBuilder {
    public Tree build(FSM fsm) {
        Tree tree = new Tree(fsm.getInputs(), fsm.getOutputs(), fsm.getStates());
        int[][] data = tree.getData();
        int[][] outputData = tree.getOutputData();
        tree.setRootIndex(fsm.getStates().indexOf(fsm.getInitState()));
        for (Transition tran : fsm.getTransitions()) {
            String start = tran.getStart(), end = tran.getEnd(), input = tran
                    .getInput(), output = tran.getOutput();
            int startIndex = tree.getStates().indexOf(start);
            int endIndex = tree.getStates().indexOf(end);
            int inputIndex = tree.getInputs().indexOf(input);
            int outputIndex = tree.getOutputs().indexOf(output);
            data[startIndex][inputIndex] = endIndex;
            outputData[startIndex][inputIndex] = outputIndex;
        }
        return tree;
    }
}
