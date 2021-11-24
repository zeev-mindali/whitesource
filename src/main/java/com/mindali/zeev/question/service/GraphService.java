package com.mindali.zeev.question.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mindali.zeev.question.controller.LogController;
import com.mindali.zeev.question.exceptions.JsonException;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Graph service for getting request to check a graph non reachable nodes.
 */
@Service
@RequiredArgsConstructor
public class GraphService {
    public final UserData userData;
    private static final Logger logger = LoggerFactory.getLogger(LogController.class);

    /**
     *
     * @param data user data from json structure body
     * @return return set of non reachable nodes
     * @throws JsonException to handle bad json structure
     */
    public Set<Integer> getNonReach(String data) throws JsonException {
        try {
            return userData.nonReach(data);
        } catch (JsonProcessingException e) {
            System.out.println("Error in JSON format\n"+e.getMessage());
            logger.error("Error in Json format:\n====================\n"+data);
            throw new JsonException("Error in Json format");
        }
    }
}
