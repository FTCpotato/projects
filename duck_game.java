import java.util.Scanner;
import java.lang.Math;
import java.util.Random;
import java.time.Clock;

public class game_test {

    static String empty = "";
    
	static void title(String txt){
		System.out.println(txt);
	}
	
	static String bkspc(String str, int amt){
	    return str.substring(0, str.length() - amt);
	}
	
	static void newLines(int amt){
	   for (int i=0; i<amt; i++){
	       System.out.println("");
	   }
	}

    static void pause(double sec){
        try {
            Thread.sleep(Math.round(sec*1000));
        }
        catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("an error occurred");
        }
    }

	static void fadeOutAnim(String msg, double wait){
	   int length = msg.length();
	               for (int i=0; i<length; i++){
                        String new_msg = bkspc(msg, i);
                        System.out.println(new_msg);
                        pause(wait);
                        //System.out.println(String.format("\033[%dA",1));
                        System.out.print("\033[2K");
                    }
	}

	static void fadeInAnim(String msg, double wait, Boolean move_cursor){
	   int length = msg.length();
	               for (int i=length; i>=0; i--){
                        String new_msg = bkspc(msg, i);
                        if(move_cursor==true){
                            System.out.println(new_msg);
                        }
                        else{
                            System.out.print(new_msg);
                            //if (i==length){
                                //System.out.print("\033[2K");                                pause(5000);
                            //}
                        }
                            pause(wait);
                            if (i!=0){
                                if(move_cursor==true){
                                    System.out.print(String.format("\033[%dA",1));
                                    System.out.print("\033[2K");
                                }
                                else{
                                    System.out.println(String.format("\033[%dA",1));
                                    System.out.print("\033[2K");
                                    
                                }
                            }
                    }
	  }
    
    static void easeAnim(String msg, double wait, Boolean move_cursor){
	   int length = msg.length();
	               for (int i=length; i>=0; i--){
                        String new_msg = bkspc(msg, i);
                        System.out.print(new_msg);
                        System.out.println(String.format("\033[%dA",1));
                        System.out.print("\033[2K");
                        pause(wait);
                    }
    }
    
    static void randomJump1D(String msg, int max, int min, double wait, int count) {
        String spacer = "";
        //int max = 5;
        //int min = 0;
            for (int i = 0; i < count; i++) {
                double raw_val = Math.floor(Math.random() * (max - min + 1) + min);
                int val = (int) Math.round(raw_val);
                //System.out.println(val);
                for (int j = 0; j < val; j++) {
                       spacer += " ";
                }
            System.out.print(spacer);
            System.out.print(msg);
            pause(wait);
            System.out.print("\33[2K");
            System.out.print("\r");
            spacer = "";
            }
    }
	  
    public static void clearScreen() {  
        System.out.print("\033[H\033[2J");  
        System.out.flush();  
    }                 
                        
	public static void main(String[] args) {
    	System.out.printf( "%-50s %55s %n", empty, "Feed The Duck");
    	newLines(2);
        fadeInAnim("Instructions:\n", 0.05, false);
        System.out.println(empty);
        fadeInAnim("feed the hungry duck before he runs away\n", 0.05, false);
        fadeInAnim("you have three lives\n", 0.05, false);
        fadeInAnim("once the duck appears, press '0' to feed\n", 0.05, false);
        fadeInAnim("PRESS '1' + 'RETURN/ENTER' TO START\n", 0.05, false);
        Scanner sc = new Scanner(System.in);
        int input = sc.nextInt();
        if (input == 1){
            clearScreen();
            System.out.print("\033[2K");
            fadeInAnim("♥️   ♥️   ♥", .08, false);
            //hunger bar?: fadeInAnim("🍖 🍖 🍖 🍖 🍖", .08, false)
            newLines(2);
            randomJump1D("🦆", int max, int min, double wait, int count)
            
        }
        
        
    }
    
}
