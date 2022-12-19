package Sprint_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class K {

    public static long DIST = 20 * 20;
    public static long GRID_SIZE = 20;

    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            List<int[]> metro = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                metro.add(Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            int m = Integer.parseInt(reader.readLine());
            List<int[]> bus = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                bus.add(Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray());
            }
            Map<Long, Map<Long, List<int[]>>> stations = new HashMap<>();
            for (int i = 0; i < bus.size(); i++) {
                long sectorX = getSector(bus.get(i)[0]);
                long sectorY = getSector(bus.get(i)[1]);
                Map<Long, List<int[]>> subMap = stations.getOrDefault(sectorX, new HashMap<>());
                List<int[]> list = subMap.getOrDefault(sectorY, new ArrayList<>());
                list.add(bus.get(i));
                subMap.putIfAbsent(sectorY, list);
                stations.putIfAbsent(sectorX, subMap);
            }
            int best = 1;
            int maxCount = 0;
            for (int i = 0; i < metro.size(); i++) {
                long sectorX = getSector(metro.get(i)[0]);
                long sectorY = getSector(metro.get(i)[1]);
                int count = 0;
                for (int dx = -1; dx <= 1; dx++) {
                    Map<Long, List<int[]>> subMap = stations.get(sectorX + dx);
                    if (subMap != null) {
                        for (int dy = -1; dy <= 1; dy++) {
                            List<int[]> coords = subMap.get(sectorY + dy);
                            if (coords != null) {
                                for(int[] coord : coords) {
                                    if (isNear(coord[0], metro.get(i)[0], coord[1], metro.get(i)[1])) {
                                        count++;
                                    }
                                }
                            }
                        }
                    }
                }
                if (count > maxCount) {
                    best = i + 1;
                    maxCount = count;
                }
            }
            System.out.println(best);
        }
    }

    public static boolean isNear(int x1, int x2, int y1, int y2) {
        long x = x1 - x2;
        long y = y1 - y2;
        return x * x + y * y <= DIST;
    }

    public static long getSector(int coord) {
        if (coord >= 0) {
            return coord / GRID_SIZE;
        } else {
            return -(-coord / GRID_SIZE + 1);
        }
    }
}
