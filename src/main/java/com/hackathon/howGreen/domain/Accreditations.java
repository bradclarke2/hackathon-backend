package com.hackathon.howGreen.domain;

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
}
