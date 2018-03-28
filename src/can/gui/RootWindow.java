package can.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import can.gates.*;

/**
 * @author Alexander Mogren, Christian Olsson, Nicolas Suau Carvajal
 * @version 2016-11-01
 *
 */
public class RootWindow extends JFrame{
	
	JFrame helpFrame;
	JTextArea area;
	JLabel andOutput;
	JLabel orOutput;
	JLabel norOutput;
	JLabel xorOutput;
	JLabel nandOutput;
	JLabel notOutput;
	JComboBox input1;
	JComboBox input2;
	
	int inputValueAND1;
	int inputValueAND2;

	List<Gate> addedGates = new ArrayList<>();
	String[] items = {"0", "1"};
	
	JMenu menu;
	JMenu submenu;
	JMenuBar menuBar;
	JMenuItem menuItemHelp;
	JMenuItem menuItemAbout;
	JMenuItem menuItemRemoveAll;
	JMenuItem menuItemQuit;
	JMenuItem menuItemAND;
	JMenuItem menuItemOR;
	JMenuItem menuItemXOR;
	JMenuItem menuItemNOT;
	JMenuItem menuItemNAND;
	JMenuItem menuItemNOR;
	List<Integer> outputList = new ArrayList<>();
	
	AND and;
	NAND nand;
	NOR nor;
	OR or;
	NOT not;
	XOR xor;
	
	JButton fuckingButton = new JButton("Get added gates");
	//JPanel p;
	JPanel inception;// = new JPanel();W
	
	public RootWindow(String title){
		
		inception = new JPanel();
		inception.setSize(getWidth(), getHeight());
		inception.setBackground(Color.WHITE);
		inception.add(fuckingButton);
		add(inception);
		
		//inception.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		//inception.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setPreferredSize(new Dimension(800,800));
		setResizable(false);
		setBackground(Color.WHITE);
		
		fuckingButton.addActionListener(new fuckingListener());
		
		//Creating a menubar
		menuBar = new JMenuBar();
		menu = new JMenu("Menu");
		menuItemHelp = new JMenuItem("help"); 
		menuBar.add(menu);
		menuBar.add(menuItemHelp);
		menuItemAbout = new JMenuItem("About");
		menu.add(menuItemAbout);
		menuItemRemoveAll = new JMenuItem("Remove all");
		menu.add(menuItemRemoveAll);
		
		submenu = new JMenu("Add gates");
		
		menuItemAND = new JMenuItem("Logic AND");
		submenu.add(menuItemAND);
		
		menuItemOR = new JMenuItem("Logic OR");
		submenu.add(menuItemOR);
		
		menuItemXOR = new JMenuItem("Logic XOR");
		submenu.add(menuItemXOR);
		
		menuItemNOT = new JMenuItem("Logic NOT");
		submenu.add(menuItemNOT);
		
		menuItemNAND = new JMenuItem("Logic NAND");
		submenu.add(menuItemNAND);
		
		menuItemNOR = new JMenuItem("Logic NOR");
		submenu.add(menuItemNOR);
		
		menu.add(submenu);
		
		menuItemQuit = new JMenuItem("Quit");
		menu.add(menuItemQuit);
		
		setJMenuBar(menuBar);	
		
		setTitle(title);
		pack();
		
		setVisible(true);
	
		menuItemHelp.addActionListener(new MenuItemHelpListener());
		menuItemAbout.addActionListener(new MenuItemAboutListener());
		menuItemRemoveAll.addActionListener(new MenuItemRemoveAllListener());
		menuItemQuit.addActionListener(new MenuItemQuitListener());
		menuItemAND.addActionListener(new MenuItemANDListener());
		menuItemOR.addActionListener(new MenuItemORListener());
		menuItemXOR.addActionListener(new MenuItemXORListener());
		menuItemNOT.addActionListener(new MenuItemNOTListener());
		menuItemNAND.addActionListener(new MenuItemNANDListener());
		menuItemNOR.addActionListener(new MenuItemNORListener());
				
		}
	private class fuckingListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent fucking_e) {
			// TODO Auto-generated method stub
			getAddedGates();
			
		}
		
	}
	
	private class MenuItemHelpListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			helpFrame = new JFrame("Help");
			area = new JTextArea();
			area.setEditable(false);
			area.setLineWrap(true);
			area.setWrapStyleWord(true);
			try {
				Scanner scan = new Scanner(new File("Helpfile.txt"));
				scan.useDelimiter("#");
				while(scan.hasNext()) {
					area.append(scan.next());
				}
				scan.close();
			}
			catch(FileNotFoundException e1) {
				e1.printStackTrace();
				area.setText(e1.toString());
			}
			helpFrame.add(area);
			helpFrame.setResizable(false);
			helpFrame.setSize(1000, 1000);
			helpFrame.setLocation(500,500);
			helpFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			helpFrame.setVisible(true);
		}
	}
	
	private class MenuItemAboutListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("About");
		}
	}
	
	private class MenuItemRemoveAllListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			outputList.clear();
			addedGates.clear();
			inception.removeAll();
			inception.repaint();
		}
	}
	
	private class MenuItemQuitListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			Runtime.getRuntime().exit(0);
		}
	}
	
	private class MenuItemANDListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			
			JPanel p = new JPanel();
			//p.setSize(100, 100);
			p.setPreferredSize(new Dimension(200,80));
			p.setBackground(Color.WHITE);
			and = new AND(0,0);
			addedGates.add(and);
			
			System.err.println("STORLEK PÅ ARRAY: "+addedGates.size());
			
			System.out.println("Logic AND");
			//outputList.add(counter, and.getOutput());
			
			input1 = new JComboBox(items);
			input2 = new JComboBox(items);
			
			andOutput = new JLabel("0");
			JLabel andLabel = new JLabel(new ImageIcon("AND.png"));
			DragListener drag = new DragListener();
			p.addMouseListener(drag);
			p.addMouseMotionListener(drag);
			input1.addActionListener(new ANDListener());
			input2.addActionListener(new ANDListener());

			p.add(input1);
			p.add(input2);
			p.add(andLabel);
			p.add(andOutput);
			
			inception.add(p);
			setEnabledGate();
			p.revalidate();
			
			
			
		}
	}
	
	private class MenuItemORListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel p = new JPanel();
			or = new OR(0,0);
			addedGates.add(or);
			p.setBackground(Color.WHITE);
			
			System.out.println("Logic OR");
			
			input1 = new JComboBox(items);
			input2 = new JComboBox(items);
			orOutput = new JLabel("0");
			JLabel orLabel = new JLabel(new ImageIcon("OR.png"));
			DragListener drag = new DragListener();
			p.addMouseListener(drag);
			p.addMouseMotionListener(drag);
			input1.addActionListener(new ORListener());
			input2.addActionListener(new ORListener());
			p.add(input1);
			p.add(input2);
			p.add(orLabel);
			p.add(orOutput);
			inception.add(p);
			setEnabledGate();
			p.revalidate();
		}
	}
	
	private class MenuItemXORListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel p = new JPanel();
			xor = new XOR(0, 0);
			System.out.println("Logic XOR");
			p.setBackground(Color.WHITE);
			addedGates.add(xor);
			
			input1 = new JComboBox(items);
			input2 = new JComboBox(items);
			xorOutput = new JLabel("0");
			JLabel xorLabel = new JLabel(new ImageIcon("XOR.png"));
			DragListener drag = new DragListener();
			p.addMouseListener(drag);
			p.addMouseMotionListener(drag);
			input1.addActionListener(new XORListener());
			input2.addActionListener(new XORListener());
			p.add(input1);
			p.add(input2);
			p.add(xorLabel);
			p.add(xorOutput);
			inception.add(p);
			setEnabledGate();
			p.revalidate();
		}
	}
	
	private class MenuItemNOTListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel p = new JPanel();
			not = new NOT(0);
			System.out.println("Logic NOT");
			p.setBackground(Color.WHITE);
			
			input1 = new JComboBox(items);
			notOutput = new JLabel("0");
			JLabel notLabel = new JLabel(new ImageIcon("NOT.png"));
			DragListener drag = new DragListener();
			p.addMouseListener(drag);
			p.addMouseMotionListener(drag);
			input1.addActionListener(new NOTListener());
			p.add(input1);
			p.add(notLabel);
			p.add(notOutput);
			inception.add(p);
			setEnabledGate();
			p.revalidate();
		}
	}
	
	private class MenuItemNANDListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel p = new JPanel();
			nand = new NAND(0, 0);
			System.out.println("Logic NAND");
			p.setBackground(Color.WHITE);
			addedGates.add(nand);
			
			input1 = new JComboBox(items);
			input2 = new JComboBox(items);
			nandOutput = new JLabel("0");
			JLabel nandLabel = new JLabel(new ImageIcon("NAND.png"));
			DragListener drag = new DragListener();
			p.addMouseListener(drag);
			p.addMouseMotionListener(drag);
			input1.addActionListener(new NANDListener());
			input2.addActionListener(new NANDListener());
			
			p.add(input1);
			p.add(input2);
			p.add(nandLabel);
			p.add(nandOutput);
			inception.add(p);
			setEnabledGate();
			p.revalidate();
		}
	}

	private class MenuItemNORListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			JPanel p = new JPanel();
			nor = new NOR(0, 0);
			System.out.println("Logic NOR");
			p.setBackground(Color.WHITE);
			addedGates.add(nor);
			
			input1 = new JComboBox(items);
			input2 = new JComboBox(items);
			
			norOutput = new JLabel("0");
			JLabel norLabel = new JLabel(new ImageIcon("NOR.png"));
			DragListener drag = new DragListener();
			p.addMouseListener(drag);
			p.addMouseMotionListener(drag);
			input1.addActionListener(new NORListener());
			input2.addActionListener(new NORListener());
			
			p.add(input1);
			p.add(input2);
			p.add(norLabel);
			p.add(norOutput);
			inception.add(p);
			setEnabledGate();
			p.revalidate();
		}
	}
	
	private class NOTListener implements ActionListener {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			int inputValue;
			if(input1.getSelectedItem().equals("1")) {
				inputValue = 1;
			}
			else {
				inputValue = 0;
			}
			NOT not = new NOT(inputValue);
			not.calcNOT();
			if(not.getOutput()==1) {
				notOutput.setText("1");
			}
			else {
				notOutput.setText("0");
			}	
		}
	}
	
	private class ANDListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			int inputValueA = 0;
			int inputValueB = 0;
						
			if(input1.getSelectedItem().equals("1")){
				inputValueA = 1;
			}
			if(input2.getSelectedItem().equals("1")){
				inputValueB = 1;
			}
			
			and.setInputA(inputValueA);
			and.setInputB(inputValueB);
									
			and.calcAND();
			if(and.getOutput()==1){
				andOutput.setText("1");
			}
			else{
				andOutput.setText("0");
			}
		}

	}
	
	private class ORListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			int inputValueA = 0;
			int inputValueB = 0;
						
			if(input1.getSelectedItem().equals("1")){
				inputValueA = 1;
			}
			if(input2.getSelectedItem().equals("1")){
				inputValueB = 1;
			}
			
			or.setInputA(inputValueA);
			or.setInputB(inputValueB);
									
			or.calcOR();
			if(or.getOutput()==1){
				orOutput.setText("1");
			}
			else{
				orOutput.setText("0");
			}
		}
	}
	private class XORListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			
			int inputValueA = 0;
			int inputValueB = 0;
			
			if(input1.getSelectedItem().equals("1")){
				inputValueA = 1;
			}
			
			if (input2.getSelectedItem().equals("1")){
				inputValueB= 1;
			}
			
			XOR xor = new XOR(inputValueA, inputValueB);
			xor.calcXOR();
			if(xor.getOutput()==1)
				xorOutput.setText("1");
			else
				xorOutput.setText("0");
		}
	}
	private class NORListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			
			int inputValueA = 0;
			int inputValueB = 0;
			
			if(input1.getSelectedItem().equals("1")){
				inputValueA = 1;
			}
			
			if (input2.getSelectedItem().equals("1")){
				inputValueB= 1;
			}
			
			NOR nor = new NOR(inputValueA, inputValueB);
			nor.calcNOR();
			if(nor.getOutput()==1)
				norOutput.setText("1");
			else
				norOutput.setText("0");
		}
	}
	private class NANDListener implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e){
			
			int inputValueA = 0;
			int inputValueB = 0;
			
			if(input1.getSelectedItem().equals("1")){
				inputValueA = 1;
			}
			
			if (input2.getSelectedItem().equals("1")){
				inputValueB= 1;
			}
			
			NAND nand = new NAND(inputValueA, inputValueB);
			nand.calcNAND();
			if(nand.getOutput()==1)
				nandOutput.setText("1");
			else
				nandOutput.setText("0");
		}
	}

	public void getAddedGates() {
		if(addedGates.isEmpty())
			System.out.println("No gates added!");
		for(Gate g : addedGates){
			System.out.println("GATE "+addedGates.indexOf(g)+" "+"Input A = "+g.getInputA());
			System.out.println("GATE "+addedGates.indexOf(g)+" "+"Input B = "+g.getInputB());
			System.out.println("GATE "+addedGates.indexOf(g)+" "+"Output = "+g.getOutput()+"\n");
		}
	}
	
	public void setJComboBox() {
		
	}
		
	public void setEnabledGate(){
		if(addedGates.size()>1) {
			setJComboBox();
		}
	
		for (int i = 1; i < addedGates.size(); i++) {
		
			System.out.println("Output: "+addedGates.get(i).getOutput());
			addedGates.get(i).setCombo(input1);
			addedGates.get(i).setCombo(input2);
			input1.setSelectedIndex(addedGates.get(i).getOutput());
			input2.setSelectedIndex(addedGates.get(i).getOutput());
		}
	}
}	