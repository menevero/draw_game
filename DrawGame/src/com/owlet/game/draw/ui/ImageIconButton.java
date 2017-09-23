package com.owlet.game.draw.ui;

import java.awt.Dimension;

import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
/**
 * ImageIcon 객체로 대신 표시될 JButton입니다.
 * 
 * @version 1.0
 * @since 17-09-22
 */
public class ImageIconButton extends JButton {
	ImageIcon[] imageIconPath = new ImageIcon[3];
	Dimension dimension = new Dimension();
	
	/* 생성자가 자동으로 이 버튼을 투명하게 만들고 ImageIcon만 표기하게 만듦. */
	public ImageIconButton(String[] imagePath) {
		imageIconPath[0] = new ImageIcon(imagePath[0]);
		imageIconPath[1] = new ImageIcon(imagePath[1]);
		imageIconPath[2] = new ImageIcon(imagePath[2]);
		dimension.setSize(imageIconPath[0].getIconWidth(), imageIconPath[0].getIconHeight());
		
		setIcon(imageIconPath[0]);
		setPressedIcon(imageIconPath[1]);
		setRolloverIcon(imageIconPath[2]);
		
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
