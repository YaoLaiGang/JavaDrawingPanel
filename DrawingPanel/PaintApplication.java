/**
 *   JAVA DRAWING APP
 *   Ivana Zuber
 *   March 2013
 */

import javax.imageio.ImageIO;
import javax.swing.*;

import java.io.File;
import java.io.IOException;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.event.WindowStateListener;
import java.awt.image.BufferedImage;

public class PaintApplication extends JFrame
{
    /**************************************************************************************************************
     *****************************************************VARIABLES************************************************
     **************************************************************************************************************/
    public DrawingPanel drawingPanel;
    protected MenuBar menuBar;
    protected ColorPalette colorPalette;
    public PaintToolPanel paintToolPanel;

    /**************************************************************************************************************
     ***************************************************CONSTRUCTOR************************************************
     **************************************************************************************************************/
    public PaintApplication()
    {
        super("JAVA DRAWING");  //overriding JFrame's title

        ImageIcon ImageIcon = getIcon("./images/IMG_BOJA_48.png");
        Image Image = ImageIcon.getImage();

        drawingPanel = new DrawingPanel();                              //create drawing panel
        menuBar = new MenuBar();                                        //create menu bar
        colorPalette = new ColorPalette();                              //create color palette panel
        paintToolPanel = new PaintToolPanel(new StrokeToolPanel(5));   //create drawing tool panel
        add(menuBar, "North");                                         //add panels to the main JFrame
        add(colorPalette, "South");
        add(paintToolPanel, "West");
        add(new JScrollPane(drawingPanel), "Center");

        this.setIconImage(Image);    //setting JFrame's icon image
        this.setSize(1024, 768);     //set size of the application
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);   //set default close operation
        this.setLocationRelativeTo(null);                               //set locating to the middle of the screen
        this.setVisible(true);                                          //set visible
        setStaringColor();                                             //set the starting color
        
        this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				// 删除当前保存的临时文件
				File file = new File("./tmp.png");
				if (file.exists() && file.isFile()) {
					file.delete();
				}
			}
			
			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
    }

    /**************************************************************************************************************
     ***************************************************METHODS****************************************************
     **************************************************************************************************************/
    public void setStaringColor()     //set starting color to be used for drawing
    {
        ColorPalette.selectedColorDisplay.setBackground(Color.black);
        ColorPalette.selectedColor = ColorPalette.selectedColorDisplay.getBackground();
        drawingPanel.currentToolDetails.setColor(ColorPalette.selectedColorDisplay.getBackground());
        drawingPanel.brushColor = ColorPalette.selectedColor;
    }

    /**
     * Method used to return the ImageIcon object that has the path
     * equal to the one given to the method as an input parameter.
     * In case the inputed imagePath parameter is not valid
     * an exception will be caught in the try catch block
     * and the default image used in the JOptionPane
     * @param imagePath  class path
     * @return ImageIcon
     */
    public static ImageIcon getIcon(String imagePath)
    {
        try
        {
            return new ImageIcon(PaintApplication.class.getResource(imagePath));
        }
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Invalid image path");
            return null;
        }
    }
    
    public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		// 恢复最大最小化时候的状态
//		System.out.println(DrawingPanel.history.size());
//		for(PaintElement pe : DrawingPanel.history) {
//			System.out.println(pe.currentTool.toolType);
//			drawGraphics((Graphics2D) g, pe.currentTool, pe.startX, pe.startY, pe.mouseX, pe.mouseY, pe.currenToolDetails);
//		}
		
		try
        {
			File file = new File("./tmp.png");
			if (file.exists() && file.isFile()) {
            Main.paint.drawingPanel.setOSImage(ImageIO.read(file)); //set current image to isSelected image
			}
        } catch (IOException ex)
        {
            JOptionPane.showMessageDialog(null, "Could not open file");
        }
		
	}

    
}
