/*
 * @(#)WAlgorithm.java 2014-4-21 ÏÂÎç03:25:12 FSM
 */
package com.fsm.core;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.fsm.model.FSM;
import com.fsm.model.Tree;

/**
 * WAlgorithm
 * @author wang
 * @version 1.0
 *
 */
public class WAlgorithm {

    public Set<String> getT(Set<String> pSet, Set<String> zSet) {
        Set<String> tSet = new TreeSet<String>();
        for (String p : pSet) {
            for (String z : zSet) {
                tSet.add(p + z);
            }
        }
        for (String z : zSet) {
            tSet.add(z);
        }
        return tSet;
    }

    public Set<String> getP(Tree tree) {
        Set<String> pSet = new TreeSet<String>();
        int rootIndex = tree.getRootIndex();
        getP(tree, rootIndex, pSet, new ArrayList<Integer>(), "");
        return pSet;
    }

    private void getP(Tree tree, int rootIndex, Set<String> pSet,
            List<Integer> rootList, String str) {
        if (rootList.contains(rootIndex)) {
            return;
        }
        rootList.add(rootIndex);
        for (int i = 0; i < tree.getInputs().size(); i++) {
            if (tree.getData()[rootIndex][i] != -1) {
                pSet.add(str + tree.getInputs().get(i));
                getP(tree, tree.getData()[rootIndex][i], pSet, rootList, str
                        + tree.getInputs().get(i));
            }
        }
    }

    public Set<String> getW(Tree tree) {
        Set<String> wSet = new TreeSet<String>();
        List<String> states = tree.getStates();
        for (int i = 0; i < states.size(); i++) {
            for (int j = i + 1; j < states.size(); j++) {
                String xStr = findX(tree, i, j, new ArrayList<int[]>());
                if (xStr != null) {
                    wSet.add(xStr);
                }
            }
        }
        return wSet;
    }

    private boolean isRepeat(int s1Index, int s2Index, List<int[]> tmp) {
        for (int[] arr : tmp) {
            if (arr[0] == s1Index && arr[1] == s2Index || arr[1] == s1Index
                    && arr[0] == s2Index) {
                return true;
            }
        }
        return false;
    }

    private String findX(Tree tree, int s1Index, int s2Index, List<int[]> tmp) {
        if (s1Index == s2Index || isRepeat(s1Index, s2Index, tmp)) {
            return null;
        }
        int[] arr = new int[2];
        arr[0] = s1Index;
        arr[1] = s2Index;
        tmp.add(arr);
        List<String> inputs = tree.getInputs();
        for (String s : inputs) {
            int inputIndex = inputs.indexOf(s);
            if (tree.getOutputData()[s1Index][inputIndex] == tree
                    .getOutputData()[s2Index][inputIndex]) {
                String ret = findX(tree, tree.getData()[s1Index][inputIndex],
                    tree.getData()[s2Index][inputIndex], tmp);
                if (ret != null) {
                    return s + ret;
                }
            } else {
                return s;
            }
        }
        return null;
    }

    public Set<String> getS(Tree tree) {
        Set<String> sSet = new TreeSet<String>();
        List<Integer> stateList = new ArrayList<Integer>();
        List<String> inputList = new ArrayList<String>();
        int state = tree.getRootIndex();
        stateList.add(state);
        inputList.add("");
        for (int i = 0; i < stateList.size(); i++) {
            String input = inputList.get(i);
            for (int j = 0; j < tree.getInputs().size(); j++) {
                int nextState = tree.getData()[stateList.get(i)][j];
                if (nextState != -1 && !stateList.contains(nextState)) {
                    stateList.add(nextState);
                    inputList.add(input + tree.getInputs().get(j));
                    sSet.add(input + tree.getInputs().get(j));
                }
            }
        }
        return sSet;
    }

    public List<Set<String>> getWp(Tree tree) {
        List<Set<String>> wpSet = new ArrayList<Set<String>>();
        List<String> states = tree.getStates();
        for (int i = 0; i < states.size(); i++) {
            Set<String> wSet = new TreeSet<String>();
            for (int j = 0; j < states.size(); j++) {
                String xStr = findX(tree, i, j, new ArrayList<int[]>());
                if (xStr != null) {
                    wSet.add(xStr);
                }
            }
            wpSet.add(wSet);
        }
        return wpSet;
    }

    public Set<String> getT1(Tree tree, Set<String> sSet, Set<String> wSet) {
        Set<String> t1Set = new TreeSet<String>();
        for (String s : sSet) {
            for (String w : wSet) {
                t1Set.add(s + w);
            }
        }
        for (String w : wSet) {
            t1Set.add(w);
        }
        return t1Set;
    }

    public Set<String> getR(Set<String> pSet, Set<String> sSet) {
        Set<String> rSet = new TreeSet<String>(pSet);
        rSet.removeAll(sSet);
        return rSet;
    }

    public Set<String> getT2(FSM fsm, Tree tree, Set<String> rSet,
            List<Set<String>> wpSet) {
        Set<String> t2Set = new TreeSet<String>();
        for (String r : rSet) {
            int finalState = fsm.getStates().indexOf(fsm.finalState(r));
            Set<String> wSet = wpSet.get(finalState);
            for (String w : wSet) {
                t2Set.add(r + w);
            }
        }
        return t2Set;
    }

    public Set<String> getTWp(Set<String> t1Set, Set<String> t2Set) {
        Set<String> tWpSet = new TreeSet<String>(t1Set);
        tWpSet.addAll(t2Set);
        return tWpSet;
    }
}
