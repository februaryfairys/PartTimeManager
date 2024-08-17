package view;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HelpFrame extends AFrame {
	private Frame f;
	private Label l1, l2;
	private Button b1, b2, b3, b4, b5, b6, b7, b8;
	private TextArea ta;
	private String exp;

	public void start() {
		f = new Frame("Help");
		f.setSize(750, 550);
		f.setLayout(null);
		f.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent E) {
				f.dispose();
			}
		});
		f.setLocation(screenSize.width / 2 - 300, screenSize.height / 2 - 200);

		l1 = new Label("<목차>", Label.CENTER);
		l2 = new Label("<프로그램 설명>", Label.CENTER);
		l1.setSize(150, 20);
		l2.setSize(450, 20);
		l1.setLocation(30, 60);
		l2.setLocation(220, 60);

		ta = new TextArea();
		ta.setSize(500, 390);
		ta.setLocation(220, 100);
		ta.setEditable(false);

		b1 = new Button("메인화면");
		b2 = new Button("직원등록");
		b3 = new Button("출근 및 퇴근");
		b4 = new Button("직원조회");
		b5 = new Button("직원삭제");
		b6 = new Button("비밀번호");
		b7 = new Button("급여설정");
		b8 = new Button("프로그램초기화");

		b1.setSize(150, 40);
		b2.setSize(150, 40);
		b3.setSize(150, 40);
		b4.setSize(150, 40);
		b5.setSize(150, 40);
		b6.setSize(150, 40);
		b7.setSize(150, 40);
		b8.setSize(150, 40);
		b1.setLocation(30, 100);
		b2.setLocation(30, 150);
		b3.setLocation(30, 200);
		b4.setLocation(30, 250);
		b5.setLocation(30, 300);
		b6.setLocation(30, 350);
		b7.setLocation(30, 400);
		b8.setLocation(30, 450);
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n 메인 화면에는 현재 근무중인 직원 목록과 전체 직원 목록이 표시됩니다." + "\n목록 하단의 새로고침 버튼을 누르면 목록이 최신 상태로 업데이트 됩니다."
						+ "\n\n\n 우측에 각종 기능을 모아둔 버튼들이 있습니다." + "\n직원메뉴에서 직원의 출근과 퇴근을 체크할 수 있습니다."
						+ "\n관리자메뉴에서 새로운 직원을 등록하거나 정보를 조회,수정, 삭제할 수 있습니다. "
						+ "\n설정메뉴에서 프로그램 비밀번호를 변경하거나 프로그램을 초기화 할 수 있습니다."
						+ "\n\n\n 상단의 메뉴목록에는 우측 버튼과 동일한 구성의 메뉴가 배치되어있습니다.";

				ta.setText(exp);
			}
		});
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n 직원 명부에 새로운 직원을 추가합니다." + "\n\n 이름(또는 닉네임), 연락처와 역할을 입력하고 직원번호를 발급받습니다."
						+ "\n이름은 영문으로도 설정 가능합니다." + "\n연락처는 10~11자리 이내에서 입력합니다."
						+ "\n\n\n 이름(또는 닉네임), 직원번호, 역할은 중복될 수 있으나," + "\n서로 다른 직원이 같은 연락처를 기입하는 것은 불가능 합니다.";
				ta.setText(exp);
			}
		});
		b3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n 출근시간과 퇴근시간을 기록합니다." + "\n\n 등록한 이름(또는 닉네임)과 직원번호를 입력하여 출근하고,"
						+ "\n퇴근 할 때에도 같은 방법으로 퇴근합니다." + "\n\n\n 출퇴근 시 자동으로 출근시간과 퇴근시간을 기록하며,"
						+ "\n근무 시간을 시, 분 단위로 계산하여 저장합니다.";
				ta.setText(exp);
			}
		});
		b4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n 직원들의 개인정보를 열람하거나 수정할 수 있습니다." + "\n\n 프로그램의 비밀번호를 입력하여 기능을 사용할 수 있습니다."
						+ "\n열람할 수 있는 정보는 이름, 직원번호, 연락처, 기간별 근무시간입니다.";
				ta.setText(exp);
			}
		});
		b5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n 선택한 직원의 모든 정보를 영구적으로 삭제합니다." + "\n\n 이 경우 이미 실행한 작업은 되돌릴 수 없습니다.";
				ta.setText(exp);
			}
		});
		b6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n 초기 비밀번호는 0000이며 관리자가 임의로 변경할 수 있습니다." + "\n\n 프로그램을 종료할 때, 직원 정보를 열람할 때, 프로그램을 초기화할 때"
						+ "\n프로그램 자체의 비밀번호를 요구합니다.";
				ta.setText(exp);
			}
		});
		b7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n 직원 급여를 설정합니다." + "\n\n 공식 최저임금이나 자체적으로 정한 기본시급을 설정할 수 있습니다." + "\n\n 역할에 따른 인센티브를 설정할 수 있습니다."
						+ "\n적용한 숫자의 퍼센테이지 만큼 \"더하여\" 지급합니다." + "\n인센티브를 설정하고 싶지 않다면 0을 입력하여 적용합니다.";
				ta.setText(exp);
			}
		});
		b8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				exp = "\n 프로그램을 초기화합니다." + "\n\n 등록된 직원들의 개인정보와 근무기록이 모두 삭제됩니다." + "\n비밀번호가 초기설정으로 되돌아갑니다."
						+ "\n단, 설정된 급여나 인센티브는 초기화되지 않습니다.";
				ta.setText(exp);
			}
		});

		f.add(l1);
		f.add(l2);
		f.add(ta);
		f.add(b1);
		f.add(b2);
		f.add(b3);
		f.add(b4);
		f.add(b5);
		f.add(b6);
		f.add(b7);
		f.add(b8);
		f.setVisible(true);
	}
}
