package game.pushbox;

import static box.plat.PushBoxApi.log;
import box.plat.PushBoxApi;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


/**
 * 比赛的要求就是自己写一个 PushBoxPlayer 类，类里面提供 play() 方法
 *      对 play() 方法的要求是 ： 在 play() 方法执行的末尾调用  PushBoxApi.push(int x, int y, int dir); 方法。
 *      服务器会根据提交的 push 动作，判断动作是否生效，
 *      无效的话相当于该轮次无动作（浪费一回合），
 *      生效的话服务器会执行操作，但并不会给 PushBoxPlayer 返回任何信息，所以每一回合需要去扫描全图获取信息。
 *
 *      box.plat.PushBoxApi.log 这个类是服务器提供的，所以看不见，代码会报红是正常的，总共有如下 api
 *
 *
 *      获得 [x, y] 格子上的情况  队伍角色分别为 1 和 2， 方块为 3， 障碍物为 4，平坦的路为 0
 *     public static native int getGridInfo(int x, int y);
 *
 *     返回你的队伍角色你是队伍 1 或 队伍 2
 *     public static native int whoami();
 *
 *      执行推箱子的命令 【x，y】 这个格子上的小人 往 dir 方向用力推箱子。（x，y没有己方小人视为无效命令）
 *     public static native void push(int x, int y, int dir);
 *
 *      记录 log 到服务器日志
 *     public static native void log(String var0);
 *
 *
 *
 *     这个主体代码是由 leetcode 上的这个题解直接复制过来修改的。
 *     https://leetcode.cn/problems/minimum-moves-to-move-a-box-to-their-target-location/solution/tong-su-yi-dong-dai-ma-dai-zhu-shi-java-mi4f6/
 *
 *     目前类支持的功能，固定 队伍1 选择扫描全图能获得的 第一个 1 号小人，然后按 顺序检索扫描全图能获得到的箱子，推到地图最右侧一列。
 *     目前类支持的功能，固定 队伍2 选择扫描全图能获得的 第三个 2 号小人，然后按 逆序检索扫描全图能获得到的箱子，推到地图最左侧一列。
 */
public class PushBoxPlayer {
    public static boolean NEED_INIT = true;

    // 队伍角色分别为 1 和 2， 方块为 3， 障碍物为 4.
    public static int[][] GAME_MAP = new int[19][19];

    // 三个队员各自的x， y坐标 PLAYERS[1][0] 为第二个队员 x坐标， PLAYERS[1][2] 为第二个队员 y坐标
    public static int[][] PLAYERS = new int[3][2];

    // 16个箱子各自的 x，y 坐标
    public static int[][] BOXES = new int[16][2];

    // 如果 PLAYER_ROLE 取到 1，则需要把方块推到[x, 18]。
    // 如果 PLAYER_ROLE 取到 2，则需要把方块推到[x, 0]。
    public static int PLAYER_ROLE;

    // 要把箱子推至某一列可得分，队伍1推到第18列，队伍2推到第0列
    public static int TARGET_Y;

    // 地图大小
    private static int N;
    private static int M;

    // 其含义是从【上】【下】【左】【右】
    public final static int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    /**
     * 先默认取小人(队伍1取小人1，队伍2取小人2)， 然后从 Boxes 数组里从头取到尾。
     */
    public void play() {
        if (NEED_INIT) {
            init();
        }

        int playerNum = 0;
        int boxNum = 0;
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                GAME_MAP[x][y] = PushBoxApi.getGridInfo(x, y);
                if (GAME_MAP[x][y] == PLAYER_ROLE) {
                    PLAYERS[playerNum][0] = x;
                    PLAYERS[playerNum++][1] = y;
                } else if (GAME_MAP[x][y] == 3) {
                    BOXES[boxNum][0] = x;
                    BOXES[boxNum++][1] = y;
                }
            }
        }
        PushBoxApi.log("Record map log......" + "\n");
        for (int[] ints : GAME_MAP) {
            PushBoxApi.log(Arrays.toString(ints) + "\n");
        }
        PushBoxApi.log("Record map log complete" + "\n");

        PushBoxApi.log("My player role is " + PLAYER_ROLE + "\n");

        /**
         * TODO: 1、
         */
        BoxReturn boxReturn = null;
        try {
            log("PLAYERS :\n");
            for (int i = 0; i < PLAYERS.length; i++) {
                log(PLAYERS[i][0] + "," + PLAYERS[i][1] + "\n");
            }
            log("BOXES :\n");
            for (int i = 0; i < BOXES.length; i++) {
                log(BOXES[i][0] + "," + BOXES[i][1] + "\n");
            }
            log("TARGET_Y :" + TARGET_Y + "\n");
            boxReturn = minPushBox(GAME_MAP);
            log("Result - boxReturn : \n");
            log(boxReturn.toString() + "\n");
        } catch (NoBoxException e) {
            PushBoxApi.log(e.code + ":" + e.message);
        }

        // 要么无解，要么说明人就贴在箱子边上。 先不考虑无解
        int player;
        if (PLAYER_ROLE == 2) {
            player = 2;
        } else {
            player = 0;
        }
        if (boxReturn.personFromList == null || boxReturn.personFromList.isEmpty()) {
            PushBoxApi.push(PLAYERS[player][0], PLAYERS[player][1], boxReturn.list.get(0));
        } else {
            PushBoxApi.push(PLAYERS[player][0], PLAYERS[player][1], boxReturn.personFromList.get(0));
        }
    }

    private void init() {
        int playerNum = 0;
        int boxNum = 0;
        PLAYER_ROLE = PushBoxApi.whoami();
        for (int x = 0; x < 19; x++) {
            for (int y = 0; y < 19; y++) {
                GAME_MAP[x][y] = PushBoxApi.getGridInfo(x, y);
                if (GAME_MAP[x][y] == PLAYER_ROLE) {
                    PLAYERS[playerNum][0] = x;
                    PLAYERS[playerNum++][1] = y;
                } else if (GAME_MAP[x][y] == 3) {
                    BOXES[boxNum][0] = x;
                    BOXES[boxNum++][1] = y;
                }
            }
        }
        if (PLAYER_ROLE == 1) {
            TARGET_Y = 18;
        } else {
            TARGET_Y = 0;
        }
        NEED_INIT = false;
    }

    /**
     * 【BFS+DFS】
     * 以箱子的视角进行BFS
     * 以人的视角进行DFS
     * 后者作为前者得以进行的前提
     */

    public BoxReturn minPushBox(int[][] grid) throws NoBoxException {
        N = 19;
        M = 19;
        log("Map- N :" + N + ", M:" + M + "\n");

        // 找出箱子起点/终点，人的初始位置
        // 循环取箱子
        int[] boxPosition = getBox();
        int startX = boxPosition[0];
        int startY = boxPosition[1];
        log("BOX- startX :" + startX + ", startY:" + startY + "\n");

        // 固定取角色 0 或 2.
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
//                    System.out.println(boxReturn);
                    return boxReturn;
                }

                // 箱子推的第一步一定是小人的位置所在往箱子发力。(自己加的if{}，原本这里只有else内的内容，我不确定加的有没有意义)
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

    /**
     * 循环获取要计算哪个箱子，拿到箱子的 [x, y] 坐标（顺序固定）
     */
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


