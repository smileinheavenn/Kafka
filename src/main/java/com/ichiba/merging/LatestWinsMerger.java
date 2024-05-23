package com.ichiba.merging;


import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

public class LatestWinsMerger implements Merger {
    @Override
    public MergeResult merge(JsonObject newDoc, JsonObject latestRev, List<JsonObject> conflictingDocs) {
        List<JsonObject> losers = new ArrayList<>();
        losers.add(latestRev);
        losers.addAll(conflictingDocs);

        return new MergeResult(newDoc, losers);
    }
}