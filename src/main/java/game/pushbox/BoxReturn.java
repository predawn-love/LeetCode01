package game.pushbox;

import java.util.ArrayList;

/**
 * 单纯用来返回结果的实体属性类
 */
public class BoxReturn {
    public int step;
    public ArrayList<Integer> list;
    public ArrayList<Integer> personFromList;

    public BoxReturn() {
        step = -1;
    }

    public BoxReturn(int step, ArrayList<Integer> list, ArrayList<Integer> personFromList) {
        this.step = step;
        this.list = list;
        this.personFromList = personFromList;
    }

    @Override
    public String toString() {
        return "BoxReturn{" +
                "step=" + step +
                ", list=" + list +
                ", personFromList=" + personFromList +
                '}';
    }
}
