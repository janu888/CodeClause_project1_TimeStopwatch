package p1;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Stopwatch implements ActionListener {
	JFrame frame=new JFrame();
	JButton startButton1=new JButton("START");
	JButton resetButton=new JButton("RESET");
	JButton back = new JButton("BACK");
	JLabel timeLabel=new JLabel();
	int elapsedTime=0;
	int seconds=0;
	int minutes=0;
	int hours=0;
	boolean started=false;
	String seconds_string=String.format("%02d",seconds);
	String minutes_string=String.format("%02d",minutes);
	String hours_string=String.format("%02d",hours);
	
	Timer timer=new Timer(1000, new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			elapsedTime+=1000;
			hours=(elapsedTime/3600000);
			minutes=(elapsedTime/60000)%60;
			seconds=(elapsedTime/1000)%60;
			seconds_string=String.format("%02d",seconds);
			minutes_string=String.format("%02d",minutes);
			hours_string=String.format("%02d",hours);
			timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
	
			
			
			
			
		}
	});
	
	
	Stopwatch(){
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		timeLabel.setBounds(100, 100, 200, 150);
		timeLabel.setFont(new Font("Verdana",Font.PLAIN,35));
		timeLabel.setBorder(BorderFactory.createBevelBorder(1));
		timeLabel.setOpaque(true);
		timeLabel.setHorizontalAlignment(JTextField.CENTER);
		
		startButton1.setBounds(100,200,100,50);
		startButton1.setFont(new Font("Verdana",Font.PLAIN,20));
		startButton1.setFocusable(false);
		startButton1.addActionListener(this);
		
		resetButton.setBounds(200,200,100,50);
		resetButton.setFont(new Font("Verdana",Font.PLAIN,20));
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		
		back.setBounds(140,270,100,50);
		back.setFont(new Font("Verdana",Font.PLAIN,20));
		back.setFocusable(false);
		back.addActionListener(this);
		
		
		
		frame.add(startButton1);
		frame.add(resetButton);
		frame.add(back);
		frame.add(timeLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==startButton1) {
			start();
			if(started==false) {
				started=true;
				startButton1.setText("STOP");
				start();
			}
			else {
				started=false;
				startButton1.setText("START");
				stop();
				
			}
			
			
			
		}
		if(e.getSource()==resetButton) {
			started=false;
			startButton1.setText("START");
			reset();
		}
		if(e.getSource()==back) {
			started=false;
			startButton1.setText("BACK");
			options opt=new options();
		}
		
		
	}
	void start() {
		timer.start();
		
	}
	void stop()
	{
		timer.stop();
		
	}
	void reset() {
		timer.stop();
		elapsedTime=0;
		seconds=0;
		minutes=0;
		hours=0;
		seconds_string=String.format("%02d",seconds);
		minutes_string=String.format("%02d",minutes);
		hours_string=String.format("%02d",hours);
		timeLabel.setText(hours_string+":"+minutes_string+":"+seconds_string);
		
	}
	
	
}