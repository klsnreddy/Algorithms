import edu.princeton.cs.algs4.Picture;
import java.awt.Color;

public class SeamCarver {

    private Picture picture = null;
    
    private static final double DEFAULT_ENERGY = 195075; 
    
    // create a seam carver object based on the given picture
    public SeamCarver(Picture picture) {
        this.picture = new Picture(picture);
    }
    
    // current picture
    public Picture picture() {
        return picture;
    }
    
    // width of current picture
    public int width() {
        return picture.width();
    }
    
    // height of current picture
    public int height() {
        return picture.height();
    }
    
    // energy of pixel at column x and row y
    public double energy(int x, int y) {
        if (x < 0 || x >= width() || y < 0 || y >= height()) {
            throw new IndexOutOfBoundsException();
        }
        
        if (x == 0 || y == 0 || x == width() - 1 || y == height() - 1)
            return DEFAULT_ENERGY;
        
        double dX = gradient(picture.get(x - 1, y), picture.get(x + 1, y));
        double dY = gradient(picture.get(x, y - 1), picture.get(x, y + 1));
        
        return dX + dY;
    }
    
    private double gradient(Color color1, Color color2) {
        int red = color2.getRed() - color1.getRed();
        int green = color2.getGreen() - color1.getGreen();
        int blue = color2.getBlue() - color1.getBlue();
        return red * red + green * green + blue * blue;
    }

    // sequence of indices for horizontal seam
    public int[] findHorizontalSeam() {
        int height = height();
        int width = width();
        double[][] energies = new double[height][width];
        int[][] pathTo = new int[height][width];
        double[][] cumEngy = new double[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                energies[i][j] = energy(j, i);
            }
        }
        
        for (int i = 0; i < height; i++) 
            cumEngy[i][0] = energies[i][0];
        
        for (int j = 1; j < width; j++) {
            for (int i = 0; i < height; i++) {
                int col = j - 1;
                if (i == 0 || i == height - 1) {
                    cumEngy[i][j] = cumEngy[i][col] + energies[i][j];
                    continue;
                }
                
                if (cumEngy[i - 1][col] > cumEngy[i][col]) {
                    if (cumEngy[i][col] > cumEngy[i + 1][col]) {
                        pathTo[i][j] = i + 1;
                        cumEngy[i][j] = cumEngy[i + 1][col] + energies[i][j];
                    } else {
                        pathTo[i][j] = i;
                        cumEngy[i][j] = cumEngy[i][col] + energies[i][j];
                    }
                } else if (cumEngy[i - 1][col] > cumEngy[i + 1][col]) {
                    pathTo[i][j] = i + 1;
                    cumEngy[i][j] = cumEngy[i + 1][col] + energies[i][j];
                } else {
                    pathTo[i][j] = i - 1;
                    cumEngy[i][j] = cumEngy[i - 1][col] + energies[i][j];
                }
            }
        }
        
        int minIdx = 0;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < height; i++) {
            if (min > cumEngy[i][width - 1]) {
                min = cumEngy[i][width - 1];
                minIdx = i;
            }
        }
        
        int[] seam = new int[width];
        for (int i = seam.length - 1; i > 0; i--) {
            seam[i] = minIdx;
            minIdx = pathTo[minIdx][i];
        }
        seam[0] = minIdx;
        return seam;
    }
    
    // sequence of indices for vertical seam
    public int[] findVerticalSeam() {
        int height = height();
        int width = width();
        double[][] energies = new double[height][width];
        int[][] pathTo = new int[height][width];
        double[][] cumEngy = new double[height][width];
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                energies[i][j] = energy(j, i);
            }
        }
        
        for (int i = 0; i < width; i++) 
            cumEngy[0][i] = energies[0][i];
        
        for (int i = 1; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int row = i - 1;
                if (j == 0 || j == width - 1) {
                    cumEngy[i][j] = cumEngy[row][j] + energies[i][j];
                    continue;
                }
                
                if (cumEngy[row][j + 1] > cumEngy[row][j]) {
                    if (cumEngy[row][j] > cumEngy[row][j - 1]) {
                        pathTo[i][j] = j - 1;
                        cumEngy[i][j] = cumEngy[row][j - 1] + energies[i][j];
                    } else {
                        pathTo[i][j] = j;
                        cumEngy[i][j] = cumEngy[row][j] + energies[i][j];
                    }
                } else if (cumEngy[row][j - 1] > cumEngy[row][j + 1]) {
                    pathTo[i][j] = j + 1;
                    cumEngy[i][j] = cumEngy[row][j + 1] + energies[i][j];
                } else {
                    pathTo[i][j] = j - 1;
                    cumEngy[i][j] = cumEngy[row][j - 1] + energies[i][j];
                }
            }
        }
        
        int minIdx = 0;
        double min = Integer.MAX_VALUE;
        for (int i = 0; i < width; i++) {
            if (min > cumEngy[height - 1][i]) {
                min = cumEngy[height - 1][i];
                minIdx = i;
            }
        }
        
        int[] seam = new int[height];
        for (int i = seam.length - 1; i > 0; i--) {
            seam[i] = minIdx;
            minIdx = pathTo[i][minIdx];
        }
        seam[0] = minIdx;
        return seam;
    }
    
    // remove horizontal seam from current picture
    public void removeHorizontalSeam(int[] seam) {
        if (null == seam)
            throw new NullPointerException();
        if (height() <= 1)
            throw new IllegalArgumentException();
        if (seam.length != width() || !isValidSeam(seam, height()))
            throw new IllegalArgumentException();
        
        Picture pit = new Picture(width(), height() - 1);
        int width = pit.width();
        int height = pit.height();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (i >= seam[j])
                    pit.set(j, i, picture.get(j, i + 1));
                else
                    pit.set(j, i, picture.get(j, i));
            }
        }
        
        picture = pit;
    }
    
    // remove vertical seam from current picture
    public void removeVerticalSeam(int[] seam) {
        if (null == seam)
            throw new NullPointerException();
        if (width() <= 1)
            throw new IllegalArgumentException();
        if (seam.length != height() || !isValidSeam(seam, width()))
            throw new IllegalArgumentException();
        
        Picture pit = new Picture(width() - 1, height());
        int width = pit.width();
        int height = pit.height();
        
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if (j >= seam[i])
                    pit.set(j, i, picture.get(j + 1, i));
                else
                    pit.set(j, i, picture.get(j, i));
            }
        }
        
        picture = pit;
    }
    
    private boolean isValidSeam(int[] seam, int boundary) {
        if (seam[0] >= boundary) 
            return false;
        for (int i = 1; i < seam.length; i++) {
            if (seam[i] >= boundary || Math.abs(seam[i] - seam[i - 1]) > 1)
                return false;
        }
        return true;
    }
    
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
