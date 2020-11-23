
import javax.microedition.lcdui.*;
import javax.microedition.midlet.*;
import java.io.*;

public class AI extends MIDlet
{
	Display display;
	MainCanvas mc;
	public AI(){
		display=Display.getDisplay(this);
		mc=new MainCanvas();
		display.setCurrent(mc);
	}
	public void startApp(){
	}
	public void destroyApp(boolean unc){
	}
	public void pauseApp(){
	}
}
class MainCanvas extends Canvas
{

	/*
	变量的声明
	语法：数据类型 变量名称（标识符）;
	*/
	int x,y;
	/*int leftFlag,rightFlag,upFlag,downFlag;*/
	int flag;
	/*一维数组
	Image heroLeftImg[]=new Image[3];
    Image heroRightImg[]=new Image[3];
    Image heroUpImg[]=new Image[3];
    Image heroDownImg[]=new Image[3];*/
	Image heroImg[][]=new Image[4][3];/*二维数组，4个方向，0表示左，1为右，2为上，3为下*/
	Image currentImg;
	/*Image downImg,downImg1,downImg2,leftImg,leftImg1,leftImg2,rightImg,rightImg1,rightImg2,upImg,upImg1,upImg2,currentImg;*/
	public MainCanvas(){
		try
		{
			/*
			给变量赋值
			语法：变量名称=value;
			*/
			/*(1)一般
			downImg=Image.createImage("/sayo10.png");
			downImg1=Image.createImage("/sayo00.png");
			downImg2=Image.createImage("/sayo20.png");
			leftImg=Image.createImage("/sayo12.png");
			leftImg1=Image.createImage("/sayo02.png");
			leftImg2=Image.createImage("/sayo22.png");
			rightImg=Image.createImage("/sayo16.png");
			rightImg1=Image.createImage("/sayo06.png");
			rightImg2=Image.createImage("/sayo26.png");
			upImg=Image.createImage("/sayo14.png");
			upImg1=Image.createImage("/sayo04.png");
			upImg2=Image.createImage("/sayo24.png");
			*/
			/*(2)一维数组
			for(int i=0;i<3;i++){
			heroleftImg[i]=Img.createImge("/sayo"+i+"2.png");
			herorightImg[i]=Img.createImge("/sayo"+i+"6.png");
            heroupImg[i]=Img.createImge("/sayo"+i+"4.png");
            herodownImg[i]=Img.createImge("/sayo"+i+"0.png");
			}*/
            for(int i=0;i<heroImg.length;i++){
				for(int j=0;j<heroImg[i].length;j++){
					heroImg[i][j]=Image.createImage("/sayo"+i+j+".png");
				}
			}
			/*currentImg=downImg;*/
			currentImg=heroImg[3][1];
			x=120;
			y=100;
			
			/*leftFlag=1;
			rightFlag=1;
			upFlag=1;
			downFlag=1;*/
			flag=1;
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	public void paint(Graphics g){
		g.setColor(0,0,0);
		g.fillRect(0,0,getWidth(),getHeight());
		g.drawImage(currentImg,x,y,0);//120：X坐标、100：Y坐标
	}
	/*方法*/
	public void changePic(int direction){
		if(flag==1){
			currentImg=heroImg[direction][0];
			flag++;
		}
		else if(flag==2){
			currentImg=heroImg[direction][2];
			flag=1;
			}
		repaint();}
	public void keyPressed(int keyCode){
		int action=getGameAction(keyCode);
		/*
		action的值：UP、DOWN、LEFT、RIGHT
		*/
		if(action==LEFT){
			/*
			实现转向代码
			*/
			/*
			给变量重新赋值即可
			*/
			/*currentImg=leftImg;*/
			/*if(leftFlag==1){
			currentImg=heroImg[0][0];
			leftFlag++;
			}
			else if(leftFlag==2){
			currentImg=heroImg[0][2];
			leftFlag=1;}*/
			changePic(0);
			System.out.println("向左转");
			x=x-10;
			/*一般，
			n=n+1;
			if(n%2==0){
			currentImg=leftImg1;}
			else{currentImg=leftImg2;}*/
			/*一维数组，同理依次推写
            if(leftFlag==1){
			currentImg=heroImg[0];
			leftFlag++;
			}
			else if(leftFlag==2){
			currentImg=heroImg[2];
			leftFlag=1;}*/
			repaint();}
		if(action==RIGHT){
			/*currentImg=rightImg;*/
            /*if(rightFlag==1){
			currentImg=heroImg[1][0];
			rightFlag++;
			}
			else if(rightFlag==2){
			currentImg=heroImg[1][2];
			rightFlag=1;}*/
            changePic(1);
			System.out.println("向右转");
			x=x+10;
			/*n=n+1;
			if(n%2==0){
			currentImg=rightImg1;
			}
			else{currentImg=rightImg2;}*/
			repaint();}
		if(action==UP){
			/*currentImg=upImg;*/
            /*if(upFlag==1){
			currentImg=heroImg[2][0];
			upFlag++;
			}
			else if(upFlag==2){
			currentImg=heroImg[2][2];
			upFlag=1;}*/
            changePic(2);
			System.out.println("向上转");
			y=y-10;
			/*n=n+1;
			if(n%2==0){
			currentImg=upImg1;
			}
			else{currentImg=upImg2;}*/
			repaint();
			}
		if(action==DOWN){
			/*currentImg=downImg;*/
            /*if(downFlag==1){
			currentImg=heroImg[3][0];
			downFlag++;
			}
			else if(downFlag==2){
			currentImg=heroImg[3][2];
			downFlag=1;}*/
            changePic(3);
			System.out.println("向下转");
			y=y+10;
			/*n=n+1;
			if(n%2==0){
			currentImg=downImg1;
			}
			else{currentImg=downImg2;}*/
			repaint();
		}
	}
}
