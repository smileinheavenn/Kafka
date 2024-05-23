package com.ichiba.merging;

import io.vertx.core.json.JsonObject;

import java.util.ArrayList;
import java.util.List;

public interface Merger {
    static List<JsonObject> process(MergeResult mergeResult) {
        List<JsonObject> allDocs = new ArrayList<>();
        // Set all losing documents to deleted
        mergeResult.getLosers().forEach(l -> l.put("_deleted", true));
        // Add losing documents to allDocs collection
        allDocs.addAll(mergeResult.getLosers());
        // Add the winner to the collection
        allDocs.add(mergeResult.getWinner());
        // Return all deleted documents and winning document in one collection
        return allDocs;
    }

    MergeResult merge(JsonObject newDoc, JsonObject latestRev, List<JsonObject> conflictingDocs);
}
