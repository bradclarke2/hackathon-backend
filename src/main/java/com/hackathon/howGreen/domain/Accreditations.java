package com.hackathon.howGreen.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Accreditations {
    private Boolean rainforestAlliance;
    private Boolean fairTrade;
    private Boolean marineStewardshipCouncil;

    public Accreditations() {
    }

    public Accreditations(Boolean rainforestAlliance, Boolean fairTrade, Boolean marineStewardshipCouncil) {
        this.rainforestAlliance = rainforestAlliance;
        this.fairTrade = fairTrade;
        this.marineStewardshipCouncil = marineStewardshipCouncil;
    }

    public Boolean getRainforestAlliance() {
        return rainforestAlliance;
    }

    public Boolean getFairTrade() {
        return fairTrade;
    }

    public Boolean getMarineStewardshipCouncil() {
        return marineStewardshipCouncil;
    }

    @JsonIgnore
    public ArrayList<Object> getAccreditationsAsList(){
        ArrayList<Object> list = new ArrayList<>();
        list.add(rainforestAlliance);
        list.add(fairTrade);
        list.add(marineStewardshipCouncil);
        return list;
    }
}
