package tinkoff;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.Vector;

public class OrienteeringSolution {

    public static void main(String[] args) {
        try(BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in))) {
            int N = Integer.parseInt(bufferedReader.readLine());
            int[][] matrix = new int[N][N];

            for (int i = 0; i < N; i++) {
                String[] paths = bufferedReader.readLine().split("\\s+");
                for (int j = 0; j < N; j++)
                    matrix[i][j] = Integer.parseInt(paths[j]);
            }

            String[] points = bufferedReader.readLine().split("\\s+");
            int start = Integer.parseInt(points[0]) - 1;
            int end = Integer.parseInt(points[points.length - 1]) - 1;

            Vector<Integer> pars = new Vector<Integer>();
            int[] ds;

            ds = shortest.find(matrix, start, pars);
            shortest.show_path(System.out, start, end, pars, ds);

        } catch (Exception e) {
            e.printStackTrace();
        }
     }
}

final class shortest {
    public static int[] find(int[][] m, int start, Vector<Integer> pars){
        int[] ds = new int[m.length];
        for(int i = 0; i < ds.length; ++i)
            ds[i] = Integer.MAX_VALUE;

        boolean[] visit = new boolean[m.length];
        pars.setSize(m.length);

        ds[start] = 0;
        int sel;
        for(int i = 0; i < m.length; ++i){
            sel = -1;
            for(int j = 0; j < m[i].length; ++j){
                if(!visit[j] && (sel == -1 || ds[j] < ds[sel]))
                    sel = j;
            }

            if(ds[sel] == Integer.MAX_VALUE)
                break;
            visit[sel] = true;

            for(int j = 0; j < m[sel].length; ++j){
                if(m[sel][j] == 0)
                    continue;
                if((ds[sel] + m[sel][j]) < ds[j]){
                    ds[j] = ds[sel] + m[sel][j];
                    pars.set(j, sel);
                }
            }
        }
        return ds;
    }

    public static void show_path(PrintStream _out, int start, int end, Vector<Integer> pars, int[] ds) throws Exception {
        if(end >= ds.length || ds[end] == Integer.MAX_VALUE)
            return;
        _out.println(ds[end]);

        Vector<Integer> ps = new Vector<Integer>();
        for(int i = end; i != start; i = pars.get(i))
            ps.add(i);
        ps.add(start);

        for(int i = ps.size() - 1; i >= 0; --i)
            _out.print( (ps.get(i) + 1) + "  ");
        ps.clear();
    }
}