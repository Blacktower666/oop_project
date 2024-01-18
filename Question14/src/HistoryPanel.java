import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JPanel;

public class HistoryPanel extends JPanel{
	private ElectricityCompany m;
	public HistoryPanel(ElectricityCompany m) {
		this.m=m;
	}
	private int historyMax(ArrayList<Integer> history){
		int max=history.get(0);
		for(int i:history) {
			if(i>max)
				max=i;
		}
		return max;
	}
	private int historyMin(ArrayList<Integer> history) {
		int min=history.get(0);
		for(int i:history) {
			if(i<min)
				min=i;
		}
		return min;
	}
	private int historyRange(ArrayList<Integer> history) {
		if(historyMax(history)-historyMin(history)>200)
			return historyMax(history)-historyMin(history);
		else
			return 200;
	}
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		ArrayList<Integer> history=m.getHistory();
		int min = historyMin(history);
		int range = historyRange(history);
		int maxX = getWidth() - 1;
		System.out.println(maxX);
		int maxY = getHeight() - 1;
		int zero = maxY + min * maxY / range;
		g.setColor(Color.BLUE);
		g.drawLine(0,zero , maxX, zero);
		g.setColor(Color.RED);
		for(int i=0;i<history.size()-1;i++) {
			int x=10*i;
			int y=zero-history.get(i)*maxY/range;
			if(history.size()==1)
				g.drawRect(x, y, 1, 1);
			else
				g.drawLine(x, y, 10*(i+1), zero-history.get(i+1)*maxY/range);
		}
	}
}
