package net.telestream.cloud;

import net.telestream.cloud.objects.Factory;
import net.telestream.cloud.services.FactoryService;

/**
 * Created by maciejwitowski on 1/18/16.
 */
public class Flip implements Resource<Factory> {

    private final FactoryService factoryService;

    public Flip(TelestreamCloudCredentials credentials) {
        this.factoryService = new FactoryService(credentials);
    }

    @Override
    public FactoryService factoryService() {
        return factoryService;
    }
}
