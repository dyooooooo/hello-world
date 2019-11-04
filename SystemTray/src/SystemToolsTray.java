
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.*;
import java.util.*;


public class SystemToolsTray {
	
	public static Runtime rt;
	public static Map<String, String> commandMap = new HashMap<String,String>();

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		rt = Runtime.getRuntime();
		
		SystemTray tray = SystemTray.getSystemTray();
		PopupMenu trayMenu = new PopupMenu();
		
		
		commandMap.put("计算器", "calc");
		commandMap.put("记事本", "notepad");
		commandMap.put("创建文件", "cmd /c echo please pay attention >c:\\eason\\auto.txt");
		commandMap.put("访问文件", "cmd /c c:\\eason\\auto.txt");
		
		
		for(String one: commandMap.keySet()){
			MenuItem item = new MenuItem(one);
			item.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent e){
					try{
						rt.exec(commandMap.get(one));
					}catch(IOException e1){
						e1.printStackTrace();
					}
				}
			});
			
			trayMenu.add(item);
			
		}
		
		MenuItem exitItem = new MenuItem("exit");
		exitItem.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				System.exit(0);
			}
		});
		trayMenu.add(exitItem);
		
		Image image = Toolkit.getDefaultToolkit().getImage("c:/Eason/IMG_0742.PNG");
		TrayIcon trayIcon = new TrayIcon(image,"Suprise!",trayMenu);
		tray.add(trayIcon);

	}

}
