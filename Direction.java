import java.util.Scanner;

class Direction{
    
    public static double euclideanDistance(double x1, double y1, double x2, double y2){
        double  xSqr  = Math.pow(x1-x2, 2);
        double ySqr = Math.pow(y1-y2, 2);
        
        return Math.sqrt(xSqr + ySqr);
    }
    
    public static void solve(String[] lines){
        Double[] x_arr = new Double[lines.length];
        Double[] y_arr = new Double[lines.length];
        for(int k=0; k<lines.length; ++k){
            String[] str = lines[k].split(" ");
            int len = str.length;
            double x = Double.parseDouble(str[0]);
            double y = Double.parseDouble(str[1]);
            double angle = Double.parseDouble(str[3]);
            for(int i=4; i<len; i+=2){
                if(str[i].charAt(0) == 't'){
                    angle = angle + Double.parseDouble(str[i+1]);
                }
                if(str[i].charAt(0) == 'w'){
                    x = x + (Math.cos(Math.toRadians(angle)))*(Double.parseDouble(str[i+1]));
                    y = y + (Math.sin(Math.toRadians(angle)))*(Double.parseDouble(str[i+1]));
                }
            }
            x_arr[k] = x;
            y_arr[k] = y;
        }
        
        Double sx=0.0, sy=0.0;
        for(int i=0; i<lines.length; ++i){
            sx += x_arr[i];
            sy += y_arr[i];
        }
        
        double avg_x = sx/lines.length;
        double avg_y = sy/lines.length;
        
        double maxDist = 0.0;
        for(int i=0; i<lines.length; ++i){
            double dst = euclideanDistance(avg_x, avg_y, x_arr[i], y_arr[i]);
            if(dst > maxDist){
                maxDist = dst;
            }
        }
        
        System.out.println(avg_x + " " + avg_y + " " + maxDist);
        
    }
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n;
        String line;
        while(true){
            n = Integer.parseInt(sc.nextLine());
            if(n==0){
                break;
            }
            String[] lines = new String[n];
            for(int i=0; i<n; ++i){
                line = sc.nextLine();
                lines[i] = line;
            }
            solve(lines);
        }
        
        sc.close();
    }
}
