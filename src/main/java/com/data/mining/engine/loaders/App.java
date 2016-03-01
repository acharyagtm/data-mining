package com.data.mining.engine.loaders;


import com.data.mining.engine.api.loaders.Loader;

import java.util.HashMap;
import java.util.Map;


public class
        App {
    static Map<String, Class> loaders = new HashMap<String, Class>(); //Hash Map to hold all the job classes, gets added via the static block

    public static void main(String[] args) {
        String job = "testLoader";
        Loader loader = getLoader(job, loaders); //Load the respective loader class
        String trapInfo = loader.processJob(); //Call the processjob method that is overwritten by each of the loader class

        System.out.println("trapInfo = " + trapInfo);

    }

    static {
        loaders.put("testLoader", TestLoader.class);
    }

    public static Loader getLoader(String jobName, Map<String, Class> jobLoaders) {
        if (!jobLoaders.containsKey(jobName)) {
            throw new RuntimeException("no handler defined for the job with name: " + jobName);
        }

        return (Loader) getInstance(jobLoaders.get(jobName));
    }

    public static Object getInstance(Class cls) {
        try {
            return cls.newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

}
