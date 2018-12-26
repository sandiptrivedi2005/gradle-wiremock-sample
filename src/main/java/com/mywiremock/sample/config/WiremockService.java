package com.mywiremock.sample.config;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.common.ConsoleNotifier;
import com.github.tomakehurst.wiremock.stubbing.StubMapping;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import static com.github.tomakehurst.wiremock.core.WireMockConfiguration.options;

/**
 * Created by sandip.t on 12/26/2018.
 */
@Component
public class WiremockService {

    private  WireMockServer mockServer;

    @PostConstruct
    public void startServer(){
        String path = "C:\\Users\\sandip.t\\IdeaProjects\\gradle-wiremock-sample\\src\\main\\resources";
        int port = 8089;
        mockServer = new WireMockServer(options()
                .port(port)
                        //   .usingFilesUnderClasspath("mappings")
                .usingFilesUnderDirectory(path)
                .notifier(new ConsoleNotifier(true))
        );

        mockServer.start();
        System.out.println("Found mappings: " + mockServer.getStubMappings().size());

        for (StubMapping stubMapping : mockServer.getStubMappings()) {
            System.out.println(stubMapping.getId());
        }
    }

    @PreDestroy
    public void shutdown(){
        System.out.println("Shutting down wiremock server");
        if(mockServer != null &&  mockServer.isRunning()){
            mockServer.shutdown();
        }
    }

}
