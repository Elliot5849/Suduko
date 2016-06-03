import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class sudoku {

	public JButton[][] grid = new JButton[9][9];
	public JButton[] sideBar = new JButton[9];

	public ImageIcon oneIcon, twoIcon, threeIcon, fourIcon, fiveIcon, sixIcon, sevenIcon, eightIcon, nineIcon;

	public int[][] board = new int[9][9];
	public int[] sideBoard = new int[9];
	public boolean won = false;

	JFrame frame = new JFrame();
	JPanel mainPanel = new JPanel();
	JPanel sudokuPanel = new JPanel();
	JPanel sidePanel = new JPanel();

	
	public void play(String id) {
		System.out.println("Square Conformation" + id);

	}

	public void choose(int noid) {

	}

	public void front_Display() {
	
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.X_AXIS));
		frame.setContentPane(mainPanel);
		
		frame.setVisible(true);
		frame.setResizable(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	
		sudokuPanel.setBorder(BorderFactory.createLineBorder(Color.black));
		sudokuPanel.setLayout(new GridLayout(9, 9, 0, 0));

	
		sidePanel.setBorder(BorderFactory.createLineBorder(Color.black));
		sidePanel.setLayout(new GridLayout(9, 1, 0, 0));
		
		mainPanel.add(sudokuPanel);
		mainPanel.add(sidePanel);
		
		sudokuPanel.addComponentListener(new ComponentListener() {

			public void componentResized(ComponentEvent e) {
				icons();
			}

			public void componentMoved(ComponentEvent e) {

			}

			public void componentShown(ComponentEvent e) {

			}

			public void componentHidden(ComponentEvent e) {

			}

		});
		
		

		sidePanel.addComponentListener(new ComponentListener() {

			public void componentResized(ComponentEvent e) {
				icons();
			}

			public void componentMoved(ComponentEvent e) {

			}

			public void componentShown(ComponentEvent e) {

			}

			public void componentHidden(ComponentEvent e) {

			}

		});
		
		
		
		sudoku_Buttons();
		number_Selection();
		
		frame.setSize(1000, 800);
	}

	// buttons for the sudoku
	public void sudoku_Buttons() {

		for (int i = 0; i < 9; i++) {
			final int posi = i;
			for (int j = 0; j < 9; j++) {
				final int posj = j;

				String id1 = Integer.toString(posi + 1);
				String id2 = Integer.toString(posj + 1);
				String id = id1 + id2;

				grid[i][j] = new JButton();
				grid[i][j].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent e) {
						play(id);
					}

				});

				sudokuPanel.add(grid[i][j]);
			}
		}
	}

	public void number_Selection() {
		for (int i = 0; i < 9; i++) {
			final int number = i;
			sideBar[i] = new JButton();
			sideBar[i].addActionListener(new ActionListener() {
				int noid = number;

				public void actionPerformed(ActionEvent e) {

					choose(noid);

				}
				
			});
			sidePanel.add(sideBar[i]);
			if (i == 0){
			sideBar[0].setIcon(oneIcon);
			}
			if (i == 1){
				sideBar[1].setIcon(twoIcon);
				}
			if (i == 2){
				sideBar[2].setIcon(threeIcon);
				}
			if (i == 3){
				sideBar[3].setIcon(fourIcon);
				}
			if (i == 4){
				sideBar[4].setIcon(fiveIcon);
				}
			if (i == 5){
				sideBar[5].setIcon(sixIcon);
				}
			if (i == 6){
				sideBar[6].setIcon(sevenIcon);
				}
			if (i == 7){
				sideBar[7].setIcon(eightIcon);
				}
			if (i == 8){
				sideBar[8].setIcon(nineIcon);
				}

		}
	}

	public void icons() {
		try {
			Image one = ImageIO.read(sudoku.class.getResource("/one.PNG"));
			Image two = ImageIO.read(sudoku.class.getResource("/two.PNG"));
			Image three = ImageIO.read(sudoku.class.getResource("/three.PNG"));
			Image four = ImageIO.read(sudoku.class.getResource("/four.PNG"));
			Image five = ImageIO.read(sudoku.class.getResource("/five.PNG"));
			Image six = ImageIO.read(sudoku.class.getResource("/six.PNG"));
			Image seven = ImageIO.read(sudoku.class.getResource("/seven.PNG"));
			Image eight = ImageIO.read(sudoku.class.getResource("/eight.PNG"));
			Image nine = ImageIO.read(sudoku.class.getResource("/nine.PNG"));

			oneIcon = new ImageIcon(
					one.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			twoIcon = new ImageIcon(
					two.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			threeIcon = new ImageIcon(
					three.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			fourIcon = new ImageIcon(
					four.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			fiveIcon = new ImageIcon(
					five.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			sixIcon = new ImageIcon(
					six.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			sevenIcon = new ImageIcon(
					seven.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			eightIcon = new ImageIcon(
					eight.getScaledInstance(50, 50, Image.SCALE_SMOOTH));
			nineIcon = new ImageIcon(
					nine.getScaledInstance(50, 50, Image.SCALE_SMOOTH));

		} catch (IOException ex) {
			ex.printStackTrace();
	}
		}

	public static void main(String[] args) {

		sudoku sud = new sudoku();
		sud.icons();
		sud.front_Display();
		
	}

}
