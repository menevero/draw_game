package com.owlet.game.draw.ui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import com.owlet.game.draw.controler.PlayerAccount;
import com.owlet.game.draw.ui.CharacterCardShowTable;
import com.owlet.game.draw.ui.MainFrame;

/**
 * 현재 로그인된 계정이 보유하고 있는 캐릭터를 보여주는 패널 클래스입니다.
 * 이 패널에는 스크롤패널이 있고, 그 내부에 캐릭터 카드를 보여주는 테이블이 들어있습니다.
 * 
 * @version 1.0
 * @since 17-09-25
 */
@SuppressWarnings("serial")
public class ShowCharacterListPanel extends CustomJPanel {	
	//============================================
	//
	//		Variables
	//
	//============================================

	PlayerAccount playerAccount;
	MainFrame frame;
	CustomJPanel thisPanel = this;
	CustomJPanel previousPanel;

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
	public ShowCharacterListPanel(MainFrame frame, CustomJPanel previousPanel) {
		this.frame = frame;
		this.playerAccount = MainFrame.getGameMasterController().getAccountManager().getPlayerAccount();
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
				previousPanel.showThisPanel();
			}
		});
	}


	/**
	 * 이 패널을 보이게 합니다.
	 */
	public void showThisPanel() {
		setLayout(null);
		setVisible(true);
		removeAll();
		showFadeOut();
		
		characterShowTable = new CharacterCardShowTable(playerAccount.getPlayerBlongedCharacterList(), thisPanel, frame);

		scrollPane = new JScrollPane(characterShowTable);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

		scrollPane.setBounds(100, 100, 545, 424);
		add(scrollPane);

		backButton.setBounds(0, 0, 100, 100);
		add(backButton);
	}
}
