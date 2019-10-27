package com.stardust.programathon2019.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AreaResult {
    int areaId;

    List<ResultASQ> results;

    public AreaResult() {
    }

    public AreaResult(int areaId, List<ResultASQ> results) {
        this.areaId = areaId;
        this.results = results;
    }

    public List<ResultASQ> getResults() {
        return results;
    }

    public int getAreaId() {
        return areaId;
    }
}
