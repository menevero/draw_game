package com.owlet.game.draw.ui.panels;

import javax.swing.JPanel;

import com.owlet.game.draw.ui.TransparentBlackLabel;

/**
 * 패널들이 상속받아 사용할 패널입니다. 페이드아웃 기능을 가지고 있습니다.
 * 
 * @version 1.0
 * @since 17-09-25
 */
@SuppressWarnings("serial")
public class CustomJPanel extends JPanel {
	
	public void showFadeOut() {
		TransparentBlackLabel tempPanel = new TransparentBlackLabel();
		add(tempPanel);
		tempPanel.setBounds(0, 0, 1000, 1000);
		tempPanel = null;
	}
	
	public void showThisPanel() {
		setLayout(null);
		setVisible(true);
		removeAll();
		showFadeOut();
	}
}
