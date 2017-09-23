package com.owlet.game.draw.ui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.owlet.game.draw.data.Character;
import com.owlet.game.draw.ui.ImageIconButton;
import com.owlet.game.draw.ui.MainFrame;

/**
 * 캐릭터나 아이템을 뽑는 패널입니다.
 * 
 * @version 1.0
 * @since 17-09-23
 */
@SuppressWarnings("serial")
public class ShowNewCharacterPanel extends JPanel {
	//============================================
	//
	//		Variables
	//
	//============================================

	MainFrame frame;
	JPanel thisPanel = this;
	JPanel previousPanel;

	Character newCharacter;
	ImageIconButton characterCard;
	JLabel characterInfoField;
	JButton okButton;




	//============================================
	//
	//		Constructor
	//
	//============================================

	/**
	 * @param MainFrame - 메인 프레임
	 * @param JPanel previousPanel - 이전 패널
	 * @param Character newCharcter - 새로운 캐릭터 객체
	 */
	public ShowNewCharacterPanel(MainFrame frame, JPanel previousPanel, Character newCharacter) {
		this.frame = frame;
		this.previousPanel = previousPanel;
		this.newCharacter = newCharacter;

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
		/* 캐릭터 */		
		characterCard = new ImageIconButton(newCharacter.getImagePath());
		characterCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//아무것도 안함
				//TODO 나중에 소리라도 집어넣기
			}
		});
		
		/* 캐릭터 정보 표기하는 레이블 */
		characterInfoField = new JLabel(newCharacter.getCharacterName() + newCharacter.getFlavorText());
		
		/* 메인 메뉴로 돌아가는 버튼 */
		okButton = new JButton("확인");
		okButton.addActionListener(new ActionListener() {
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
		setLayout(null);
		add(characterCard);
		characterCard.setBounds(0, 0, characterCard.getWidth(), characterCard.getHeight());
		add(characterInfoField);
		characterInfoField.setBounds(0, 200, 800, 100);
		add(okButton);
		okButton.setBounds(0, 400, 100, 100);
	}
}
