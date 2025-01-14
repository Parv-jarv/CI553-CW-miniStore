package clients.customer;

import catalogue.Basket;
import catalogue.BetterBasket;
import clients.Picture;
import middle.MiddleFactory;
import middle.StockReader;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

/**
 * Implements the Customer view.
 */

public class CustomerView implements Observer
{
  class Name                              // Names of buttons
  {
    public static final String CHECK  = "Check";
    public static final String CLEAR  = "Clear";
  }

  private static final int H = 500;       // Height of window pixels
  private static final int W = 500;       // Width  of window pixels

  private final JLabel      pageTitle  = new JLabel();
  private final JLabel      theAction  = new JLabel();
  private final JTextField  theInput   = new JTextField();
  private final JTextArea   theOutput  = new JTextArea();
  private final JScrollPane theSP      = new JScrollPane();
  private final JButton     theBtCheck = new JButton( Name.CHECK );
  private final JButton     theBtClear = new JButton( Name.CLEAR );
  private final JButton change2dark = new JButton();
  private Picture thePicture = new Picture(80,80);
  private StockReader theStock   = null;
  private CustomerController cont= null;

  private Picture img1 = new Picture(80,80);
  private Picture img2 = new Picture(80, 80);
  private Picture img3 = new Picture(80,80);
  private Picture img4 = new Picture(80,80);
  private Picture img5 = new Picture(80,80);
  private Picture img6 = new Picture(80,80);
  private Picture img7 = new Picture(80,80);


  /**
   * Construct the view
   * @param rpc   Window in which to construct
   * @param mf    Factor to deliver order and stock objects
   * @param x     x-cordinate of position of window on screen 
   * @param y     y-cordinate of position of window on screen  
   */
  
  public CustomerView( RootPaneContainer rpc, MiddleFactory mf, int x, int y )
  {
    try                                             // 
    {      
      theStock  = mf.makeStockReader();             // Database Access
    } catch ( Exception e )
    {
      System.out.println("Exception: " + e.getMessage() );
    }
    Container cp         = rpc.getContentPane();    // Content Pane
    Container rootWindow = (Container) rpc;// Root Window
    cp.setLayout(null);                             // No layout manager
    rootWindow.setSize( W, H );                     // Size of Window
    rootWindow.setLocation( x, y );



    Font f = new Font("Monospaced",Font.PLAIN,12);  // Font f is
    
    pageTitle.setBounds( 110, 0 , 270, 20 );       
    pageTitle.setText( "Search products" );                        
    cp.add( pageTitle );

    theBtCheck.setBounds( 16, 25+60*0, 80, 40 );    // Check button
    theBtCheck.addActionListener(                   // Call back code
      e -> cont.doCheck( theInput.getText() ) );
    cp.add( theBtCheck );                           //  Add to canvas

    theBtClear.setBounds( 16, 25+60*1, 80, 40 );    // Clear button
    theBtClear.addActionListener(                   // Call back code
      e -> cont.doClear() );
    cp.add( theBtClear );                           //  Add to canvas

    theAction.setBounds( 110, 25 , 270, 20 );       // Message area
    theAction.setText( " " );// blank

    cp.add( theAction );//  Add to canvas

    final int[] counter = {0};

    change2dark.setBounds( 16, 25+60*4, 80, 40 );
    change2dark.setText("Dark Mode");
    change2dark.addActionListener(                   // Call back code
          e ->{
            counter[0] = counter[0] + 1;
            if (counter[0] %2 == 1){
              cp.setBackground(Color.DARK_GRAY);
              pageTitle.setForeground(Color.WHITE);
            }else{
              cp.setBackground(Color.white);
              pageTitle.setForeground(Color.BLACK);
            }


          });
    cp.add(change2dark);




    theInput.setBounds( 110, 50, 270, 40 );         // Product no area
    theInput.setText("");                           // Blank
    cp.add( theInput );                             //  Add to canvas
    
    theSP.setBounds( 110, 100, 270, 160 );          // Scrolling pane
    theOutput.setText( "" );                        //  Blank
    theOutput.setFont( f );                         //  Uses font  
    cp.add( theSP );                                //  Add to canvas
    theSP.getViewport().add( theOutput );           //  In TextArea

    thePicture.setBounds( 16, 25+60*2, 80, 80 );   // Picture area
    cp.add( thePicture );                           //  Add to canvas
    thePicture.clear();
    
    rootWindow.setVisible( true );                  // Make visible);
    theInput.requestFocus();// Focus is here


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
   * @param c   The controller
   */

  public void setController( CustomerController c )
  {
    cont = c;
  }

  /**
   * Update the view
   * @param modelC   The observed model
   * @param arg      Specific args 
   */
   
  public void update( Observable modelC, Object arg )
  {
    CustomerModel model  = (CustomerModel) modelC;
    String        message = (String) arg;
    theAction.setText( message );
    ImageIcon image = model.getPicture();  // Image of product
    if ( image == null )
    {
      thePicture.clear();                  // Clear picture
    } else {
      thePicture.set( image );             // Display picture
    }
    theOutput.setText( model.getBasket().getDetails() );
    theInput.requestFocus();               // Focus is here
  }

}
