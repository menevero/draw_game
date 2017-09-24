package com.owlet.game.draw.ui;

import java.awt.AlphaComposite;
import java.awt.Graphics;

import java.awt.Graphics2D;
import java.awt.Image;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;

/**
 * 알파값을 조절할 수 있는 프레임을 꽉 채우는 검정색 레이블입니다. (0.0f ~ 1.0f)<br>
 * 생성자에 패러미터를 주지 않으면 페이드아웃 효과를 냅니다.
 * 
 * @version 1.0
 * @since 17-09-25
 * @see https://stackoverflow.com/questions/17731576/making-an-image-fade-in-and-fade-out
 */
@SuppressWarnings("serial")
public class TransparentBlackLabel extends JLabel implements ActionListener {
	//============================================
	//
	//		Constant
	//
	//============================================
	
	public static final float ACC = 0.005f;

	
	
	
	//============================================
	//
	//		Variables
	//
	//============================================
	
	private Image imagem;
	private Timer timer;
	
	private float alpha = 1.0f;
	private float subtraction = 0.0f;
	
	
	
	
	//============================================
	//
	//		Constructors
	//
	//============================================

	/**
	 * 아무런 패러미터가 주어지지 않으면 페이드아웃 효과를 냅니다.
	 */
	public TransparentBlackLabel() {
		setOpaque(false);
		
		imagem = new ImageIcon("Images\\FRAME_BLACK.png").getImage();
		timer = new Timer(25, this);
		timer.start();
	}

	/**
	 * 원하는 알파값에 맞춘 검정색 레이블입니다.<br>
	 * 아무런 패러미터가 주어지지 않으면 페이드아웃 효과를 냅니다.
	 * 
	 * @param float alpha - 원하는 알파값 (1.0f 가 최대)
	 */
    public TransparentBlackLabel(float alpha) {
        imagem = new ImageIcon("Images\\FRAME_BLACK.png").getImage();
        this.alpha = alpha;
    }

    
    
    
	//============================================
	//
	//		Utilities
	//
	//============================================
    
	public void paintComponent(Graphics g) {
		Graphics2D g2d = (Graphics2D) g;

		g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha));
		g2d.drawImage(imagem, 0, 0, null);
	}

	public void actionPerformed(ActionEvent e) {
		subtraction += ACC;
		System.out.println("조건 : " + subtraction);
		alpha -= subtraction;
		if (alpha < 0) {
			alpha = 0;
			timer.stop();
		}
		repaint();
	}
}
