package p1;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class options implements ActionListener{
	JFrame frame=new JFrame();
	JButton time=new JButton("TIMER");
	JButton sw=new JButton("STOPWATCH");
	JLabel timeLabel=new JLabel();
	
	

   options(){
	   
    
	time.setBounds(100,200,100,50);
	time.setFont(new Font("Verdana",Font.PLAIN,20));
	time.setFocusable(false);
	time.addActionListener(this);
	
	sw.setBounds(210,200,180,50);
	sw.setFont(new Font("Verdana",Font.PLAIN,20));
	sw.setFocusable(false);
	sw.addActionListener(this);
	
	
	frame.add(time);
	frame.add(sw);
//	frame.add(timeLabel);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	frame.setSize(420, 420);
	frame.setLayout(null);
	frame.setVisible(true);
	
}
@Override
public void actionPerformed(ActionEvent e) {
// TODO Auto-generated method stub
	if(e.getSource()==time) {
		
		CountTimer counttime=new CountTimer();
	}
	else {
		if(e.getSource()==sw) {
			Stopwatch stopwatch=new Stopwatch();
			
		}
	}

}

}
