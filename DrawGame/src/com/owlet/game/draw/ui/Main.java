package com.owlet.game.draw.ui;

import com.owlet.game.draw.controler.GameMasterController;

public class Main {
	// DB구축/운영 과목
	// 프로젝트는 DDL, DML, DCL, 프로시저, 트리거, 함수를 활용해야 함
	// 완성도 위주 평가할 것임

	/* Main, GamePanel, GamePanelGlobalVars, Login 등 */
	
	public static void main(String[] args) {
		//ConsoleInterface runner = new ConsoleInterface(gameMasterController, input);
		
		GameMasterController gameMasterController = new GameMasterController();
		MainFrame runner = new MainFrame(gameMasterController);
		
		runner.run();
	}
}
