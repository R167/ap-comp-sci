package picturelab;

/**
 * This class contains class (static) methods that will help you test the
 * Picture class methods. Uncomment the methods and the code in the main to
 * test.
 * 
 * @author Barbara Ericson
 */
public class PictureTester {
    /** Method to test zeroBlue */
    private static void testZeroBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.zeroBlue();
        beach.explore();
    }
    
    private static void testKeepOnlyBlue() {
        Picture beach = new Picture("beach.jpg");
        beach.keepOnlyBlue();
        beach.explore();
    }
    private static void testKeepOnlyRed() {
        Picture beach = new Picture("beach.jpg");
        beach.keepOnlyRed();
        beach.explore();
    }
    private static void testKeepOnlyGreen() {
        Picture beach = new Picture("beach.jpg");
        beach.keepOnlyGreen();
        beach.explore();
    }
    private static void testNegate() {
        Picture beach = new Picture("beach.jpg");
        beach.negate();
        beach.explore();
    }
    private static void testGrayscale() {
        Picture beach = new Picture("beach.jpg");
        beach.grayscale();
        beach.explore();
    }

    /** Method to test mirrorVertical */
    private static void testMirrorVertical() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVertical();
        caterpillar.explore();
    }
    
    private static void testMirrorVerticalRightToLeft() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.explore();
        caterpillar.mirrorVerticalRTL();
        caterpillar.explore();
    }

    /** Method to test mirrorTemple */
    private static void testMirrorTemple() {
        Picture temple = new Picture("temple.jpg");
        temple.explore();
        temple.mirrorTemple();
        temple.explore();
    }
    
    private static void testMirrorArms() {
        Picture temple = new Picture("snowman.jpg");
        temple.explore();
        temple.mirrorArms();
        temple.explore();
    }

    /** Method to test the collage method */
    private static void testCollage() {
        Picture canvas = new Picture("640x480.jpg");
        canvas.createCollage();
        canvas.explore();
    }

    /** Method to test edgeDetection */
    private static void testEdgeDetection() {
        Picture swan = new Picture("swan.jpg");
        swan.edgeDetection(10);
        swan.explore();
    }
    
    private static void testFixUnderwater() {
        Picture water = new Picture("water.jpg");
        water.fixUnderwater(25, 155);
        water.explore();
    }

    /**
     * Main method for testing. Every class can have a main method in Java
     */
    public static void main(String[] args) {
        // uncomment a call here to run a test
        // and comment out the ones you don't want
        // to run
//        testZeroBlue();
//         testKeepOnlyBlue();
//         testKeepOnlyRed();
//         testKeepOnlyGreen();
//         testNegate();
//         testGrayscale();
//         testFixUnderwater();
//        testMirrorVertical();
//        testMirrorVerticalRightToLeft();
//        testMirrorHorizontalTTB();
//        testMirrorHorizontalBTT();
//        testMirrorTemple();
         testMirrorArms();
        // testMirrorGull();
        // testMirrorDiagonal();
//        testCollage();
        // testCopy();
//        testEdgeDetection();
        // testEdgeDetection2();
        // testChromakey();
        // testEncodeAndDecode();
        // testGetCountRedOverValue(250);
        // testSetRedToHalfValueInTopHalf();
        // testClearBlueOverValue(200);
        // testGetAverageForColumn(0);
    }

    private static void testMirrorHorizontalTTB() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.mirrorHorizontalTTB();
        caterpillar.explore(); 
    }
    
    private static void testMirrorHorizontalBTT() {
        Picture caterpillar = new Picture("caterpillar.jpg");
        caterpillar.mirrorHorizontalBTT();
        caterpillar.explore(); 
    }
}