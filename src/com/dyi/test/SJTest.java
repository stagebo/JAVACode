package com.dyi.test;

public class SJTest {
	public static void main(String[] args) throws Exception {
		IAlert iAlert;
		int need = 0;
		switch (need) {
		case 0:
			iAlert = new AlertA();
			break;
		case 1:
			iAlert = new AlertB();
			break;
		case 2:
			iAlert = new AlertC();
			break;
		default:
			iAlert = null;
		}
		if(iAlert==null){
			throw new Exception("需求错误");
		}
		/*处理业务和写日志*/
		iAlert.deal();
		iAlert.writeLog();
	}
}

interface IAlert {
	/* 处理业务 */
	public void deal();

	/* 写日志 */
	public void writeLog();
}

class AlertA implements IAlert {

	public void deal() {
		// TODO Auto-generated method stub

	}

	public void writeLog() {
		// TODO Auto-generated method stub

	}

}

class AlertB implements IAlert {

	public void deal() {
		// TODO Auto-generated method stub

	}

	public void writeLog() {
		// TODO Auto-generated method stub

	}

}

class AlertC implements IAlert {

	public void deal() {
		// TODO Auto-generated method stub

	}

	public void writeLog() {
		// TODO Auto-generated method stub

	}

}