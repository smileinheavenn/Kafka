package com.ichiba;


import org.apache.kafka.common.config.ConfigDef;
import org.apache.kafka.connect.connector.Task;
import org.apache.kafka.connect.sink.SinkConnector;

import java.util.List;
import java.util.Map;

public class CouchDBSinkConnector extends SinkConnector {
    private CouchDBConnectorConfig config;

    @Override
    public String version() {
        return VersionUtil.getVersion();
    }

    @Override
    public void start(Map<String, String> map) {
        config = new CouchDBConnectorConfig(map);
    }

    @Override
    public Class<? extends Task> taskClass() {
        return CouchDBSinkTask.class;
    }

    @Override
    public List<Map<String, String>> taskConfigs(int maxTasks) {
        return config.getTaskConfigs(maxTasks);
    }

    @Override
    public void stop() {
    }

    @Override
    public ConfigDef config() {
        return CouchDBConnectorConfig.config;
    }
}

