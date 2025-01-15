package clients.login;


import middle.MiddleFactory;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Observable;
import java.util.Observer;

public class loginView implements Observer {
    private static final int H = 500;
    private static final int W = 300;



    private final JLabel title1 = new JLabel();
    private final JLabel title2 = new JLabel();
    private final TextField Username = new TextField();
    private final JPasswordField Password = new JPasswordField();
    private final JButton logIn = new JButton();
    private final JCheckBox show = new JCheckBox();


    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    private LoginListener loginListener;

    public interface LoginListener {
        void onLoginSuccess(); // Callback method for successful login
    }

public loginView (RootPaneContainer rpc, MiddleFactory mf, int x, int y, LoginListener loginListener) {



    Container cp = rpc.getContentPane();
    Container rootWindow = (Container) rpc;
    cp.setLayout(null);
    rootWindow.setSize(H, W);
    rootWindow.setLocation(x, y);


    String input1 = "";
    title1.setBounds(100,50,300,25);
    title1.setText("Username");
    Username.setBounds(100, 75, 300, 25);
    Username.setText("");
    input1 = Username.getText();

    title2.setBounds(100,100,300,25);
    title2.setText("Password");
    Password.setBounds(100, 125, 300, 25);
    String input2= "";

        Password.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                Password.setText("");
                Password.setEchoChar('*');


            }

        });
     input2 = new String(Password.getPassword());

    show.setBounds(100,80,200,200);
    show.setText("Show Password");
    show.addActionListener(
            e -> {
                if (show.isSelected()){
                    Password.setEchoChar((char)0);
                }else{
                    Password.setEchoChar('*');
                }
            }
    );




    String Cashier = "123";
    String password = "123";

    logIn.setBounds(275,175,100,50);
    logIn.setText("Log in");
    logIn.addActionListener(
            e -> {
                String enteredUsername = Username.getText(); // Get the username from the field
                String enteredPassword = new String(Password.getPassword()); // Get the password from the field

                if (!enteredUsername.equals(Cashier) && !enteredPassword.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Incorrect Username and Password!");
                } else if (!enteredUsername.equals(Cashier)) {
                    JOptionPane.showMessageDialog(null, "Incorrect Username!");
                } else if (!enteredPassword.equals(password)) {
                    JOptionPane.showMessageDialog(null, "Incorrect Password!");
                } else {
                    JOptionPane.showMessageDialog(null, "Correct Username and Password!");

                    ((Container) rpc).setVisible(false);
                    if (loginListener != null) {
                        loginListener.onLoginSuccess(); // Notify the listener that login was successful
                    }








                }
            }


    );



    screenSize.getHeight();
    screenSize.getWidth();
    int screenHeight = screenSize.height;
    int screenWidth = screenSize.width;

    cp.add(Password);
    cp.add(Username);
    cp.add(logIn);
    cp.add(show);
    cp.add(title1);
    cp.add(title2);

    displaySize(screenHeight,screenWidth);

}



    @Override
    public void update(Observable o, Object arg) {
        loginModel model = (loginModel) o;
    }



    public void displaySize(int screenHeight, int screenWidth){
        // java - get screen size using the Toolkit class

        System.out.println(screenHeight);
        System.out.println(screenWidth);
    }


}
