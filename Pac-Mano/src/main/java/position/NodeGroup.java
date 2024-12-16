package position;

import com.googlecode.lanterna.graphics.TextGraphics;
import helper.Transpose;

import java.util.*;

public class NodeGroup {
    public Map<List<Integer>, Node> nodesLut;
    String nodesymbol;
    String pathsymbol;
    List<Integer> homekey;

    public NodeGroup(String level) {
        nodesLut = new HashMap<List<Integer>, Node>();
        nodesymbol = "#";
        pathsymbol = ".";
        String[][] data = readMazeString();
        createNodeTable(data);
        connectHorizontally(data);
        connectVertically(data);
        setPortalPair();
        this.homekey = null;
    }

    String[][] readMazeString() {
        return new String[][]{
                {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"},
                {"X", "#", ".", ".", "#", ".", ".", ".", "#", "X", "#", ".", ".", ".", "#", ".", ".", "#", "X"},
                {"X", ".", "X", "X", ".", "X", "X", "X", ".", "X", ".", "X", "X", "X", ".", "X", "X", ".", "X"},
                {"X", ".", "X", "X", ".", "X", "X", "X", ".", "X", ".", "X", "X", "X", ".", "X", "X", ".", "X"},
                {"X", "#", ".", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#", ".", "#", ".", ".", "#", "X"},
                {"X", ".", "X", "X", ".", "X", ".", "X", "X", "X", "X", "X", ".", "X", ".", "X", "X", ".", "X"},
                {"X", "#", ".", ".", "#", "X", "#", ".", "#", "X", "#", ".", "#", "X", "#", ".", ".", "#", "X"},
                {"X", "X", "X", "X", ".", "X", "X", "X", ".", "X", ".", "X", "X", "X", ".", "X", "X", "X", "X"},
                {"X", "X", "X", "X", ".", "X", "#", ".", "#", "#", "#", ".", "#", "X", ".", "X", "X", "X", "X"},
                {"X", "X", "X", "X", ".", "X", ".", "X", "X", ".", "X", "X", ".", "X", ".", "X", "X", "X", "X"},
                {"#", "#", ".", ".", "#", ".", "#", "X", "#", "#", "#", "X", "#", ".", "#", ".", ".", "#", "#"},
                {"X", "X", "X", "X", ".", "X", ".", "X", "X", "X", "X", "X", ".", "X", ".", "X", "X", "X", "X"},
                {"X", "X", "X", "X", ".", "X", "#", ".", ".", ".", ".", ".", "#", "X", ".", "X", "X", "X", "X"},
                {"X", "X", "X", "X", ".", "X", ".", "X", "X", "X", "X", "X", ".", "X", ".", "X", "X", "X", "X"},
                {"X", "#", ".", ".", "#", ".", "#", ".", "#", "X", "#", ".", "#", ".", "#", ".", ".", "#", "X"},
                {"X", ".", "X", "X", ".", "X", "X", "X", ".", "X", ".", "X", "X", "X", ".", "X", "X", ".", "X"},
                {"X", "#", "#", "X", "#", ".", "#", ".", "#", "#", "#", ".", "#", ".", "#", "X", "#", "#", "X"},
                {"X", "X", ".", "X", ".", "X", ".", "X", "X", "X", "X", "X", ".", "X", ".", "X", ".", "X", "X"},
                {"X", "#", "#", ".", "#", "X", "#", ".", "#", "X", "#", ".", "#", "X", "#", ".", "#", "#", "X"},
                {"X", ".", "X", "X", "X", "X", "X", "X", ".", "X", ".", "X", "X", "X", "X", "X", "X", ".", "X"},
                {"X", "#", ".", ".", ".", ".", ".", ".", "#", ".", "#", ".", ".", ".", ".", ".", ".", "#", "X"},
                {"X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X", "X"},
        };
    }

    void createNodeTable(String[][] data) {
        for (int row = 0; row < data.length; row++) {
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col].equals(nodesymbol)) {
                    List<Integer> tuple = new ArrayList<>();
                    tuple.add(col);
                    tuple.add(row);
                    nodesLut.put(tuple, new Node(col * 16, row * 16));
                }
            }
        }
    }

    void connectHorizontally(String[][] data) {
        List<Integer> key;
        List<Integer> otherkey;
        for (int row = 0; row < data.length; row++) {
            key = null;
            for (int col = 0; col < data[row].length; col++) {
                if (data[row][col].equals(nodesymbol)) {
                    if (key == null) {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(col);
                        tuple.add(row);
                        key = tuple;
                    } else {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(col);
                        tuple.add(row);
                        otherkey = tuple;
                        nodesLut.get(key).neighbors.put("RIGHT", nodesLut.get(otherkey));
                        nodesLut.get(otherkey).neighbors.put("LEFT", nodesLut.get(key));
                        key = otherkey;
                    }
                } else if (!data[row][col] .equals(pathsymbol)) {
                    key = null;
                }
            }
        }
    }

    void connectVertically(String[][] data) {
        String[][] datat = Transpose.transpose(data.length, data[0].length, data);
        List<Integer> key;
        List<Integer> otherkey;
        for (int col = 0; col < datat.length; col++) {
            key = null;
            for (int row = 0; row < datat[col].length; row++) {
                if (datat[col][row].equals(nodesymbol)) {
                    if (key == null) {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(col);
                        tuple.add(row);
                        key = tuple;
                    } else {
                        List<Integer> tuple = new ArrayList<>();
                        tuple.add(col);
                        tuple.add(row);
                        otherkey = tuple;
                        nodesLut.get(key).neighbors.put("DOWN", nodesLut.get(otherkey));
                        nodesLut.get(otherkey).neighbors.put("UP", nodesLut.get(key));
                        key = otherkey;
                    }
                } else if (!datat[col][row].equals(pathsymbol)) {
                    key = null;
                }
            }
        }
    }

    /*public void draw(TextGraphics graphics) {
        for (Node n : nodesLut.values()) {
            n.draw(graphics);
        }
    }*/

    public Object getStartTempNode() {
        List<Integer> tuple = new ArrayList<>();
        tuple.add(9);
        tuple.add(16);
        return nodesLut.get(tuple);
    }

    public Object getStartTempNodeBlinky() {
        List<Integer> tuple = new ArrayList<>();
        tuple.add(8);
        tuple.add(10);
        return nodesLut.get(tuple);
    }

    public Object getStartTempNodePinky() {
        List<Integer> tuple = new ArrayList<>();
        tuple.add(9);
        tuple.add(10);
        return nodesLut.get(tuple);
    }

    public Object getStartTempNodeInky() {
        List<Integer> tuple = new ArrayList<>();
        tuple.add(9);
        tuple.add(8);
        return nodesLut.get(tuple);
    }

    public Object getStartTempNodeClyde() {
        List<Integer> tuple = new ArrayList<>();
        tuple.add(10);
        tuple.add(10);
        return nodesLut.get(tuple);
    }

    void setPortalPair() {
        List<Integer> key1 = new ArrayList<>();
        key1.add(0);
        key1.add(10);
        List<Integer> key12 = new ArrayList<>();
        key12.add(17);
        key12.add(10);
        List<Integer> key2 = new ArrayList<>();
        key2.add(18);
        key2.add(10);
        List<Integer> key21 = new ArrayList<>();
        key21.add(1);
        key21.add(10);
        nodesLut.get(key1).neighbors.put("PORTAL", nodesLut.get(key12));
        nodesLut.get(key2).neighbors.put("PORTAL", nodesLut.get(key21));
    }

}
