package calculator.exmenu;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import calculator.AbstractValueParser;
import calculator.Calculator;
import calculator.DivisionByZeroException;
import calculator.OperationNotSupportedException;
import calculator.ParseValueException;
import calculator.datatypes.complex.ComplexValueParser;
import calculator.datatypes.integer.IntegerValueParser;
import calculator.datatypes.real.RealValueParser;

import java.io.*;

public class ExMenu {
	private JFrame frame;
	private JTextField v1;
	private JTextField v2;
	private JTextField result;
	private JMenuItem saveMenuItem;
	private JButton button;
	private JMenuBar menuBar;
	private JComboBox<String> type;
	private JComboBox<String> op;

	public static void main(String[] args) {
		ExMenu builder = new ExMenu();
		builder.go();
	}
	
	public void go() {
		create();
		button.addActionListener(new ResultListener());
        saveMenuItem.addActionListener(new SaveMenuListener());
	}
	
	public void create() {
		frame = new  JFrame("Menu");
		menuBar = new JMenuBar();
		JMenu fileMenu = new JMenu("File");
		JMenuItem newMenuItem = new JMenuItem("New");
		saveMenuItem = new JMenuItem("Save");
		
		menuBar.setLayout(new GridLayout(10, 4));
		fileMenu.add(newMenuItem);
		fileMenu.add(saveMenuItem);
		menuBar.add(fileMenu);
		
		menuBar.add(new JLabel());
		type = new JComboBox<String>(
				new String[]{"целые числа", "вещественные числа", "комплексные числа"});
		menuBar.add(type);
		menuBar.add(new JLabel());
		
		menuBar.add(new JLabel("Number 1:"));
		v1 = new JTextField(10);
		menuBar.add(v1);
		
		op = new JComboBox(new String[]{"+", "-", "*", "/"});
		menuBar.add(op);
		menuBar.add(new JLabel());
		
		menuBar.add(new JLabel("Number 2:"));
		v2 = new JTextField(10);
		menuBar.add(v2);
		
		menuBar.add(new JLabel("Result:"));		
		result = new JTextField(10);
		menuBar.add(result);
		
		button = new JButton("Result");
		menuBar.add(button); 
	    
		frame.setJMenuBar(menuBar);
		frame.setSize(400, 250);
		frame.setVisible(true);
		
		
	}
	
	public class ResultListener implements ActionListener{
		
		public int getType() {
			String s = (String) type.getSelectedItem();
			if (s.equals("целые числа")) return 0;
			if (s.equals("вещественные числа")) return 1;
			if (s.equals("комплексные числа")) return 2;
			return 3;
		}
		
		public void actionPerformed(ActionEvent e) {
			AbstractValueParser[] valueParsers = new AbstractValueParser[] { new IntegerValueParser(),
					new RealValueParser(), new ComplexValueParser() };
			AbstractValueParser parser = valueParsers[getType()];
			Calculator calc = new Calculator(parser);
			String sv1 = v1.getText(), sv2 = v2.getText();
			String sop = (String) op.getSelectedItem();
			if (sv1.equals("") || sv2.equals("")) {
				return;
			}
			try {
				result.setText(calc.calculate(sv1, sop, sv2));
			} catch (OperationNotSupportedException | ParseValueException | DivisionByZeroException  exception) {
				result.setText(exception.getLocalizedMessage());
				return;
			}
		}
	}
	
	public class SaveMenuListener implements ActionListener {
		public void actionPerformed(ActionEvent ev) {
			 JFileChooser filesave = new JFileChooser();
			 filesave.showSaveDialog(frame);
			 saveFile(filesave.getSelectedFile());
		}
	}
	
	private void saveFile (File file) {
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter(file));
			
			String s = v1.getText();
			result.setText(s);
			
			writer.write(s);
			writer.close();
			
			v1.setText("");
            v2.setText("");
            result.setText("");
			
			
		} catch (IOException ex) {
			System.out.println("couldn't write out");
		}
	}
}