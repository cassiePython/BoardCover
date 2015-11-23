package com.wangcan.chessboard;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class DrawView extends View {
	
	private int[][] a;
	private int row;
	private int col;
	private int interval;
	
	static int[] colorSemble ={
		Color.BLACK,Color.BLUE,Color.CYAN,
		Color.GRAY,Color.YELLOW,Color.GREEN,
		Color.DKGRAY,Color.LTGRAY,Color.RED,
		Color.MAGENTA,Color.rgb(222,27,209),Color.rgb(140, 0, 255),
		Color.rgb(99, 237, 226),Color.rgb(176, 138, 23),
		Color.rgb(4, 105, 97),Color.rgb(116, 37, 128)
	};

	public DrawView(Context context,int[][] a,int row,int col,int interval) {
		super(context);
		this.a = a;
		this.row = row;
		this.col = col;
		this.interval = interval;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		/*
		 * 方法 说明 drawRect 绘制矩形 drawCircle 绘制圆形 drawOval 绘制椭圆 drawPath 绘制任意多边形
		 * drawLine 绘制直线 drawPoin 绘制点
		 */
		// 创建画笔
		Paint p = new Paint();
		p.setColor(Color.BLACK);// 设置黑色
		//p.setStyle(Paint.Style.FILL);//设置填满
		//p.setStyle(Paint.Style.STROKE);//设置空心
		p.setStyle(Paint.Style.FILL);
		int x=0,y=0;
		for(int i=0;i<col;i++){
			for(int j=0;j<row;j++){
				x = (j+1)*interval;
				y = (i+1)*interval;
				p.setColor(colorSemble[a[i][j]%16]);
				
				canvas.drawRect(x, y,x+interval, y+interval, p);// 正方形
			}		
		}	
	}
}