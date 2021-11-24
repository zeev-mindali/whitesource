package com.mindali.zeev.question.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GraphPoint {
    private Integer node;
    private Integer leaf;

    public GraphPoint(String node, String leaf) {
        //convert string from json into Integer node and Leaf
        this.node = Integer.parseInt(node);
        this.leaf = Integer.parseInt(leaf);
    }
}
