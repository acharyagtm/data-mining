package com.data.mining.engine.api.loaders;

import cascading.flow.Flow;
import cascading.flow.FlowDef;
import cascading.flow.hadoop.HadoopFlowConnector;
import cascading.operation.DebugLevel;
import cascading.property.AppProps;

import java.util.Properties;

/**
 * Created by sujshakya on 2/2/16.
 */
public abstract class BaseLoader implements Loader {

    protected static final String DELIMITER = "|";
    protected FlowDef flowDef = new FlowDef();

    protected Flow getFlow(Class loader) {
        Properties properties = new Properties();
        AppProps.setApplicationName(properties, loader.getName() + "_Job");
        AppProps.setApplicationJarClass(properties, loader.getClass());
        return new HadoopFlowConnector(properties).connect(flowDef);
    }

    protected void setDebugLevelForFlowDef() {
        flowDef.setDebugLevel(DebugLevel.NONE);
    }
}
