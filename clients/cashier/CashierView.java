	package clients.cashier;

import catalogue.Basket;
import clients.Picture;
import middle.MiddleFactory;
import middle.OrderProcessing;
import middle.StockException;
import middle.StockReadWriter;

import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;


/**
 * View of the model 
 */
public class CashierView implements Observer {
  private static final int H = 500;       // Height of window pixels
  private static final int W = 500;       // Width  of window pixels


  private static final String CHECK = "Check";
  private static final String BUY = "Buy";
  private static final String BOUGHT = "Bought/Pay";

  private final JLabel pageTitle = new JLabel();
  private final JLabel theAction = new JLabel();
  private final JTextField theInput = new JTextField();
  private final JTextArea theOutput = new JTextArea();
  private final JScrollPane theSP = new JScrollPane();
  private final JButton theBtCheck = new JButton(CHECK);
  private final JButton theBtBuy = new JButton(BUY);
  private final JButton theBtBought = new JButton(BOUGHT);


  private Picture img1 = new Picture(80,80);
  private Picture img2 = new Picture(80, 80);
  private Picture img3 = new Picture(80,80);
  private Picture img4 = new Picture(80,80);
  private Picture img5 = new Picture(80,80);
  private Picture img6 = new Picture(80,80);
  private Picture img7 = new Picture(80,80);







  private StockReadWriter theStock = null;
  private OrderProcessing theOrder = null;
  private CashierController cont = null;

  /**
   * Construct the view
   *
   * @param rpc Window in which to construct
   * @param mf  Factor to deliver order and stock objects
   * @param x   x-coordinate of position of window on screen
   * @param y   y-coordinate of position of window on screen
   */

  public CashierView(RootPaneContainer rpc, MiddleFactory mf, int x, int y) {
    try                                           // 
    {
      theStock = mf.makeStockReadWriter();        // Database access
      theOrder = mf.makeOrderProcessing();        // Process order
    } catch (Exception e) {
      System.out.println("Exception: " + e.getMessage());
    }
    Container cp = rpc.getContentPane();    // Content Pane
    Container rootWindow = (Container) rpc;         // Root Window
    cp.setLayout(null);                             // No layout manager
    rootWindow.setSize(W, H);                     // Size of Window
    rootWindow.setLocation(x, y);

    Font f = new Font("Monospaced", Font.PLAIN, 12);  // Font f is

    pageTitle.setBounds(110, 0, 270, 20);
    pageTitle.setText("Thank You for Shopping at MiniStrore");
    cp.add(pageTitle);

    theBtCheck.setBounds(16, 25 + 60 * 0, 80, 40);    // Check Button
    theBtCheck.addActionListener(                   // Call back code
            e -> cont.doCheck(theInput.getText()));
    cp.add(theBtCheck);                           //  Add to canvas

    theBtBuy.setBounds(16, 25 + 60 * 1, 80, 40);      // Buy button
    theBtBuy.addActionListener(                     // Call back code
            e -> {


                try {
                    if (theStock.exists(theInput.getText())){
                      cont.doBuy();
                      playSound();
                    } else {
                      JOptionPane.showMessageDialog(null, "Please enter a value before buying!");
                    }
                } catch (StockException ex) {
                    throw new RuntimeException(ex);
                }
            });




    cp.add(theBtBuy);                             //  Add to canvas

    theBtBought.setBounds(16, 25 + 60 * 3, 80, 40);   // Bought Button
    theBtBought.addActionListener(                  // Call back code
            e -> cont.doBought());
    cp.add(theBtBought);                          //  Add to canvas

    theAction.setBounds(110, 25, 270, 20);       // Message area
    theAction.setText("");                        // Blank
    cp.add(theAction);                            //  Add to canvas

    theInput.setBounds(110, 50, 270, 40);         // Input Area
    theInput.setText("");                           // Blank
    cp.add(theInput);                             //  Add to canvas

    theSP.setBounds(110, 100, 270, 160);          // Scrolling pane
    theOutput.setText("");                        //  Blank
    theOutput.setFont(f);                         //  Uses font
    cp.add(theSP);                                //  Add to canvas
    theSP.getViewport().add(theOutput);           //  In TextArea
    rootWindow.setVisible(true);                  // Make visible
    theInput.requestFocus();                        // Focus is here


    //img1
    img1.setBounds( 16, 25+60*6, 80, 80 );   // Picture area
    cp.add( img1);

    ImageIcon imageIcon = new ImageIcon("images/pic0001.jpg"); // Load the image from your path
    img1.set(imageIcon);

    img1.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        theInput.setText("0001");

      }
    });


    //img2
            img2.setBounds(16, 25 + 60 * 5, 80, 80);   // Picture area
    cp.add( img2 );

    ImageIcon imageIcon2 = new ImageIcon("images/pic0002.jpg"); // Load the image from your path
    img2.set(imageIcon2);

    img2.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        theInput.setText("0002");

      }
    });


    //img3
    img3.setBounds( 16 * 7 , 25+60*6, 80, 80 );   // Picture area
    cp.add( img3);

    ImageIcon imageIcon3 = new ImageIcon("images/pic0003.jpg"); // Load the image from your path
    img3.set(imageIcon3);
    img3.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        theInput.setText("0003");

      }
    });

    //img4
    img4.setBounds( 16 * 7, 25+60*5, 80, 80 );   // Picture area
    cp.add( img4);

    ImageIcon imageIcon4 = new ImageIcon("images/pic0004.jpg"); // Load the image from your path
    img4.set(imageIcon4);

    img4.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        theInput.setText("0004");

      }
    });

    //img5
    img5.setBounds( 16 * 14, 25+60*6, 80, 80 );   // Picture area
    cp.add( img5);

    ImageIcon imageIcon5 = new ImageIcon("images/pic0005.jpg"); // Load the image from your path
    img5.set(imageIcon5);
    img5.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        theInput.setText("0005");

      }
    });

    //img6
    img6.setBounds( 16 * 14, 25+60*5, 80, 80 );   // Picture area
    cp.add( img6);

    ImageIcon imageIcon6 = new ImageIcon("images/pic0006.jpg"); // Load the image from your path
    img6.set(imageIcon6);

    img6.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        theInput.setText("0006");

      }
    });

    //img7
    img7.setBounds( 16 * 21, 25+60*6, 80, 80 );   // Picture area
    cp.add( img7);

    ImageIcon imageIcon7 = new ImageIcon("images/pic0007.jpg"); // Load the image from your path
    img7.set(imageIcon7);

    img7.addMouseListener(new MouseAdapter() {
      @Override
      public void mouseClicked(MouseEvent e) {
        super.mouseClicked(e);
        theInput.setText("0007");

      }
    });




  }

  /**
   * The controller object, used so that an interaction can be passed to the controller
   *
   * @param c The controller
   */

  public void setController(CashierController c) {
    cont = c;
  }

  /**
   * Update the view
   *
   * @param modelC The observed model
   * @param arg    Specific args
   */
  @Override
  public void update(Observable modelC, Object arg) {
    CashierModel model = (CashierModel) modelC;
    String message = (String) arg;
    theAction.setText(message);
    Basket basket = model.getBasket();
    if (basket == null)
      theOutput.setText("Customers order");
    else
      theOutput.setText(basket.getDetails());

    theInput.requestFocus();               // Focus is here
  }


    public void playSound() {
      try {

        File soundFile = new File("raw/chaching.wav");  // plays a cha - ching sound effect

        AudioInputStream audioStream = AudioSystem.getAudioInputStream(soundFile);


        AudioFormat format = audioStream.getFormat();
        DataLine.Info info = new DataLine.Info(Clip.class, format);
        Clip audioClip = (Clip) AudioSystem.getLine(info);


        audioClip.open(audioStream);
        audioClip.start();

        System.out.println("Playing sound...");


        while (audioClip.isRunning()) {
          Thread.sleep(100);
        }

        // Close resources
        audioClip.close();
        audioStream.close();
      } catch (UnsupportedAudioFileException e) {
        System.out.println("The specified audio file is not supported.");
      } catch (LineUnavailableException e) {
        System.out.println("Audio line for playback is 3unavailable.");
      } catch (IOException e) {
        System.out.println("Error playing the audio file.");
      } catch (InterruptedException e) {
        System.out.println("Playback interrupted.");
      }
    }
  }
