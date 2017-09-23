package com.owlet.game.draw.ui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;

import com.owlet.game.draw.data.Character;
import com.owlet.game.draw.data.CharacterTable;

@SuppressWarnings("serial")
/**
 * 플레이어가 가진 캐릭터를 보여줄 테이블 클래스입니다.
 * 
 * @version 1.0
 * @since 17-09-22
 */
public class CharacterCardShowTable extends JTable {
	//============================================
	//
	//		Constant
	//
	//============================================
	
	private static final int MOUSE_EXITED = -1;
	
	
	
	
	//============================================
	//
	//		Variables
	//
	//============================================
	
	int rolloveredRow = MOUSE_EXITED;
	int rolloveredColumn = MOUSE_EXITED;
	ArrayList<Character> characterList = new ArrayList<Character>();
	
	
	
	
	//============================================
	//
	//		Constructor
	//
	//============================================
	
	public CharacterCardShowTable(ArrayList<Character> characterList) {
		/* Character Data Including */
		this.characterList = characterList;
		
		if(characterList == null) {
			System.out.println("null 감지됨");
		}
		
		System.out.println("데이터 크기 : " + characterList.size());
		System.out.println("내용 : " + characterList);
		
		/* Table Model Initialization */
		MyTableModel tableModel = new MyTableModel(characterList);
		setModel(tableModel);

		/* Table Initializations */
		setGridColor(Color.BLACK);
		setOpaque(false);
		setRowHeight(200);
		
		setTableHeader(null);
		setDefaultRenderer(Object.class, new AttributiveCellRenderer());

		/* Mouse adapter initialization */
		MyMouseAdapter mouseAdapter = new MyMouseAdapter();
		addMouseMotionListener(mouseAdapter);
		addMouseListener(mouseAdapter);
	}
	
	//==================================================================================================//

	/**
	 * @version 1.0 (어레이리스트를 패러미터로 받는 테이블 모델)
	 * @since 17-09-19
	 */
	public class MyTableModel extends AbstractTableModel {
		
		/*
		 * 이 모델의 컬럼 사이즈는 3개로 고정되어 있음 ( String {"Lane0", "Lane1", "Lane2"} )
		 */
		
		//============================================
		//
		//		Constant
		//
		//============================================
		
		private static final int SIZE_COLUMN = 3;
		
		
		
		
		//============================================
		//
		//		Variables
		//
		//============================================
		
		private String[] column_index = {"Lane0", "Lane1", "Lane2"};
		private ArrayList<String> column = new ArrayList<String>();
		private ArrayList<Character> data;
		int rowCount;
		
		
		
		
		//============================================
		//
		//		Constructor
		//
		//============================================
		
		/**
		 * @param ArrayList<쓰기> data - row에 표시할 데이터를 가지고 있는 ArrayList객체
		 */
		public MyTableModel(ArrayList<Character> data) {
			for(int i = 0; i < SIZE_COLUMN; i++) {
				column.add(column_index[i]);
			}

			this.data = data;
			if(this.data.size() == 0) {
				this.rowCount = 0;
			}
			else {
				this.rowCount = this.data.size() / 3;
				if(this.data.size() % 3 != 0) {
					this.rowCount++;
				}
			}
		}

		
		
		
		//============================================
		//
		//		Accessors
		//
		//============================================
		
		@Override
		public int getRowCount() {
			return rowCount;
		}

		@Override
		public int getColumnCount() {
			return SIZE_COLUMN;
		}

		@Override
		public Character getValueAt(int rowIndex, int columnIndex) {
			Character temp;

			try {
				temp = data.get(rowIndex * 3 + columnIndex);
			}
			catch(IndexOutOfBoundsException e) {
				return CharacterTable.CHARS_NULL;
			}

			return temp;
		}

		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			/* 셀 에디트 불가능 */
			return false;
		}
	}

	/**
	 * @version 1.0 (마우스 어댑터)
	 * @since 17-09-19
	 * @see http://www.devx.com/tips/Tip/17285
	 */
	public class MyMouseAdapter extends MouseAdapter {
		//============================================
		//
		//		Utilities
		//
		//============================================
		
		@Override
		public void mouseMoved(MouseEvent e) {
			JTable tableSource = (JTable) e.getSource();
			rolloveredRow = tableSource.rowAtPoint(e.getPoint());
			rolloveredColumn = tableSource.columnAtPoint(e.getPoint());
			tableSource.repaint();
		}

		@Override
		public void mouseClicked(MouseEvent e) {
			JTable tableSource =  (JTable)e.getSource();
			System.out.println(rolloveredRow + ", " + rolloveredColumn);
			tableSource.repaint();
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			JTable tableSource =  (JTable)e.getSource();
			rolloveredRow = MOUSE_EXITED;
			rolloveredColumn = MOUSE_EXITED;
			tableSource.repaint();
		}
	}

	/**
	 * @version 1.0 (테이블 셀에 버튼 렌더링)
	 * @since 17-09-19
	 * @see http://www.devx.com/tips/Tip/17285
	 */
	public class AttributiveCellRenderer extends JLabel implements TableCellRenderer {
		// TODO extends 변경하기
		//============================================
		//
		//		Constructor
		//
		//============================================
		
		public AttributiveCellRenderer() {
			setOpaque(true);
		}
		
		
		
		
		//============================================
		//
		//		Utilities
		//
		//============================================

		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			/* 롤오버된 레이블에 표시될 이미지 */
			Character rolloveredCharacter = (Character) table.getValueAt(rolloveredRow, rolloveredColumn);
			/* 롤오버되지 않은 레이블에 표시될 이미지 */
			Character normalCharacter = (Character) table.getValueAt(row, column);
			/* 빈공간에 표시될 이미지 */
			ImageIcon voidSpace = new ImageIcon("Images\\CHARACTER_NULL.png");
			
			if(row == rolloveredRow && column == rolloveredColumn) {	
				//마우스가 올라간 곳이 null일 경우, 롤오버 시 null그림 그리기
				if(table.getValueAt(rolloveredRow, rolloveredColumn).equals(CharacterTable.CHARS_NULL)) {
					this.setIcon(voidSpace);
				}
				else {
					this.setIcon(new ImageIcon(rolloveredCharacter.getImagePath()[2]));
				}
			}
			else {
				//마우스가 올라가지 않은 곳 렌더링하기
				if(table.getValueAt(row, column).equals(CharacterTable.CHARS_NULL)) {
					this.setIcon(voidSpace);
				}
				else {
					/* 여기에 렌더링 시키면됨 */
					this.setIcon(new ImageIcon(normalCharacter.getImagePath()[0]));
				}
			}

			return this;
		}
	}
}
