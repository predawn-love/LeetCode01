package game.pushbox;

import java.util.ArrayList;

/**
 * 记录人的跑步路径的实体类
 */
public class PersonReachClass {
    public boolean canReach = false;
    public int x;
    public int y;

    // 0、1、2、3 分别表示人在箱子的下、上、右、左；因为这样才能把箱子往上、下、左、右去推。
    public int howToPushBox;

    public ArrayList<Integer> fromList = new ArrayList<>();

    public PersonReachClass() {
    }

    public PersonReachClass(int howToPushBox) {
        this.howToPushBox = howToPushBox;
    }

    public PersonReachClass(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public PersonReachClass(int x, int y, int from) {
        this.x = x;
        this.y = y;
        ArrayList<Integer> fromList = new ArrayList<>();
        fromList.add(from);
        this.fromList = fromList;
    }

    public PersonReachClass(int x, int y, int from, ArrayList<Integer> list) {
        this.x = x;
        this.y = y;
        ArrayList<Integer> fromList = new ArrayList<>(list);
        fromList.add(from);
        this.fromList = fromList;
    }

    public PersonReachClass(int x, int y, boolean canReach) {
        this.canReach = canReach;
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "PersonReachClass{" +
                "canReach=" + canReach +
                ", x=" + x +
                ", y=" + y +
                ", howToPushBox=" + howToPushBox +
                ", fromList=" + fromList +
                '}';
    }
}
