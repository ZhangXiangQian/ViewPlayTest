package com.github.zxq.viewplay;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;

public class PointsView extends View {
	private Paint paint, cpaint, spaint;
	private int index, hieght, radius;
	private int space, pageIndex;

	public PointsView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	private void init(Context context) {
		index = 0;
		paint = new Paint();
		paint.setColor(0x00000000);
		paint.setAntiAlias(true);
		paint.setStyle(Style.FILL);
		cpaint = new Paint();
		cpaint.setAntiAlias(true);
		cpaint.setColor(0xFFA7A7A7);
		cpaint.setStyle(Style.FILL);
		spaint = new Paint();
		spaint.setAntiAlias(true);
		spaint.setColor(0xFFA90300);
		spaint.setStyle(Style.FILL);

		DisplayMetrics metric = context.getResources().getDisplayMetrics();

		hieght = (int) (30 * metric.density);
		radius = (int) (3 * metric.density);
		space = (int) (6 * metric.density);
		pageIndex = 0;
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);

		canvas.drawColor(0x00000000);
		canvas.drawRect(0, getHeight() - hieght, getWidth(), getHeight(), paint);
		int bedin_x = (index * radius * 2 + (index - 1) * space) / 2;
		bedin_x = getWidth() / 2 - bedin_x;
		for (int i = 0; i < index; i++) {
			if (i == 0) {
				if (pageIndex == i) {
					canvas.drawCircle(bedin_x, getHeight() - hieght / 2,
							radius, spaint);
				} else {
					canvas.drawCircle(bedin_x, getHeight() - hieght / 2,
							radius, cpaint);
				}

			} else {
				if (pageIndex == i) {
					canvas.drawCircle(bedin_x += (space + 2 * radius),
							getHeight() - hieght / 2, radius, spaint);
				} else {
					canvas.drawCircle(bedin_x += (space + 2 * radius),
							getHeight() - hieght / 2, radius, cpaint);
				}

			}
		}

	}

	public void setCount(int count) {
		this.index = count;
	}

	public void doChangePage(int pageIndex) {
		this.pageIndex = pageIndex;
		invalidate();
	}
}
