package jordan;

import java.util.Random;

public class ConnectMain {
    public static long t = System.nanoTime();
    
    public static void main(String[] a) {
        int rep = 1_000_000;
        Board[] jors = new Board[rep];
        connectfour.Board[] wins = new connectfour.Board[rep];
        
        System.out.println("Creation:");
        start();
        for (int j = 0; j < rep; j++) {
            jors[j] = new Board();
        }
        time();
        start();
        for (int j = 0; j < rep; j++) {
            wins[j] = new connectfour.Board();
        }
        time();
        
//        System.out.println("Filling:");
//        start();
//        for (int j = 0; j < rep; j++) {
//            for (int i = 0; i < 7; i++) {
//                for (int k = 0; k < 6; k++) {
//                    jors[j].setCounters(i, 'X');
//                }
//            }
//        }
//        time();
//        start();
//        for (int j = 0; j < rep; j++) {
//            for (int i = 0; i < 7; i++) {
//                for (int k = 0; k < 6; k++) {
//                    wins[j].dropColumn(i, connectfour.Color.BLACK);
//                }
//            }
//        }
//        time();
//        
//        System.out.println("Creation (again):");
//        jors = new Board[rep];
//        start();
//        for (int j = 0; j < rep; j++) {
//            jors[j] = new Board();
//        }
//        time();
//        wins = new connectfour.Board[rep];
//        start();
//        for (int j = 0; j < rep; j++) {
//            wins[j] = new connectfour.Board();
//        }
//        time();
        
//        System.out.println("Random Filling:");
//        Random rand = new Random();
//        start();
//        for (int j = 0; j < rep; j++) {
//            for (int i = 0; i < 7; i++) {
//                for (int k = 0; k < 6; k++) {
//                    if (rand.nextBoolean()) {
//                        jors[j].setCounters(i, 'X'); 
//                    } else {
//                        jors[j].setCounters(i, 'O');
//                    }
//                }
//            }
//        }
//        time();
//        start();
//        for (int j = 0; j < rep; j++) {
//            for (int i = 0; i < 7; i++) {
//                if (rand.nextBoolean()) {
//                    wins[j].dropColumn(i, connectfour.Color.WHITE); 
//                } else {
//                    wins[j].dropColumn(i, connectfour.Color.BLACK);
//                }
//            }
//        }
//        time();
        
      System.out.println("Filling...");
      Random rand = new Random();
      start();
      for (int j = 0; j < rep; j++) {
          for (int i = 0; i < 7; i++) {
              for (int k = 0; k < 6; k++) {
                  if (rand.nextBoolean()) {
                      jors[j].setCounters(i, 'X');
                      wins[j].dropColumn(i, connectfour.Color.BLACK);
                  } else {
                      jors[j].setCounters(i, 'O');
                      wins[j].dropColumn(i, connectfour.Color.WHITE);
                  }
              }
          }
      }
      time();
      
      System.out.println("Finding Winners");
      start();
      for (int j = 0; j < rep; j++) {
          for (int i = 0; i < 7; i++) {
              for (int k = 0; k < 6; k++) {
                  wins[j].getWinner();
              }
          }
      }
      time();
      start();
      for (int j = 0; j < rep; j++) {
          for (int i = 0; i < 7; i++) {
              for (int k = 0; k < 6; k++) {
                  jors[j].getWin();
              }
          }
      }
      time();
    }

    public static void start() {
        t = System.nanoTime();
    }
    
    public static void time() {
        System.out.println((System.nanoTime() - t) / 1000000000.0);
    }
}
