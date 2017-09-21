package com.owlet.game.draw.ui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class InvisibleJButton extends JButton {
	ImageIcon[] imageIcon = new ImageIcon[3];
	Dimension dimension = new Dimension();
	
	/* 생성자가 자동으로 이 버튼을 투명하게 만들고 ImageIcon만 표기하게 만듦. */
	public InvisibleJButton(String[] imagePath) {
		imageIcon[0] = new ImageIcon(imagePath[0]);
		imageIcon[1] = new ImageIcon(imagePath[1]);
		imageIcon[2] = new ImageIcon(imagePath[2]);
		dimension.setSize(imageIcon[0].getIconWidth(), imageIcon[0].getIconHeight());
		
		setIcon(imageIcon[0]);
		setPressedIcon(imageIcon[1]);
		setRolloverIcon(imageIcon[2]);
		
		setPreferredSize(dimension);
		setMinimumSize(dimension);
		setMaximumSize(dimension);
		
		setBorderPainted(false);
		setContentAreaFilled(false);
		setFocusPainted(false);
		setOpaque(false);
	}
	
	@Override
	public int getWidth() {
		return this.dimension.width;
		
	}
	
	@Override
	public int getHeight() {
		return this.dimension.height;
		
	}
}
