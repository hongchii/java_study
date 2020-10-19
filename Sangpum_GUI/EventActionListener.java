package Sangpum_GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import sungjuk_GUI.Sungjuk;

public class EventActionListener implements ActionListener {
	JTable table;
	JTextField txtCode, txtIrum, txtSu, txtDan;

	EventActionListener() {

	}

	EventActionListener(JTable table) {
		this.table = table;
	}

	EventActionListener(JTable table, JTextField txtCode, JTextField txtIrum, JTextField txtSu, JTextField txtDan) {
		this.table = table;
		this.txtCode = txtCode;
		this.txtIrum = txtIrum;
		this.txtSu = txtSu;
		this.txtDan = txtDan;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getActionCommand().equals("추가")) {
			insert();
		} else if (e.getActionCommand().equals("삭제")) {
			delete();
		} else {
			update();
		}
	}

	public void insert() {
		Sangpum obj = new Sangpum();
		int i, rowNum, flag = 0;

		DefaultTableModel model = (DefaultTableModel) table.getModel();

		obj.code = txtCode.getText().trim();
		rowNum = model.getRowCount();
		for (i = 0; i < rowNum; i++) {
			String table_code = model.getValueAt(i, 0).toString().trim();
			if (table_code.equals(obj.code)) {
				flag = 1;
				break;
			}
		}
		if (flag == 0) {
			obj.irum = txtIrum.getText().trim();
			obj.su = Integer.parseInt(txtSu.getText().trim());
			obj.dan = Integer.parseInt(txtDan.getText().trim());

			obj.process_sangpum();

			Object arr[] = new Object[8];
			arr[0] = obj.code;
			arr[1] = obj.irum;
			arr[2] = obj.su;
			arr[3] = obj.dan;

			model.addRow(arr);
			JOptionPane.showMessageDialog(null, "상품코드" + obj.code + "추가 성공!");

		} else
			JOptionPane.showMessageDialog(null, "상품코드" + obj.code + "중복 오류로 추가 실패!");

		txtCode.setText("");
		txtIrum.setText("");
		txtSu.setText("");
		txtDan.setText("");

	}

	public void delete() {
		int row = table.getSelectedRow();
		if (row == -1) {
			return;
		}

		DefaultTableModel model = (DefaultTableModel) table.getModel();
		String code = model.getValueAt(row, 0).toString().trim();
		model.removeRow(row);
		JOptionPane.showMessageDialog(null, "상품코드" + code + "삭제 성공!");
	}

	public void update() {
		int i, rowNum, flag = 0;
		String table_code = null;
		DefaultTableModel model = (DefaultTableModel) table.getModel();
		Sangpum obj = new Sangpum();

		obj.code = txtCode.getText().trim();
		obj.su = Integer.parseInt(txtSu.getText().trim());
		obj.dan = Integer.parseInt(txtDan.getText().trim());
		obj.process_sangpum();

		rowNum = model.getRowCount();
		for (i = 0; i < rowNum; i++) {
			table_code = model.getValueAt(i, 0).toString().trim();
			if (table_code.equals(obj.code)) {
				model.setValueAt(obj.su, i, 2);
				model.setValueAt(obj.dan, i, 3);
				flag = 1;
				break;
			}
		}

		if (flag == 0) {
			JOptionPane.showMessageDialog(null, "학번" + obj.code + "수정 실패!");
		} else
			JOptionPane.showMessageDialog(null, "학번" + obj.code + "수정 성공!");

		txtCode.setText("");
		txtIrum.setText("");
		txtSu.setText("");
		txtDan.setText("");

	}
}
