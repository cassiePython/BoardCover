package com.wangcan.chessboard;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.LinearLayout;

public class MaxtrixActivity extends Activity {
	
	private int[][] a;//�������Ķ�ά����
	private int marker;//���ǵ�����ֵ
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.matrixview);
		init();
	}
	private void init(){
		int size = this.getIntent().getIntExtra("SIZE", 4);
		int x = this.getIntent().getIntExtra("XPOS", 0);
		int y = this.getIntent().getIntExtra("YPOS", 0);
		a = new int[size][size];
		marker = 1;
		ChessBoard(0, 0, x, y, size);
		LinearLayout layout=(LinearLayout) findViewById(R.id.root); 
		int interval = getInternal(size);
//		int a[][]= {
//				{1,0,2,2},
//				{1,1,3,2},
//				{4,3,3,5},
//				{4,4,5,5}
//		};
        final DrawView view=new DrawView(this, a, size, size,interval);  
        view.setMinimumHeight(500);  
        view.setMinimumWidth(300);  
        //֪ͨview����ػ�    
        view.invalidate();  
        layout.addView(view); 
	}
	private int getInternal(int length){
		DisplayMetrics metric = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(metric);
		int width = metric.widthPixels;     // ��Ļ��ȣ����أ�
		return width/(length+2);
	}
	
	private void ChessBoard(int stx,int sty,int bx,int by,int size)
	{
			if(size==1)
				return;
			int s = size/2;
			if(bx<stx+s){
				if(by<sty+s){
					a[stx+s][sty+s-1]=a[stx+s-1][sty+s]=a[stx+s][sty+s]=marker++;
					ChessBoard(stx, sty,bx, by, s);//�������Ͻ�
					
					ChessBoard(stx, sty+s,stx+s-1,sty+s, s);//�������Ͻ�
		
					ChessBoard(stx+s, sty, stx+s, sty+s-1, s);//�������½�
				
					ChessBoard(stx+s, sty+s, stx+s, sty+s, s);//�������½�
				}
				else{
					
					a[stx+s-1][sty+s-1] = a[stx+s][sty+s-1] = a[stx+s][sty+s] = marker++;
					ChessBoard(stx, sty, stx+s-1, sty+s-1, s);//�������Ͻ�
					ChessBoard(stx, sty+s,bx, by, s);//�������Ͻ�
					ChessBoard(stx+s, sty, stx+s, sty+s-1, s);//�������½�
					ChessBoard(stx+s, sty+s, stx+s, sty+s, s);//�������½�
				}
			}else{
				if(by<sty+s){
					a[stx+s-1][sty+s-1]=a[stx+s-1][sty+s]=a[stx+s][sty+s]=marker++;
					ChessBoard(stx, sty,stx+s-1, sty+s-1, s);//�������Ͻ�
					ChessBoard(stx, sty+s,stx+s-1,sty+s, s);//�������Ͻ�
					ChessBoard(stx+s, sty,bx, by, s);//�������½�
					ChessBoard(stx+s, sty+s, stx+s, sty+s, s);//�������½�
				}
				else{
					a[stx+s-1][sty+s-1] = a[stx+s-1][sty+s] = a[stx+s][sty+s-1] = marker++;
					ChessBoard(stx, sty, stx+s-1, sty+s-1, s);//�������Ͻ�
					ChessBoard(stx, sty+s,sty+s-1, sty+s, s);//�������Ͻ�
					ChessBoard(stx+s, sty, stx+s, sty+s-1, s);//�������½�
					ChessBoard(stx+s, sty+s,bx, by, s);//�������½�
				}
			}
	}
}
