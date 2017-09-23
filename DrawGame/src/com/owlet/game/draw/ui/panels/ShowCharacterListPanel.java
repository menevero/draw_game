package com.owlet.game.draw.ui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.owlet.game.draw.controler.PlayerAccount;
import com.owlet.game.draw.ui.CharacterCardShowTable;
import com.owlet.game.draw.ui.MainFrame;

@SuppressWarnings("serial")
public class ShowCharacterListPanel extends JPanel {	
	//============================================
	//
	//		Variables
	//
	//============================================

	PlayerAccount playerAccount;
	MainFrame frame;
	JPanel thisPanel = this;
	JPanel previousPanel;

	/* showCharacters */
	JScrollPane scrollPane;
	JTable characterShowTable;
	JButton backButton;





	//============================================
	//
	//		Constructor
	//
	//============================================

	/**
	 * @param MainFrame - 메인 프레임
	 * @param JPanel previousPanel - 이전 패널
	 */
	public ShowCharacterListPanel(MainFrame frame, JPanel previousPanel) {
		this.frame = frame;
		this.playerAccount = frame.gameMasterController.getAccountManager().getPlayerAccount();
		this.previousPanel = previousPanel;

		initializeComponents();
		showThisPanel();
	}




	//============================================
	//
	//		Utilities
	//
	//============================================

	/**
	 * 이 패널에 속한 컴포넌트들을 초기화합니다.
	 */
	private void initializeComponents() {
		backButton = new JButton("돌아가기");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				previousPanel.setVisible(true);
				frame.deletePanel(thisPanel);
			}
		});
	}


	/**
	 * 이 패널을 보이게 합니다.
	 */
	private void showThisPanel() {
		characterShowTable = new CharacterCardShowTable(playerAccount.getPlayerBlongedCharacterList());

		scrollPane = new JScrollPane(characterShowTable);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setBounds(100, 100, 545, 424);
		add(scrollPane);

		backButton.setBounds(0, 0, 100, 100);
		add(backButton);
	}
}
