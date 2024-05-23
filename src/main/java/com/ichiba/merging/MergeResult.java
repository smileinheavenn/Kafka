package com.ichiba.merging;

import io.vertx.core.json.JsonObject;

import java.util.List;

public class MergeResult {
    private JsonObject winner;
    private List<JsonObject> losers;

    public MergeResult(JsonObject winner, List<JsonObject> losers) {
        this.winner = winner;
        this.losers = losers;
    }

    public JsonObject getWinner() {
        return winner;
    }

    public List<JsonObject> getLosers() {
        return losers;
    }
}
