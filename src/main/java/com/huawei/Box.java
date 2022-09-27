package com.huawei;

import java.util.ArrayList;

/**
 * Box 的属性类。
 *
 */
public class Box {
    // 坐标
    public int x;
    public int y;

    // 从哪个方向推
    public int from;

    // 记录当前状态的 box，是怎么一步一步被推过来的，0位元素表示一开始站哪边，1位元素表示当前解第一步要怎么推。
    public ArrayList<Integer> fromList = new ArrayList<>();

    // 假如人不在箱子旁，记录人怎么一步一步跑到箱子旁边
    public PersonReachClass personReachClass = new PersonReachClass();

    public Box(int x, int y, int from, PersonReachClass personReachClass) {
        this.x = x;
        this.y = y;
        this.from = from;
        this.personReachClass = personReachClass;
    }

    public Box(int x, int y, int from, Box box) {
        this.x = x;
        this.y = y;
        this.from = from;
        ArrayList<Integer> fromList = new ArrayList<>(box.fromList);
        fromList.add(from);
        this.fromList = fromList;
        this.personReachClass = box.personReachClass;
    }

    @Override
    public String toString() {
        return "Box{" +
                "x=" + x +
                ", y=" + y +
                ", from=" + from +
                ", personReachClass=" + personReachClass +
                ", fromList=" + fromList +
                '}';
    }
}
