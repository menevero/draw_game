package com.owlet.game.draw.ui;

import java.util.InputMismatchException;
import java.util.Scanner;
import com.owlet.game.draw.data.Character;
import com.owlet.game.draw.data.SharedData;

public class ConsoleInterface {
	//============================================
	//
	//		Variables
	//
	//============================================

	private Scanner scanner;
	private Integer input;
	private Character tempCharacter;
	private SharedData sharedData;
	
	private String id;
	private String password;




	//============================================
	//
	//		Constructor
	//
	//============================================

	public ConsoleInterface(SharedData sharedData, Integer input, Scanner scanner) {
		this.sharedData = sharedData;
		this.input = input;
		this.scanner = scanner;
	}




	//============================================
	//
	//		Utilities
	//
	//============================================

	public void run() {
		while(true) {
			if(showMainMenu() == false) {
				continue;
			}

			switch(input) {
			/* 로그인 케이스 */
			case 1:
				scanner.nextLine();
				System.out.println("아이디를 입력해 주십시오.");
				id = scanner.nextLine();
				if(sharedData.getLogin().isIDCorrect(id) == false) {
					id = null;
					System.out.println("일치하는 아이디가 없습니다.");
					continue;
				}
				else {
					System.out.println("패스워드를 입력해 주십시오.");
					password = scanner.nextLine();
					if(sharedData.getLogin().isPasswordCorrect(password) == false) {
						password = null;
						System.out.println("패스워드가 틀립니다.");
						continue;
					}
					else {
						if(sharedData.getLogin().startLogin() == false) {
							System.out.println("로그인에 실패하였습니다. 0");	
						}
						else {
							System.out.println("로그인 성공");
						}
					}
				}

				while(true) {
					if(showGameMenu() == false) {
						continue;
					}

					scanner.nextLine();

					switch(input) {
					case 1:
						/* 캐릭터  뽑기 케이스 */
						// TODO 돈뺏기
						showDrawingCharacter();
						continue;

					case 2:
						/* 캐릭터 삭제 케이스 */
						if(showRemovingCharacter() == false) {
							continue;
						}

					case 3:
						/* 캐릭터 출력 케이스 */
						showBelongedCharacters();
						continue;

					case 4:
						/* 로그아웃 케이스 */
						break;
					}
					break;
				}
				//메인메뉴로 돌아감
				continue;

			case 2:
				/* 로그인 케이스 */
				System.out.print("2번 고름");
				//TODO 회원가입과정 따로 제작
				continue;

			case 3:
				/* 게임 종료 케이스 */
				System.out.println("프로그램을 종료하시겠습니까?\n1 : 종료\n다른 값 : 취소");
				try {
					input = scanner.nextInt();
				}
				catch(InputMismatchException e) {
					System.out.println("메인으로 돌아갑니다.");
					scanner.nextLine();
					continue;
				}

				if(input.intValue() == 1) {
					System.out.println("프로그램을 종료합니다.");
					System.exit(0);
				}
				else {
					System.out.println("메인으로 돌아갑니다.");
				}
				break;
			}
			break;
		}

		System.out.println("프로그램 끝");
	}




	//============================================
	//
	//		Local Methods
	//
	//============================================

	/**
	 * 메인 메뉴를 보여주고 유저로부터 응답을 입력받는 메소드
	 */
	private boolean showMainMenu() {		
		System.out.print("1. 로그인\n2. 회원가입\n3. 종료\n");
		System.out.print("입력 : ");
		try {
			this.input = this.scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			this.scanner.nextLine();
			return false;
		}

		if(this.input.intValue() <= 0 || this.input.intValue() > 3) {
			System.out.println("잘못된 입력입니다. : " + this.input);
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * 로그인 이후 게임 메뉴를 보여주고 유저로부터 응답을 입력받는 메소드
	 */
	private boolean showGameMenu() {
		System.out.print("1. 뽑기\n2. 캐릭터 삭제\n3. 콜렉션 보기\n4. 로그아웃\n");
		System.out.print("입력 : ");

		try {
			input = scanner.nextInt();
		}
		catch(InputMismatchException e) {
			System.out.println("잘못된 입력입니다.");
			scanner.nextLine();
			return false;
		}
		if(input.intValue() <= 0 || input.intValue() > 4) {
			System.out.println("잘못된 입력입니다. : " + input);
			return false;
		}
		else {
			return true;
		}
	}

	/**
	 * 캐릭터 뽑기를 출력하는 메소드(리턴값 없음)
	 */
	private void showDrawingCharacter() {
		Character tempCharacter;
		tempCharacter = sharedData.getCharacterDrawer().startDraw();

		if(tempCharacter == null) {
			System.out.println("이미 캐릭터 보관함이 꽉 찼습니다.");
		}
		else {
			System.out.println("다음 캐릭터가 정상적으로 추가되었습니다. : " + tempCharacter.getCharacterName());
		}
	}

	/**
	 * 캐릭터 삭제 메뉴를 선택했을 때 입력을 받는 메소드
	 */
	private boolean showRemovingCharacter() {
		while(true) {
			if(sharedData.getPlayer().getNumberOfBelongedCharacters() == 0) {
				System.out.println("소유하고 있는 캐릭터가 없습니다.");
				return false;
			}

			System.out.println("캐릭터 번호 : 해당 캐릭터 삭제\n아무 문자 입력 : 돌아가기");
			System.out.println("입력 : ");
			try {
				input = scanner.nextInt();
			}
			catch(InputMismatchException e) {
				System.out.println("돌아갑니다.");
				scanner.nextLine();
				return false;
			}

			if(input.intValue() <= 0 || input.intValue() > sharedData.getPlayer().getNumberOfBelongedCharacters()) {
				System.out.println("잘못된 인덱스 입력입니다. : " + input);
				scanner.nextLine();
				continue;
			}
			else {
				if(sharedData.getPlayer().removeCharacter(input - 1)) {
					System.out.println("정상적으로 삭제되었습니다.");
					continue;
				}
				else {
					System.out.println("삭제 실패");
					continue;
				}
			}
		}
	}

	/**
	 * 캐릭터 목록을 출력하는 메소드(리턴값 없음)
	 */
	private void showBelongedCharacters() {
		if(sharedData.getPlayer().getNumberOfBelongedCharacters() == 0) {
			System.out.println("보유하고 있는 캐릭터가 없습니다.");
		}
		else {
			for(int i = 0; i < sharedData.getPlayer().getNumberOfBelongedCharacters(); i++) {
				tempCharacter = sharedData.getPlayer().getSpecificCharacter(i);
				System.out.println("\n" + "[" + (i + 1) + "]" + "캐릭터 이름 : " + tempCharacter.getCharacterName());
				System.out.println(tempCharacter.getFlavorText() + "\n");
			}
		}
	}
}
