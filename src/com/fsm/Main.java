/*
 * @(#)Main.java 2014-4-21 ����03:38:56 FSM
 */
package com.fsm;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Set;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import com.fsm.core.FSMBuilder;
import com.fsm.core.FileUtil;
import com.fsm.core.Test;
import com.fsm.core.TreeBuilder;
import com.fsm.core.WAlgorithm;
import com.fsm.model.FSM;
import com.fsm.model.Tree;

/**
 * Main
 * @author wang
 * @version 1.0
 *
 */
public class Main extends JFrame {

    private JTextArea txt = new JTextArea();

    private JTextArea txt2 = new JTextArea();

    private JLabel lbl = new JLabel("", JLabel.CENTER);

    private JLabel lbl2 = new JLabel("", JLabel.CENTER);

    private JMenuItem btnFsm = new JMenuItem("ѡ��淶�Զ���");

    private JMenuItem btnFsmImg = new JMenuItem("ѡ��淶�Զ���ͼƬ");

    private JMenuItem btnTestFsm = new JMenuItem("ѡ��������Զ���");

    private JMenuItem btnTestFsmImg = new JMenuItem("ѡ��������Զ���ͼƬ");

    private JMenuItem btnOutput = new JMenuItem("����W��������");

    private JMenuItem btnWpOutput = new JMenuItem("����Wp��������");

    private JMenuItem btnW = new JMenuItem("����W��������");

    private JMenuItem btnWp = new JMenuItem("����Wp��������");

    private JMenuItem btnResult = new JMenuItem("���W���Խ��");

    private JMenuItem btnWpResult = new JMenuItem("���Wp���Խ��");

    private String output, outputWp, fsmPath, testFsmPath;

    public Main() {
        super("FSM����ϵͳ");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setBounds(50, 50, 1000, 700);
        this.setLayout(new GridLayout(2, 2, 10, 10));

        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("�淶״̬��");
        menu.add(btnFsm);
        menu.add(btnFsmImg);
        menuBar.add(menu);

        menu = new JMenu("�����㷨");
        JMenu menu2 = new JMenu("W�����㷨");
        menu2.add(btnW);
        menu2.add(btnOutput);
        menu.add(menu2);
        menu2 = new JMenu("Wp�����㷨");
        menu2.add(btnWp);
        menu2.add(btnWpOutput);
        menu.add(menu2);
        menuBar.add(menu);

        menu = new JMenu("������״̬��");
        menu.add(btnTestFsm);
        menu.add(btnTestFsmImg);
        menuBar.add(menu);

        menu = new JMenu("���Խ��");
        menu.add(btnResult);
        menu.add(btnWpResult);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);

        this.add(new JScrollPane(lbl));
        this.add(new JScrollPane(txt));
        this.add(new JScrollPane(lbl2));
        this.add(new JScrollPane(txt2));

        btnFsm.addActionListener(new Monitor());
        btnFsmImg.addActionListener(new Monitor());
        btnTestFsm.addActionListener(new Monitor());
        btnTestFsmImg.addActionListener(new Monitor());
        btnOutput.addActionListener(new Monitor());
        btnResult.addActionListener(new Monitor());
        btnWpResult.addActionListener(new Monitor());
        btnWpOutput.addActionListener(new Monitor());
        btnW.addActionListener(new Monitor());
        btnWp.addActionListener(new Monitor());
        this.setVisible(true);
    }

    private class Monitor implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnFsm) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
                    /*
                     * String str = FileUtil.readFile(chooser.getSelectedFile()
                     * .getAbsolutePath()); txt.setText(str);
                     */
                    fsmPath = chooser.getSelectedFile().getAbsolutePath();
                    //lbl.setIcon(new ImageIcon("��ͼ1.jpg"));
                }
            } else if (e.getSource() == btnTestFsm) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
                    /*
                     * String str = FileUtil.readFile(chooser.getSelectedFile()
                     * .getAbsolutePath()); txt.setText(str);
                     */
                    //lbl2.setIcon(new ImageIcon("��ͼ2.jpg"));
                    testFsmPath = chooser.getSelectedFile().getAbsolutePath();
                }
            } else if (e.getSource() == btnW) {
                FSMBuilder fsmBuilder = new FSMBuilder();
                TreeBuilder treeBuilder = new TreeBuilder();
                WAlgorithm wAlgorithm = new WAlgorithm();

                FSM fsm = fsmBuilder.build(fsmPath);
                Tree tree = treeBuilder.build(fsm);
                Set<String> pSet = wAlgorithm.getP(tree);
                Set<String> wSet = wAlgorithm.getW(tree);
                StringBuilder result = new StringBuilder();
                //result.append("P Set:" + pSet + "\n");
                //result.append("W Set:" + wSet + "\n");

                Set<String> zSet = wSet;
                Set<String> tSet = wAlgorithm.getT(pSet, zSet);
                result.append("W��������:" + "\n");
                for (String s : tSet) {
                    result.append(s + "\n");
                }
                result.append("��" + tSet.size() + "����������");
                txt.setText(result.toString());
                Test test = new Test();
                output = test.output(fsm, tSet);
            } else if (e.getSource() == btnWp) {
                FSMBuilder fsmBuilder = new FSMBuilder();
                TreeBuilder treeBuilder = new TreeBuilder();
                WAlgorithm wAlgorithm = new WAlgorithm();

                FSM fsm = fsmBuilder.build(fsmPath);
                Tree tree = treeBuilder.build(fsm);
                Set<String> pSet = wAlgorithm.getP(tree);
                Set<String> wSet = wAlgorithm.getW(tree);

                Set<String> sSet = wAlgorithm.getS(tree);
                List<Set<String>> wpSet = wAlgorithm.getWp(tree);
                Set<String> t1Set = wAlgorithm.getT1(tree, sSet, wSet);
                Set<String> rSet = wAlgorithm.getR(pSet, sSet);
                Set<String> t2Set = wAlgorithm.getT2(fsm, tree, rSet, wpSet);
                Set<String> tWpSet = wAlgorithm.getTWp(t1Set, t2Set);

                StringBuilder result = new StringBuilder();
                result.append("P Set:" + pSet + "\n");
                result.append("W Set:" + wSet + "\n");
                result.append("S Set:" + sSet + "\n");
                result.append("Wp Set:" + wpSet + "\n");
                result.append("T1 Set:" + t1Set + "\n");
                result.append("R Set:" + rSet + "\n");
                result.append("T2 Set:" + t2Set + "\n");
                result.append("Wp��������:" + "\n");
                for (String s : tWpSet) {
                    result.append(s + "\n");
                }
                result.append("��" + tWpSet.size() + "����������");
                txt.setText(result.toString());
                Test test = new Test();
                outputWp = test.output(fsm, tWpSet);
            } else if (e.getSource() == btnOutput) {
                if (output != null) {
                    JFileChooser chooser = new JFileChooser();
                    if (chooser.showSaveDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
                        FileUtil.writeFile(chooser.getSelectedFile()
                                .getAbsolutePath(), output);
                    }
                }
            } else if (e.getSource() == btnWpOutput) {
                if (outputWp != null) {
                    JFileChooser chooser = new JFileChooser();
                    if (chooser.showSaveDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
                        FileUtil.writeFile(chooser.getSelectedFile()
                                .getAbsolutePath(), outputWp);
                    }
                }
            } else if (e.getSource() == btnResult) {
                FSMBuilder fsmBuilder = new FSMBuilder();
                TreeBuilder treeBuilder = new TreeBuilder();
                WAlgorithm wAlgorithm = new WAlgorithm();

                FSM fsm = fsmBuilder.build(fsmPath);
                Tree tree = treeBuilder.build(fsm);
                Set<String> pSet = wAlgorithm.getP(tree);
                Set<String> wSet = wAlgorithm.getW(tree);

                Set<String> zSet = wSet;
                Set<String> tSet = wAlgorithm.getT(pSet, zSet);

                FSM testFsm = fsmBuilder.build(testFsmPath);
                Test test = new Test();
                txt2.setText(test.test(fsm, testFsm, tSet));
            } else if (e.getSource() == btnWpResult) {
                FSMBuilder fsmBuilder = new FSMBuilder();
                TreeBuilder treeBuilder = new TreeBuilder();
                WAlgorithm wAlgorithm = new WAlgorithm();

                FSM fsm = fsmBuilder.build(fsmPath);
                Tree tree = treeBuilder.build(fsm);
                Set<String> pSet = wAlgorithm.getP(tree);
                Set<String> wSet = wAlgorithm.getW(tree);

                Set<String> sSet = wAlgorithm.getS(tree);
                List<Set<String>> wpSet = wAlgorithm.getWp(tree);
                Set<String> t1Set = wAlgorithm.getT1(tree, sSet, wSet);
                Set<String> rSet = wAlgorithm.getR(pSet, sSet);
                Set<String> t2Set = wAlgorithm.getT2(fsm, tree, rSet, wpSet);
                Set<String> tWpSet = wAlgorithm.getTWp(t1Set, t2Set);

                FSM testFsm = fsmBuilder.build(testFsmPath);
                Test test = new Test();
                txt2.setText(test.test(fsm, testFsm, tWpSet));
            } else if (e.getSource() == btnFsmImg) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
                    /*
                     * String str = FileUtil.readFile(chooser.getSelectedFile()
                     * .getAbsolutePath()); txt.setText(str);
                     */
                    lbl.setIcon(new ImageIcon(chooser.getSelectedFile()
                            .getAbsolutePath()));
                }
            } else if (e.getSource() == btnTestFsmImg) {
                JFileChooser chooser = new JFileChooser();
                if (chooser.showOpenDialog(Main.this) == JFileChooser.APPROVE_OPTION) {
                    /*
                     * String str = FileUtil.readFile(chooser.getSelectedFile()
                     * .getAbsolutePath()); txt.setText(str);
                     */
                    lbl2.setIcon(new ImageIcon(chooser.getSelectedFile()
                            .getAbsolutePath()));
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new Main();
    }
}
