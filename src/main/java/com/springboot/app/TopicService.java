package com.springboot.app;

import org.springframework.stereotype.Service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class TopicService {
    private List<Topic> topics = new ArrayList<>(Arrays.asList( //AJOUT DE NEW ARRAY LORS DU POST POUR POUVOIR AJOUTER DES NOUVEAUX ELEMENTS
            new Topic("spring", "spring framework", "spring framework description"),
            new Topic("java", "core java", "core java description"),
            new Topic("javascript", "javascript", "javascript description")
    ));

    //méthode qui récupère la liste topics déclarée plus haut
    public List<Topic> getAllTopics() { //GET ALL
        return topics;
    }

    public Topic getTopic(String id) { //GET EN FONCTION DE L'ID
        return topics.stream().filter(t -> t.getId().equals(id)).findFirst().get(); //compare l'id d'un topic, récupère le 1er topic et le retourne
    }

    public void addTopic(Topic topic) {  //POST
        topics.add(topic);
    }

    public void updateTopic(String id, Topic topic) {
        for (int i =0 ; i < topics.size(); i++) {
            Topic t = topics.get(i);
            if (t.getId().equals(id)) {
                topics.set(i, topic);
                return;
            }
        }
    }

    public void deleteTopic(String id) {
        topics.removeIf(t ->t.getId().equals(id));
    }
}
