package com.ggl.testing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Point;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DotMatrixDigits implements Runnable {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new DotMatrixDigits());
	}
	
	@Override
	public void run() {
		JFrame frame = new JFrame("Dot Matrix Digits");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.add(defineTopPanel(), BorderLayout.BEFORE_FIRST_LINE);
		frame.add(defineBottomPanel(), BorderLayout.AFTER_LAST_LINE);
		
		frame.pack();
		frame.setLocationByPlatform(true);
		frame.setVisible(true);
	}
	
	private JPanel defineTopPanel() {
		JPanel panel = new JPanel();
		panel.add(new DotMatrixDigit(0, Color.YELLOW, Color.BLACK));
		panel.add(new DotMatrixDigit(1, Color.YELLOW, Color.BLACK));
		panel.add(new DotMatrixDigit(2, Color.YELLOW, Color.BLACK));
		panel.add(new DotMatrixDigit(3, Color.YELLOW, Color.BLACK));
		panel.add(new DotMatrixDigit(4, Color.YELLOW, Color.BLACK));
		return panel;
	}
	
	private JPanel defineBottomPanel() {
		JPanel panel = new JPanel();
		panel.add(new DotMatrixDigit(5, Color.YELLOW, Color.BLACK));
		panel.add(new DotMatrixDigit(6, Color.YELLOW, Color.BLACK));
		panel.add(new DotMatrixDigit(7, Color.YELLOW, Color.BLACK));
		panel.add(new DotMatrixDigit(8, Color.YELLOW, Color.BLACK));
		panel.add(new DotMatrixDigit(9, Color.YELLOW, Color.BLACK));
		return panel;
	}
	
	/**
	 * <p>
	 * The <code>DotMatrixDigit</code> class creates a dot-matrix digit panel by
	 * extending <code>JPanel</code>. The dot matrix digit is 5 positions across and
	 * 7 positions down. The size of the dot and distance between dots are defined
	 * in the constructor of this class. The shape of the dot is determined in the
	 * <code>paintComponent</code> method.
	 * </p>
	 * 
	 * @author Gilbert G. Le Blanc
	 * @version 1.8 - 20 October 2020
	 *
	 * @see JPanel
	 * @see Color
	 */
	public class DotMatrixDigit extends JPanel {

		private static final long serialVersionUID = 1L;
		
		/** int field to hold the digit to display **/
		private int digit;
		
		/** int field to hold the width of the dot in pixels **/
		private int dotWidth;
		
		/** int field to hold the distance between the 
		 * top left corner of the dots in pixels **/
		private int pixelWidth;
		
		/** int field to hold the margin size in 
		 * pixels surrounding the digit **/
		private int margin;
		
		private final Color dotColor;
		
		private int[][][] matrices;
		
		/**
		 * <p>
		 * This constructor creates a dot matrix digit panel. The preferred size of the
		 * panel is determined by the pixel width of each dot, including the space
		 * between the dots.
		 * </p>
		 * 
		 * @param digit           - The initial digit to display from 0 through 9.
		 * @param dotColor        - The <code>Color</code> of the dots.
		 * @param backgroundColor - The background <code>Color</code> of the dot matrix
		 *                        digit panel.
		 *                        
		 */
		public DotMatrixDigit(int digit, Color dotColor, Color backgroundColor) {
			this.digit = digit;
			this.dotColor = dotColor;
			
			this.dotWidth = 10;
			this.pixelWidth = 15;
			this.margin = dotWidth;
			this.matrices = defineDigitMatricies();
			
			int width = 4 * pixelWidth + dotWidth + margin + margin;
			int height = 6 * pixelWidth + dotWidth + margin + margin;
			this.setBackground(backgroundColor);
			this.setPreferredSize(new Dimension(width, height));
		}
		
		private int[][][] defineDigitMatricies() {
			int[][][] matrices = new int[10][][];
			matrices[0] = defineZeroMatrix();
			matrices[1] = defineOneMatrix();
			matrices[2] = defineTwoMatrix();
			matrices[3] = defineThreeMatrix();
			matrices[4] = defineFourMatrix();
			matrices[5] = defineFiveMatrix();
			matrices[6] = defineSixMatrix();
			matrices[7] = defineSevenMatrix();
			matrices[8] = defineEightMatrix();
			matrices[9] = defineNineMatrix();
			
			return matrices;
		}
		
		private int[][] defineZeroMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 0, 1, 1, 1, 0 };
			matrix[1] = new int[] { 1, 0, 0, 0, 1 };
			matrix[2] = new int[] { 1, 0, 0, 0, 1 };
			matrix[3] = new int[] { 1, 0, 0, 0, 1 };
			matrix[4] = new int[] { 1, 0, 0, 0, 1 };
			matrix[5] = new int[] { 1, 0, 0, 0, 1 };
			matrix[6] = new int[] { 0, 1, 1, 1, 0 };
			
			return matrix;
		}
		
		private int[][] defineOneMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 0, 0, 1, 0, 0 };
			matrix[1] = new int[] { 0, 1, 1, 0, 0 };
			matrix[2] = new int[] { 1, 0, 1, 0, 0 };
			matrix[3] = new int[] { 0, 0, 1, 0, 0 };
			matrix[4] = new int[] { 0, 0, 1, 0, 0 };
			matrix[5] = new int[] { 0, 0, 1, 0, 0 };
			matrix[6] = new int[] { 1, 1, 1, 1, 1 };
			
			return matrix;
		}
		
		private int[][] defineTwoMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 0, 1, 1, 1, 0 };
			matrix[1] = new int[] { 1, 0, 0, 0, 1 };
			matrix[2] = new int[] { 0, 0, 0, 0, 1 };
			matrix[3] = new int[] { 0, 0, 0, 1, 0 };
			matrix[4] = new int[] { 0, 0, 1, 0, 0 };
			matrix[5] = new int[] { 0, 1, 0, 0, 0 };
			matrix[6] = new int[] { 1, 1, 1, 1, 1 };
			
			return matrix;
		}
		
		private int[][] defineThreeMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 0, 1, 1, 1, 0 };
			matrix[1] = new int[] { 1, 0, 0, 0, 1 };
			matrix[2] = new int[] { 0, 0, 0, 0, 1 };
			matrix[3] = new int[] { 0, 0, 1, 1, 0 };
			matrix[4] = new int[] { 0, 0, 0, 0, 1 };
			matrix[5] = new int[] { 1, 0, 0, 0, 1 };
			matrix[6] = new int[] { 0, 1, 1, 1, 0 };
			
			return matrix;
		}
		
		private int[][] defineFourMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 0, 0, 0, 1, 0 };
			matrix[1] = new int[] { 0, 0, 1, 1, 0 };
			matrix[2] = new int[] { 0, 1, 0, 1, 0 };
			matrix[3] = new int[] { 1, 0, 0, 1, 0 };
			matrix[4] = new int[] { 1, 1, 1, 1, 1 };
			matrix[5] = new int[] { 0, 0, 0, 1, 0 };
			matrix[6] = new int[] { 0, 0, 0, 1, 0 };
			
			return matrix;
		}
		
		private int[][] defineFiveMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 1, 1, 1, 1, 1 };
			matrix[1] = new int[] { 1, 0, 0, 0, 0 };
			matrix[2] = new int[] { 1, 0, 0, 0, 0 };
			matrix[3] = new int[] { 1, 1, 1, 1, 0 };
			matrix[4] = new int[] { 0, 0, 0, 0, 1 };
			matrix[5] = new int[] { 1, 0, 0, 0, 1 };
			matrix[6] = new int[] { 0, 1, 1, 1, 0 };
			
			return matrix;
		}
		
		private int[][] defineSixMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 0, 1, 1, 1, 0 };
			matrix[1] = new int[] { 1, 0, 0, 0, 1 };
			matrix[2] = new int[] { 1, 0, 0, 0, 0 };
			matrix[3] = new int[] { 1, 1, 1, 1, 0 };
			matrix[4] = new int[] { 1, 0, 0, 0, 1 };
			matrix[5] = new int[] { 1, 0, 0, 0, 1 };
			matrix[6] = new int[] { 0, 1, 1, 1, 0 };
			
			return matrix;
		}
		
		private int[][] defineSevenMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 1, 1, 1, 1, 1 };
			matrix[1] = new int[] { 0, 0, 0, 0, 1 };
			matrix[2] = new int[] { 0, 0, 0, 0, 1 };
			matrix[3] = new int[] { 0, 0, 0, 1, 0 };
			matrix[4] = new int[] { 0, 0, 1, 0, 0 };
			matrix[5] = new int[] { 0, 0, 1, 0, 0 };
			matrix[6] = new int[] { 0, 0, 1, 0, 0 };
			
			return matrix;
		}
		
		private int[][] defineEightMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 0, 1, 1, 1, 0 };
			matrix[1] = new int[] { 1, 0, 0, 0, 1 };
			matrix[2] = new int[] { 1, 0, 0, 0, 1 };
			matrix[3] = new int[] { 0, 1, 1, 1, 0 };
			matrix[4] = new int[] { 1, 0, 0, 0, 1 };
			matrix[5] = new int[] { 1, 0, 0, 0, 1 };
			matrix[6] = new int[] { 0, 1, 1, 1, 0 };
			
			return matrix;
		}

		private int[][] defineNineMatrix() {
			int[][] matrix = new int[7][];
			matrix[0] = new int[] { 0, 1, 1, 1, 0 };
			matrix[1] = new int[] { 1, 0, 0, 0, 1 };
			matrix[2] = new int[] { 1, 0, 0, 0, 1 };
			matrix[3] = new int[] { 0, 1, 1, 1, 1 };
			matrix[4] = new int[] { 0, 0, 0, 0, 1 };
			matrix[5] = new int[] { 1, 0, 0, 0, 1 };
			matrix[6] = new int[] { 0, 1, 1, 1, 0 };
			
			return matrix;
		}

		/**
		 * <p>
		 * The <code>setDigit</code> method sets the digit to display and repaints the
		 * panel.
		 * </p>
		 * 
		 * @param digit - A digit from 0 through 9.
		 */
		public void setDigit(int digit) {
			this.digit = digit;
			this.repaint();
		}
		
		@Override
		protected void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			g.setColor(dotColor);
			for (int row = 0; row < matrices[digit].length; row++) {
				for (int column = 0; column < matrices[digit][row].length; column++) {
					if (matrices[digit][row][column] != 0) {
						int x = margin + column * pixelWidth;
						int y = margin + row * pixelWidth;
						g.fillOval(x, y, dotWidth, dotWidth);
					}
				}				
			}
		}
		
	}

}
