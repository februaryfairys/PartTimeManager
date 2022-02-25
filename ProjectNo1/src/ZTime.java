import java.util.Calendar;

public class ZTime extends Thread {

	private int ampm;
	private String strampm = null;
	private int year;
	private int month;
	private int day;
	private int dow;
	private int hour;
	private int minute;
	private int second;

	public void start() {

		for (;;) {
			Calendar cnow = Calendar.getInstance();
			if (ampm == Calendar.AM) {
				strampm = "오전 ";
			} else {
				strampm = "오후 ";
			}
			ampm = cnow.get(Calendar.AM_PM);
			year = cnow.get(Calendar.YEAR);
			month = cnow.get(Calendar.MONTH);
			day = cnow.get(Calendar.DATE);
			dow = cnow.get(Calendar.DAY_OF_WEEK);
			hour = cnow.get(Calendar.HOUR);
			minute = cnow.get(Calendar.MINUTE);
			setSecond(cnow.get(Calendar.SECOND));
			System.out.println(getSecond());
			try {
				Thread.sleep(1000);
			
			} catch (Exception e) {
			}
		}
	}

	public int getAmpm() {
		return ampm;
	}

	public void setAmpm(int ampm) {
		this.ampm = ampm;
	}

	public String getStrampm() {
		return strampm;
	}

	public void setStrampm(String strampm) {
		this.strampm = strampm;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getDow() {
		return dow;
	}

	public void setDow(int dow) {
		this.dow = dow;
	}

	public int getHour() {
		return hour;
	}

	public void setHour(int hour) {
		this.hour = hour;
	}

	public int getMinute() {
		return minute;
	}

	public void setMinute(int minute) {
		this.minute = minute;
	}

	public int getSecond() {
		return second;
	}

	public void setSecond(int second) {
		this.second = second;
	}

}
