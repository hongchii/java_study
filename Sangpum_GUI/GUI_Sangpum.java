package Sangpum_GUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;



public class GUI_Sangpum {

	public static void main(String[] args) {
		JFrame frame = new JFrame("상품 프로그램");
		frame.setPreferredSize(new Dimension(440, 250));
		frame.setLocation(500, 400);
		Container contentPane = frame.getContentPane();
		String colNames[] = { "상품코드", "상품명", "수량", "단가", "금액" };
		DefaultTableModel model = new DefaultTableModel(colNames, 0);
		JTable table = new JTable(model);

		int widths[] = { 70, 70, 50, 50, 50 };
		for (int i = 0; i < widths.length; i++) {
			TableColumn column = table.getColumnModel().getColumn(i);
			column.setPreferredWidth(widths[i]);
		}
		contentPane.add(new JScrollPane(table), BorderLayout.CENTER);
		JPanel panel1 = new JPanel();

		JTextField code = new JTextField(5);
		JTextField irum = new JTextField(3);
		JTextField su = new JTextField(3);
		JTextField dan = new JTextField(3);
		
		JButton button1 = new JButton("추가");
		JButton button2 = new JButton("삭제");
		JButton button3 = new JButton("수정");

		panel1.add(new JLabel("상품코드"));
		panel1.add(code);
		panel1.add(new JLabel("상품명"));
		panel1.add(irum);
		panel1.add(new JLabel("수량"));
		panel1.add(su);
		panel1.add(new JLabel("단가"));
		panel1.add(dan);
		
		JPanel panel2 = new JPanel();
		panel2.add(button1);
		panel2.add(button2);
		panel2.add(button3);

		JPanel panel3 = new JPanel(new BorderLayout());
		panel3.add(panel1, BorderLayout.CENTER);
		panel3.add(panel2, BorderLayout.SOUTH);

		contentPane.add(panel3, BorderLayout.SOUTH);
		
		
		button1.addActionListener(new EventActionListener(table, code, irum, su, dan));
		button2.addActionListener(new EventActionListener(table));
		button3.addActionListener(new EventActionListener(table, code, irum, su, dan));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
	}
}