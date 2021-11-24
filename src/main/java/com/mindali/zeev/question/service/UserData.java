package com.mindali.zeev.question.service;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mindali.zeev.question.beans.GraphPoint;
import com.mindali.zeev.question.beans.MyGraph;
import com.mindali.zeev.question.controller.LogController;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Data
@NoArgsConstructor
@Service
@Slf4j
public class UserData {
    //user data
    private String data;
    //graph structure
    private Map<Integer, TreeSet<Integer>> graph = new HashMap<>();
    //nodes list
    private List<GraphPoint> nodes;
    //E1 -> entry point
    private int enteryPoint;
    //logger controller
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    //data stream
    private Stream<String> stream;

    /**
     *
     * @param data get user data for checking
     * @return a set of non reachable nodes
     * @throws JsonProcessingException to handle errors in json processong
     */
    public Set<Integer> nonReach(String data) throws JsonProcessingException {
        makeGraph(data);
        Set<Integer> results = new TreeSet<>();
        for (Map.Entry<Integer, TreeSet<Integer>> entery : graph.entrySet()) {
            if (entery.getKey() == enteryPoint) {
                continue;
            }
            if (!graph.get(enteryPoint).contains(entery.getKey())) {
                results.add(entery.getKey());
                results.addAll(entery.getValue());
            }

        }
        logger.debug("User Request", data);
        logger.debug("User Result", results);

        return results;
    }

    /**
     *
     * @param data get user data
     * @throws JsonProcessingException catch processing exceptions
     */
    private void makeGraph(String data) throws JsonProcessingException {
        //using ObjectMapper instead of Google GSON
        ObjectMapper objectMapper = new ObjectMapper();
        //create our graph
        MyGraph myGraph = objectMapper.readValue(data, MyGraph.class);
        //createing Entery point
        enteryPoint = Integer.parseInt(myGraph.getE1());
        //add entry point to our graph
        graph.put(enteryPoint, new TreeSet<>());

        //get graph data for calculation...
        String graphData = myGraph.getGraph().substring(myGraph.getGraph().indexOf('{') + 2, myGraph.getGraph().indexOf('}'));

        //get single data
        stream = Stream.of(graphData.split("\n"));

        //create graph nodes
        nodes = stream
                .map(item -> new GraphPoint(
                        item.split("->")[0],
                        item.split("->")[1]
                ))
                .collect(Collectors.toList());

        //iterate on nodes
        nodes.forEach(this::addNode);
    }

    /**
     * adding a single node to our graph
     * @param singleNode a single node representation
     */
    private void addNode(GraphPoint singleNode) {
        //check if we don't have the node on our graph
        if (!graph.containsKey(singleNode.getNode())) {
            graph.put(singleNode.getNode(), new TreeSet<>());
        }
        //add node
        TreeSet<Integer> nodeTree = graph.get(singleNode.getNode());
        //add leaf
        nodeTree.add(singleNode.getLeaf());
        //check if leaf is entry point node.
        if (singleNode.getLeaf() == enteryPoint) {
            TreeSet<Integer> entryTree = graph.get(enteryPoint);
            entryTree.add(singleNode.getNode());
        }
        graph.put(singleNode.getNode(), nodeTree);
    }



}
