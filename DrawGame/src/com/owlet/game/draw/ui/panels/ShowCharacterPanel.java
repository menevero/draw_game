package com.owlet.game.draw.ui.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;

import com.owlet.game.draw.controler.PlayerAccount;
import com.owlet.game.draw.data.Character;
import com.owlet.game.draw.ui.ImageIconButton;
import com.owlet.game.draw.ui.MainFrame;

/**
 * 캐릭터를 보여주는 패널입니다.<br>
 * 4번째 패러미터로 받는 값에 따라 새 캐릭터를 보여주는 패널이 될지, 기존 캐릭터를 보여주는 패널이 될지가 결정됩니다.<br>
 * 만약 새로운 캐릭터면 ShowCharacterPanel.SHOW_NEW_CHARACTER를 받습니다.<br>
 * 기존 캐릭터면 캐릭터 데이터를 가진 ArrayList의 해당 캐릭터 index값을 받습니다.
 * 
 * @version 1.0
 * @since 17-09-25
 */
@SuppressWarnings("serial")
public class ShowCharacterPanel extends CustomJPanel {
	//============================================
	//
	//		Constants
	//
	//============================================

	public static final int SHOW_NEW_CHARACTER = -1;




	//============================================
	//
	//		Variables
	//
	//============================================

	PlayerAccount playerAccount;
	MainFrame frame;
	CustomJPanel thisPanel = this;
	CustomJPanel previousPanel;

	int characterIndex;
	Character character;
	ImageIconButton characterCard;
	JLabel characterInfoField;
	JButton backButton;
	JButton deleteButton;




	//============================================
	//
	//		Constructor
	//
	//============================================

	/**
	 * @param MainFrame - 메인 프레임
	 * @param JPanel previousPanel - 이전 패널
	 * @param Character charcter - 캐릭터 객체
	 * @param int mode - 모드 설정
	 */
	public ShowCharacterPanel(MainFrame frame, CustomJPanel previousPanel, Character character, int mode) {
		this.frame = frame;
		this.previousPanel = previousPanel;
		this.character = character;

		if(mode != SHOW_NEW_CHARACTER) {
			this.playerAccount = MainFrame.getGameMasterController().getAccountManager().getPlayerAccount();
			this.characterIndex = mode;
		}

		initializeComponents(mode);
		showThisPanel(mode);
	}




	//============================================
	//
	//		Utilities
	//
	//============================================

	/**
	 * 이 패널에 속한 컴포넌트들을 초기화합니다.
	 */
	private void initializeComponents(int mode) {
		/* 캐릭터 */
		characterCard = new ImageIconButton(character.getImagePath());
		characterCard.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				//아무것도 안함
				//TODO 나중에 소리라도 집어넣기
			}
		});

		/* 캐릭터 정보 표기하는 레이블 */
		characterInfoField = new JLabel(character.getCharacterName() + character.getFlavorText());

		/* 메인 메뉴로 돌아가는 버튼 */
		backButton = new JButton("돌아가기");
		backButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				previousPanel.showThisPanel();
			}
		});

		if(mode != SHOW_NEW_CHARACTER) {
			deleteButton = new JButton("캐릭터 제거");
			deleteButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					playerAccount.getPlayerBlongedCharacterList().remove(characterIndex);
					//TODO 정말로 지울건지 확인하는 창 만들기.
					setVisible(false);
					previousPanel.showThisPanel();
				}
			});
		}
	}


	/**
	 * 이 패널을 보이게 합니다.
	 */
	private void showThisPanel(int mode) {
		setLayout(null);
		setVisible(true);
		removeAll();
		showFadeOut();
		
		add(characterCard);
		characterCard.setBounds(0, 0, characterCard.getWidth(), characterCard.getHeight());
		add(characterInfoField);
		characterInfoField.setBounds(0, 200, 800, 100);
		add(backButton);
		backButton.setBounds(0, 400, 100, 100);

		if(mode != SHOW_NEW_CHARACTER) {
			add(deleteButton);
			deleteButton.setBounds(0, 300, 100, 100);
		}
	}
}
