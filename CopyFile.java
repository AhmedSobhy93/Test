import java.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import java.io.*;
import java.io.IOException;

class CopyFile extends JFrame{
	
	private JPanel panel,Spanel,Cpanel,Rpanel,Lpanel,panellb,panelrb,panelt1,panelt2;
	private JButton bro1,bro2,copy;
	private JLabel label1,label2,label3;
	private JTextField text1,text2;
	private BorderLayout layout;
	private GridLayout gl,g2;
	 
	public CopyFile(String title){
		super(title);
		
		panel=new JPanel();
		Spanel=new JPanel();
		Cpanel=new JPanel();
		Rpanel=new JPanel();
		Lpanel=new JPanel();
		panellb=new JPanel();
		panelrb=new JPanel();
		panelt1=new JPanel();
		panelt2=new JPanel();
		
		label1=new JLabel("Source File");
		label2=new JLabel("Destination File");
		label3=new JLabel("");
		
		bro1=new JButton("Browse");
		bro2=new JButton("Browse");
		
		copy=new JButton("Copy");
		
		layout=new BorderLayout();
		gl=new GridLayout(0,2,5,5);
		g2=new GridLayout(4,0,5,5);
		
		text1=new JTextField(15);
		text2=new JTextField(15);
		
		layout.setHgap(10);
		layout.setVgap(10);
		
		add(panel);
		panel.setLayout(layout);
		
		panel.add(Spanel,layout.SOUTH);
		Spanel.add(copy);
		
		panel.add(Cpanel,layout.CENTER);
		Cpanel.setLayout(gl);
		Cpanel.add(Lpanel);
		Cpanel.add(Rpanel);	
		
		Rpanel.setLayout(g2);
		Lpanel.setLayout(g2);
		
		
		Lpanel.add(label1);
		Lpanel.add(panellb);
		panellb.add(bro1);
		Lpanel.add(panelt1);
		Lpanel.add(label3);
		
		Rpanel.add(label2);
		Rpanel.add(panelrb);
		panelrb.add(bro2);
		Rpanel.add(panelt2);
		
		
		panelt1.add(text1);
		panelt2.add(text2);
		
		bro1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){	
				
				JFileChooser fc=new JFileChooser();
				if(fc.showOpenDialog(CopyFile.this)==JFileChooser.APPROVE_OPTION)
				{
					String path=fc.getSelectedFile().getPath();
					File f1=new File(path);
					if(f1.exists()){
						System.out.println("not empty");
						text1.setText(path);
						
					}else{
						label3.setText("Invalid Source path");
					}
				}
						
				}
			});  
		
		bro2.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){	
				JFileChooser fc=new JFileChooser();
				if(fc.showOpenDialog(CopyFile.this)==JFileChooser.APPROVE_OPTION)
				{
					String path=fc.getSelectedFile().getPath();
					File f2=new File(path);
					if(f2.exists()){
						System.out.println("not empty");
						text2.setText(path);
					}else{
						text2.setText(path);
					}
				}			
				}
			});
			
		
		bro1.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){	
				
				JFileChooser fc=new JFileChooser();
				if(fc.showOpenDialog(CopyFile.this)==JFileChooser.APPROVE_OPTION)
				{
					String path=fc.getSelectedFile().getPath();
					File f1=new File(path);
					if(f1.exists()){
						System.out.println("not empty");
						text1.setText(path);
						
					}else{
						label3.setText("Invalid Source path");
					}
				}
						
				}
			});  	
		
	
	public void copyFun(File f1,File f2){
			try{
					byte[] b;
					FileInputStream fis=new FileInputStream(f1);
					FileOutputStream fos = new FileOutputStream(f2);
					
					int size=fis.available();
					b=new byte[size];
									
					while(fis.read(b)>0){						
						fos.write(b);
					}				
					
					fos.close();
					fis.close();
					label3.setText("Copy Done");
			}catch(IOException ex){
					System.out.println("error");
			}
	} 
	
}