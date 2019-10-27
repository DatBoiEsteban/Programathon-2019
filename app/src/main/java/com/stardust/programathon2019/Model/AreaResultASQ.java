package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaResultASQ {
    int areaId;

    List<ResultASQ> results;

    public AreaResultASQ() {
    }

    public AreaResultASQ(int areaId, List<ResultASQ> results) {
        this.areaId = areaId;
        this.results = results;
    }

    public List<ResultASQ> getResults() {
        return results;
    }

    public int getAreaId() {
        return areaId;
    }

    public void setAreaId(int areaId) {
        this.areaId = areaId;
    }

    public void setResults(List<ResultASQ> results) {
        this.results = results;
    }
}
