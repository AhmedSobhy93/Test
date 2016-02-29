	
		

class CopyFile extends JFrame{
	
	
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
		
		
