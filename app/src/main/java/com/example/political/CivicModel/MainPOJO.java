package com.example.political.CivicModel;

import java.util.ArrayList;

public class MainPOJO {
    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public ArrayList<ListClass> getElections() {
        return elections;
    }

    public void setElections(ArrayList<ListClass> elections) {
        this.elections = elections;
    }

    String kind = "civicinfo#electionsQueryResponse";
    ArrayList<ListClass> elections;

    public class ListClass {
        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getElectionDay() {
            return electionDay;
        }

        public void setElectionDay(String electionDay) {
            this.electionDay = electionDay;
        }

        public String getOcdDivisionId() {
            return ocdDivisionId;
        }

        public void setOcdDivisionId(String ocdDivisionId) {
            this.ocdDivisionId = ocdDivisionId;
        }

        String id;
        String name;
        String electionDay;
        String ocdDivisionId;
    }
}
