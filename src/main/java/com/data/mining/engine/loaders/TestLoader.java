package com.data.mining.engine.loaders;


import com.data.mining.engine.api.loaders.BaseLoader;
import com.data.mining.engine.api.loaders.Loader;
import org.apache.commons.cli.CommandLine;

/**
 * Created by sujshakya on 2/1/16.
 */
public class TestLoader extends BaseLoader implements Loader {


    @Override
    public String processJob() {

        return "PROCESS COMPLETED";
    }
}

