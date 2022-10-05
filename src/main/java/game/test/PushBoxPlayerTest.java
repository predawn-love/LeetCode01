package game.test;

import game.pushbox.Box;
import game.pushbox.BoxReturn;
import game.pushbox.NoBoxException;
import game.pushbox.PersonReachClass;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

import static game.pushbox.PushBoxPlayer.DIRECTIONS;

/**
 * 可以自己跑一个回合的测试类。
 */
public class PushBoxPlayerTest {

    public static String eg1 =
            "[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2]\n" +
            "[0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0]\n" +
            "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0]\n" +
            "[0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0]\n" +
            "[0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0]\n" +
            "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 4, 0, 0, 0]\n" +
            "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 4, 0, 0, 0]\n" +
            "[0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0]\n" +
            "[0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 4, 0, 0]\n" +
            "[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2]\n" +
            "[0, 0, 4, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n" +
            "[0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0]\n" +
            "[0, 0, 0, 4, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n" +
            "[0, 0, 0, 4, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n" +
            "[0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0]\n" +
            "[0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0]\n" +
            "[0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0]\n" +
            "[0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 0, 0, 0, 0, 0, 0, 0]\n" +
            "[1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 2]";

    public static void main(String[] args) throws NoBoxException {
        BoxReturn boxReturn = new PushBoxPlayerTest().minPushBox1(grid);
        System.out.println(boxReturn);
    }

    private static int N;
    private static int M;
    private static int PLAYER_ROLE = 2;
    private static int TARGET_Y;
    private static int[][] BOXES;
    private static int[][] PLAYERS;
    private static int[][] grid;

    static {
        grid = getMap();
        BOXES = new int[][]{{1,1}};
        if (PLAYER_ROLE == 2) {
            TARGET_Y = 0;
            PLAYERS = new int[][]{{0, grid[0].length - 1},{9, grid[0].length - 1}, {grid.length - 1, grid[0].length - 1}};
        } else {
            TARGET_Y = grid.length - 1;
            PLAYERS = new int[][]{{0, 0},{9, 0}, {grid.length - 1, 0}};
        }

    }

    public static int[][] getMap() {
        String inputS = replaceStr(eg1);
        String[] split = inputS.split("\n");
        int n = split.length;
        for (int i = 0; i < n; i++) {
            String s = split[i];
            s = s.replaceAll(" ", "");
            s = s.replaceAll("\\[", "");
            s = s.replaceAll("\\]", "");
            if (s.charAt(s.length() - 1) == ',') {
                s = s.substring(0, s.length() - 1);
            }
            split[i] = s;
        }

        int m = split[0].split(",").length;
        int[][] grid = new int[n][m];
        for (int i = 0; i < n; i++) {
            String[] split1 = split[i].split(",");
            for (int j = 0; j < m; j++) {
                grid[i][j] = Integer.valueOf(split1[j]);
            }
        }
        for (int[] cs : grid) {
            System.out.println(Arrays.toString(cs));
        }
        return grid;
    }

    public static String replaceStr(String eg) {
        return eg;
    }

    private  void log(String s) {
        System.out.println(s);
    }

    public BoxReturn minPushBox1(int[][] grid) throws NoBoxException {
        N = grid.length;
        M = grid[0].length;
        log("Map- N :" + N + ", M:" + M + "\n");

        // 找出箱子起点/终点，人的初始位置
        // 循环取箱子
        int[] boxPosition = getBox();
        int startX = boxPosition[0];
        int startY = boxPosition[1];
        log("BOX- startX :" + startX + ", startY:" + startY + "\n");

        // 固定取角色 0 或 1. FIXME: 修改成固定取角色0或2了
        int personX;
        int personY;
        if (PLAYER_ROLE == 1) {
            personX = PLAYERS[0][0];
            personY = PLAYERS[0][1];
        } else {
            personX = PLAYERS[2][0];
            personY = PLAYERS[2][1];
        }
        log("personX :" + personX + ", personY:" + personY + "\n");

        grid[personX][personY] = 0;

        // 初始化队列，加入元素以启动BFS
        boolean[][][] visited = new boolean[N][M][4];
        Queue<Box> queue = new LinkedList<>();
        for (int i = 0; i < 4; i++) {
            int[] direction = DIRECTIONS[i];
            PersonReachClass personReachClass = personCanReach(grid, N, M, personX, personY, startX - direction[0], startY - direction[1], new boolean[N][M], i);
            if (personReachClass.canReach) {
                Box box = new Box(startX, startY, i, personReachClass);
                queue.add(box);
                log(box + "\n");
                visited[startX][startY][i] = true;
            }
        }
        log("queue.size() = " + queue.size() + "\n");

        // 以箱子的视角开始BFS
        int step = 0;
        boolean firstPush = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size-- > 0) {
                Box box = queue.poll();
                grid[box.x][box.y] = 3;
                personX = box.x - DIRECTIONS[box.from][0];
                personY = box.y - DIRECTIONS[box.from][1];
                if (box.y == TARGET_Y) {
                    BoxReturn boxReturn = new BoxReturn(step, box.fromList, box.personReachClass.fromList);
                    return boxReturn;
                }

                // 箱子推的第一步一定是小人的位置所在往箱子发力。
                if (firstPush) {
                    int nextX = box.x + DIRECTIONS[box.personReachClass.howToPushBox][0];
                    int nextY = box.y + DIRECTIONS[box.personReachClass.howToPushBox][1];

                    // 人是否能绕到箱子的后面？
                    PersonReachClass personReachClass = personCanReach(grid, N, M, personX, personY, box.x - DIRECTIONS[box.personReachClass.howToPushBox][0], box.y - DIRECTIONS[box.personReachClass.howToPushBox][1], new boolean[N][M], box.personReachClass.howToPushBox);
                    if (!personReachClass.canReach) {
                        continue;
                    }
                    // 箱子的下个位置是否合法？
                    if (!isValid(grid, N, M, nextX, nextY)) {
                        continue;
                    }
                    // 箱子的下一个状态是不是重复了？
                    if (visited[nextX][nextY][box.personReachClass.howToPushBox]) {
                        continue;
                    }
                    queue.add(new Box(nextX, nextY, box.personReachClass.howToPushBox, box));
                    visited[nextX][nextY][box.personReachClass.howToPushBox] = true;
                    grid[box.x][box.y] = 0;
                } else {
                    for (int i = 0; i < 4; i++) {
                        int[] direction = DIRECTIONS[i];
                        int nextX = box.x + direction[0];
                        int nextY = box.y + direction[1];

                        // 人是否能绕到箱子的后面？
                        PersonReachClass personReachClass = personCanReach(grid, N, M, personX, personY, box.x - direction[0], box.y - direction[1], new boolean[N][M], i);
                        if (!personReachClass.canReach) {
                            continue;
                        }
                        // 箱子的下个位置是否合法？
                        if (!isValid(grid, N, M, nextX, nextY)) {
                            continue;
                        }
                        // 箱子的下一个状态是不是重复了？
                        if (visited[nextX][nextY][i]) {
                            continue;
                        }
                        queue.add(new Box(nextX, nextY, i, box));
                        visited[nextX][nextY][i] = true;
                    }
                    grid[box.x][box.y] = 0;
                }
            }
            step++;
            firstPush = false;
        }

        return new BoxReturn();
    }

    // 人是否可以某一位置(startX, startY)到达另一位置(targetX, targetY)
    private PersonReachClass personCanReach(int[][] grid, int m, int n, int startX, int startY, int targetX,
                                            int targetY, boolean[][] visited, int from) {
        if (startX == targetX && startY == targetY) {
            PersonReachClass personReachClass = new PersonReachClass();
            personReachClass.canReach = true;
            personReachClass.howToPushBox = from;
            return personReachClass;
        }
        visited[startX][startY] = true;

        // TODO: 要记录下来人的路径。
        Queue<PersonReachClass> queue = new ArrayDeque<>();
        queue.add(new PersonReachClass(startX, startY));
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                size--;
                PersonReachClass poll = queue.poll();

                // 这里是返回 PersonReachClass 的地方。
                if (poll.x == targetX && poll.y == targetY) {
                    poll.canReach = true;
                    poll.howToPushBox = from;
                    return poll;
                }
                for (int i = 0; i < DIRECTIONS.length; i++) {
                    int nextX = poll.x + DIRECTIONS[i][0];
                    int nextY = poll.y + DIRECTIONS[i][1];
                    if (isValid(grid, m, n, nextX, nextY) && !visited[nextX][nextY]) {
                        // 详细处理
                        visited[nextX][nextY] = true;
                        queue.add(new PersonReachClass(nextX, nextY, i, poll.fromList));
                    }
                }
            }
        }
        return new PersonReachClass();
    }

    // 某位置是否可以踏足
    private boolean isValid(int[][] grid, int m, int n, int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0;
    }

    private int[] getBox() {
        if (PLAYER_ROLE == 1) {
            for (int[] ints : BOXES) {
                if (ints[1] == TARGET_Y) {
                    continue;
                }
                return ints;
            }
        } else {
            for (int i = BOXES.length - 1; i >= 0; i--) {
                if (BOXES[i][1] == TARGET_Y) {
                    continue;
                }
                return BOXES[i];
            }
        }
        return null;
    }
}
