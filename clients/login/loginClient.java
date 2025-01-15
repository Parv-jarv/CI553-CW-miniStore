package clients.login;

import middle.MiddleFactory;
import middle.Names;
import middle.RemoteMiddleFactory;

import javax.swing.*;

public class loginClient {
    public static void main (String args[])
    {
        String stockURL = args.length < 1         // URL of stock R
                ? Names.STOCK_R           //  default  location
                : args[0];                //  supplied location

        RemoteMiddleFactory mrf = new RemoteMiddleFactory();
        mrf.setStockRInfo( stockURL );
        displayGUI(mrf);                          // Create GUI
    }

    private static void displayGUI(MiddleFactory mf)
    {
        JFrame window = new JFrame();
        window.setTitle( "Login Client (MVC RMI)" );
        window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

        loginModel model = new loginModel(mf);
        loginView view  = new loginView( window, mf, 0, 0, new loginView.LoginListener() {
            @Override
            public void onLoginSuccess() {

            }
        });


        model.addObserver( view );
        window.setVisible(true);
    }
}
