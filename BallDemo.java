import java.awt.Color;

/**
 * Class BallDemo - a short demonstration showing animation with the 
 * Canvas class. 
 *
 * @author Michael Kölling and David J. Barnes
 * @version 2011.07.31
 */

public class BallDemo   
{
    private Canvas myCanvas;

    /**
     * Create a BallDemo object. Creates a fresh canvas and makes it visible.
     */
    public BallDemo()
    {
        myCanvas = new Canvas("Ball Demo", 600, 500);
    }

    /**
     * Simulate two bouncing balls
     */
    public void bounce()
    {
        int ground = 400;   // position of the ground line

        myCanvas.setVisible(true);

        // draw the ground
        myCanvas.drawLine(50, ground, 550, ground);

        // crate and show the balls
        BouncingBall ball = new BouncingBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        ball.draw();
        BouncingBall ball2 = new BouncingBall(70, 80, 20, Color.RED, ground, myCanvas);
        ball2.draw();

        // make them bounce
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            ball.move();
            ball2.move();
            // stop once ball has travelled a certain distance on x axis
            if(ball.getXPosition() >= 550 || ball2.getXPosition() >= 550) {
                finished = true;
            }
        }
    }
    
    /**
     * Simulates balls bouncing in a box
     */
    public void BoxBounce()
    {
        int ground = 450;
        int offset = 550;
        
        myCanvas.setVisible(true);
        
        myCanvas.drawLine(50, 50, 50, ground);
        myCanvas.drawLine(50, 50, offset, 50);
        myCanvas.drawLine(offset, 50, offset, ground);
        myCanvas.drawLine(50, ground, offset, ground);
        
        //BoxBall ball = new BoxBall(50, 50, 16, Color.BLUE, ground, myCanvas);
        BoxBall[] addBall = new BoxBall[3];
        
        //for(int b = 0;b < 3;b++)
       // {
            addBall[0] = new BoxBall(50, 50, 16, Color.BLUE, ground, myCanvas);
    //}
         addBall[1] = new BoxBall(150, 50, 16, Color.GREEN, ground, myCanvas);
          addBall[2] = new BoxBall(50, 150, 16, Color.RED, ground, myCanvas);
        boolean finished =  false;
        while(!finished) {
            myCanvas.wait(50);           // small delay
            for(int b = 0;b < 3;b++)
            {
                addBall[b].move();
            }
            //if(addBall.getXPosition() <= 5550) {
                //myCanvas.wait(50000);
                //finished = true;
           // }
        }
    }
}